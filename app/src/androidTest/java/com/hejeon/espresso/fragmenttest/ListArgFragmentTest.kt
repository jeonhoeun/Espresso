package com.hejeon.espresso.fragmenttest

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.hejeon.espresso.R
import com.hejeon.espresso.util.stringArrToString
import org.junit.Test

//TEST__10 리스트 argument fragment 테스트
class ListArgFragmentTest{
    @Test
    fun test_listArgument() {
        //setup
        val bundle = Bundle()
        val arr = arrayListOf("data1","data2","data3")
        bundle.putStringArrayList("ARG",arr)
        launchFragmentInContainer<ListArgFragment>(
            fragmentArgs = bundle
        )

        onView(withId(R.id.argList)).check(matches(withText(stringArrToString(arr))))
        onView(withId(R.id.argList)).check(matches(withText(stringArrToString(arr))))
    }
}