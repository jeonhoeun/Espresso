package com.hejeon.espresso.mocktest

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.hejeon.espresso.R
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

//TEST_16 : Mock test
class MyDataDetailFragmentTest{
    @Test
    fun test_dataVisible() {
        //setup
        val id = 1
        val title = "Mock Title"
        val description = "Mock Description"

        val data = MyData(id,title,description)


        //이부분이 라이브러리를 이용하여 목킹하는 부분임
        val dataSource = mockk<MyDataSourceImpl>()
        every {
            dataSource.getMyData(id)
        } returns data

        val fragmentFactory = MyDataFragmentFactory(
            dataSource
        )

        //ACTION
        val bundle = Bundle()
        bundle.putInt("mydata_id",id)
        launchFragmentInContainer<MyDataDetailFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        //VERIFY
        onView(withId(R.id.mockTitle)).check(matches(withText(title)))
        onView(withId(R.id.mockDescription)).check(matches(withText(description)))

    }
}