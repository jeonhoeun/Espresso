package com.hejeon.espresso

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Test

class MainActivityTest{
    @Test //TEST__01 id를 통하여 화면이 보이는지 확인하는 테스트

    fun onCreate_nextActivityButton_mustVisible() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.next_activity))
            .check(matches(isDisplayed())) // 방법 1

        onView(withId(R.id.next_activity))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE))) // 방법 2
    }

    @Test //TEST__02 뷰의 텍스트를 검사하는 테스트
    fun onCreate_MainActivityTitleText_sameWith_mainActivityTitle() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.mainActivityTitle))
            .check(matches(withText(R.string.mainActivityTitle)))
    }
}