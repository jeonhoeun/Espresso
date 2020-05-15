package com.hejeon.espresso.fragmenttest

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.hejeon.espresso.R
import org.junit.Test

//TEST__08 FRAGMENT 테스트. build gradle 에 설정을 해줘야 launchFragmentInContainer 가 정상동작함
class MyFragmentTest{
    @Test
    fun test_isMyFragmentVisible() {
        launchFragmentInContainer<MyFragment>()
        onView(withId(R.id.MyFragment)).check(matches(isDisplayed()))
    }
}