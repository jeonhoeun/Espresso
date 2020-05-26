package com.hejeon.espresso.basictest

import android.view.View
import androidx.test.core.app.ActivityScenario
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog

//TEST_0A : ROBOLECTRIC TEST BASIC
@RunWith(RobolectricTestRunner::class)
class MainActivityRoboTest{
    @Before
    fun setup(){
        ShadowLog.stream = System.out
    }

    @Test
    fun test_activityVisible() {
//        val activity = Robolectric.setupActivity(MainActivity::class.java)  OLDWAY
        val activity = ActivityScenario.launch(MainActivity::class.java) // NEWWAY
        activity.onActivity {
            assert(it.MainActivity.visibility== View.VISIBLE)
        }
    }
}