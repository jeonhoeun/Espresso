package com.hejeon.espresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.hejeon.espresso.basictest.SecondActivity
import org.junit.Rule
import org.junit.Test

class SecondActivityTest{
    //TEST__03 get Rule을 사용하면 모든 test func에서 쓰게된다.
    @get: Rule
    val activityScenario = ActivityScenarioRule(SecondActivity::class.java)

    @Test
    fun onCreate_SecondActivity_visible() {
        onView(withId(R.id.secondaryActivity))
            .check(matches(isDisplayed()))
    }

    @Test
    fun onCreate_titleAndGoBackButton_visible() {
        onView(withId(R.id.secondActivityTitle))
            .check(matches(isDisplayed()))
        onView(withId(R.id.go_back))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }
}