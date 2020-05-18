package com.hejeon.espresso.intenttest

import android.app.Activity.RESULT_OK
import android.app.Instrumentation
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.provider.MediaStore
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import com.hejeon.espresso.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test

//TEST__12 expresso intent 테스트.
class PickImageActivityTest{

    @get:Rule
    val intentsTestRule : IntentsTestRule<PickImageActivity> = IntentsTestRule(PickImageActivity::class.java)

    @Test
    fun intentValidate() {
        val expectedIntent : Matcher<Intent> = allOf(
            hasAction(Intent.ACTION_PICK),
            hasData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        )

        val r = createGalleryPickActivityResultStub()
        intending(expectedIntent).respondWith(r)

        onView(withId(R.id.pickButton)).perform(click())
        intended(expectedIntent)
    }

    private fun createGalleryPickActivityResultStub() : Instrumentation.ActivityResult {
        val imageUri = Uri.parse("android.resource://com.hejeon.espresso/drawable/test")
//      튜토리얼상에서는 아래와같이 되어있으나, can not find resource 오류가 발생하여 위와같이 직접 타이핑함
//        val r : Resources = InstrumentationRegistry.getInstrumentation().context.resources
//        val imageUri = Uri.parse(
//            ContentResolver.SCHEME_ANDROID_RESOURCE+"://"+
//                    r.getResourcePackageName(R.drawable.test)+"/"+
//                    r.getResourceTypeName(R.drawable.test)+"/"+
//                    r.getResourceEntryName(R.drawable.test)
//        )
        val resultIntent = Intent()
        resultIntent.setData(imageUri)
        return Instrumentation.ActivityResult(RESULT_OK, resultIntent)
    }
}