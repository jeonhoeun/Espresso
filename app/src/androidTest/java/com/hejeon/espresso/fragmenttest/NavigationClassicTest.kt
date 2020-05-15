package com.hejeon.espresso.fragmenttest

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.hejeon.espresso.R
import org.junit.Test

//TEST__11 : Fragment Navigation class way test
class NavigationClassicTest {
    @Test
    fun testNavigation() {
        //SETUP
        ActivityScenario.launch(FragmentTestActivity::class.java)

        //ACTION
        onView(withId(R.id.gotoArgmentFragment)).perform(click())

        //verify
        onView(withId(R.id.ArgumentFragment)).check(matches(isDisplayed()))

    }
}