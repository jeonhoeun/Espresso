package com.hejeon.espresso.util

import android.util.Log
import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource{
    private const val resource = "GLOBAL"
    @JvmField val countingIdlingResource = CountingIdlingResource(resource)

    fun increment(){
        Log.i("Test","Debug Mode increment")
        countingIdlingResource.increment()
    }

    fun decrement(){
        Log.i("Test","Debug Mode decrement")
        if(!countingIdlingResource.isIdleNow){
            countingIdlingResource.decrement()
        }
    }
}