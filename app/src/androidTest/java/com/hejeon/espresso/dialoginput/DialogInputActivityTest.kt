package com.hejeon.espresso.dialoginput

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.hejeon.espresso.R
import org.junit.Test

//TEST_14 : 다이얼로그 인풋 테스트
class DialogInputActivityTest{
    @Test
    fun showDialog_captureTextInput() {
        ActivityScenario.launch(DialogInputActivity::class.java)

        val expected = "TEXTINPUT"

        onView(withId(R.id.openDialog)).perform(click())

        onView(withText(R.string.enter_text)).check(matches(isDisplayed()))

        onView(withText(android.R.string.ok)).perform(click())

        onView(withId(R.id.md_input_message)).perform(typeText(expected))

        onView(withText(android.R.string.ok)).perform(click())

// onView(withText(R.string.enter_text)).check(matches(not(isDisplayed()))) //이것은 오류남
        onView(withText(R.string.enter_text)).check(doesNotExist()) //이렇게 해야됨

        onView(withId(R.id.inputText)).check(matches(withText(expected)))
    }
}