package com.hejeon.espresso.mocktest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.hejeon.espresso.R
import org.junit.Rule
import org.junit.Test

//TEST_17 : RECYCLER VIEW TEST
class MyDataListFragmentTest{
    @get: Rule
    val activityScenario = ActivityScenarioRule(MockTestMainActivity::class.java)

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
