package com.hejeon.espresso.basictest

import android.app.Application
import android.content.Intent
import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import com.hejeon.espresso.R
import junit.framework.TestCase.assertEquals
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.shadows.ShadowLog

//TEST_0A : ROBOLECTRIC TEST BASIC
@RunWith(RobolectricTestRunner::class)
class MainActivityRoboTest {
    @Before
    fun setup() {
        ShadowLog.stream = System.out
    }

    @Test
    fun test_activityVisible() {
//        val activity = Robolectric.setupActivity(MainActivity::class.java)  OLDWAY
        val activity = ActivityScenario.launch(MainActivity::class.java) // NEWWAY
        activity.onActivity {
            assert(it.MainActivity.visibility == View.VISIBLE)
        }
    }

    @Test //TEST__01 id를 통하여 화면이 보이는지 확인하는 테스트
    fun `onCreate NextActivityButtonMustVisible`() {
        val activity = ActivityScenario.launch(MainActivity::class.java)
        activity.onActivity {
            assert(it.next_activity.visibility == View.VISIBLE)
        }
    }

    @Test //TEST__02 뷰의 텍스트를 검사하는 테스트
    fun `onCreate Title is R_string_mainActivityTitle`() {
        ActivityScenario.launch(MainActivity::class.java).onActivity {
            assert(it.mainActivityTitle.text.equals(it.getString(R.string.mainActivityTitle)))
        }
    }

    @Test //TEST__04 버튼을 누르는 행위와 화면이동 테스트
    fun `onNextActivityButton click expectedIntent`() {
        ActivityScenario.launch(MainActivity::class.java).onActivity {
            it.next_activity.performClick()
            val expectedIntent = Intent(it, SecondActivity::class.java)
            //val actual = shadowOf(RuntimeEnvironment.application).nextStartedActivity //deprecated
            val actual =
                shadowOf(ApplicationProvider.getApplicationContext() as Application).nextStartedActivity
            assertEquals(expectedIntent.component, actual.component)
        }
    }

    /*
    @Test //TEST__05 pressBack 은 Robolectric에서 할수있는방법이 없어보임. (자료 찾는중)
    fun test_backPress_toMainActivity() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.next_activity)).perform(click())
        onView(withId(R.id.secondaryActivity)).check(matches(isDisplayed()))
        pressBack() // or onView(withId(R.id.go_back)).perform(click())
        onView(withId(R.id.MainActivity)).check(matches(isDisplayed()))
    }
     */
}