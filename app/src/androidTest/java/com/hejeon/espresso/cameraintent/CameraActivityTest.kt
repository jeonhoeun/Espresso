package com.hejeon.espresso.cameraintent

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import com.hejeon.espresso.R
import com.hejeon.espresso.cameraintent.ImageViewHasDrawableMatcher.hasDrawable
import org.hamcrest.Matcher
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test

//TEST__13 : 카메라 intent 테스트
class CameraActivityTest{
    @get:Rule
    val intentTestRule = IntentsTestRule(CameraActivity::class.java)

    @Test
    fun cameraIntentTest_isBitmapSetToImageView() {
         val activityResult = createImageCaptureActivityResultStub()

        val expectedIntent: Matcher<Intent> = hasAction(
            MediaStore.ACTION_IMAGE_CAPTURE
        )
        intending(expectedIntent).respondWith(activityResult)

        onView(withId(R.id.imageView)).check(matches(not(hasDrawable())))
        onView(withId(R.id.takePicture)).perform(click())

        onView(withId(R.id.imageView)).check(matches(hasDrawable()))
        intending(expectedIntent)

    }

    private fun createImageCaptureActivityResultStub(): Instrumentation.ActivityResult? {
        val bundle = Bundle()
        bundle.putParcelable(
            "data",
            BitmapFactory.decodeResource(
                InstrumentationRegistry.getInstrumentation().context.resources,
                R.drawable.test
            )
        )

        val resultData = Intent()
        resultData.putExtras(bundle)
        return Instrumentation.ActivityResult(Activity.RESULT_OK, resultData)


    }
}