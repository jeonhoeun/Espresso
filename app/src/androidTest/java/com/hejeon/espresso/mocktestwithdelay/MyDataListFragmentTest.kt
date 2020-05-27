package com.hejeon.espresso.mocktestwithdelay

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.hejeon.espresso.R
import com.hejeon.espresso.util.EspressoIdlingResource
import org.junit.*
import org.junit.runners.MethodSorters

//TEST_17 : RECYCLER VIEW TEST WITH DELAY
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 테스트 메소드 순서를 정하는 옵션임 가끔 테스트순서에따라 버그가 있는데, 이때는 메모리를 적게 쓰는 테스트 순으로 하면 해결된다.
class MyDataListFragmentTest{
    @get: Rule
    val activityScenario = ActivityScenarioRule(MockTestMainActivity::class.java)

    @Before
    fun registerIdlingResource(){
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    @After
    fun unregisterIdlingResource(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
    }

    val listItemInTest = 4
    val movieInTest = FakeMyData.myDatas[listItemInTest]

    @Test
    fun test_isListFragmentVisible_onAppLaunch() {
        onView(withId(R.id.list)).check(matches(isDisplayed()))
    }

    @Test
    fun test_selectedListItem_isDetailFragmentVisible() {
        onView(withId(R.id.list))
            .perform(actionOnItemAtPosition<MyDataListAdapter.MyDataListViewHolder>(listItemInTest, click()))
        onView(withId(R.id.mockTitle)).check(matches(withText(movieInTest.title)))
    }

    @Test
    fun test_backNavigation_toMyDataListFragment() {
        onView(withId(R.id.list)).perform(actionOnItemAtPosition<MyDataListAdapter.MyDataListViewHolder>(listItemInTest, click()))
        onView(withId(R.id.mockTitle)).check(matches(withText(movieInTest.title)))
        pressBack()
        onView(withId(R.id.list)).check(matches(isDisplayed()))
    }
}
