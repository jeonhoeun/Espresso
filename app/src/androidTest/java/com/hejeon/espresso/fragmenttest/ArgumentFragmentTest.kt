package com.hejeon.espresso.fragmenttest

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.hejeon.espresso.R
import org.junit.Test

//TEST__09 ARGUMENT가 있는 Fragment 테스트
class ArgumentFragmentTest{
    @Test
    fun test_isArgumentFragmentVisible() {
        //setup
        val bundle = Bundle()
        bundle.putString("ARG","receive arg")
        launchFragmentInContainer<ArgumentFragment>(
            fragmentArgs = bundle
        )
        onView(withId(R.id.ArgumentFragment)).check(matches(isDisplayed()))
    }
}