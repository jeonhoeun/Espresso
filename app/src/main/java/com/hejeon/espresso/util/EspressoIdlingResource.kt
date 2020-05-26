package com.hejeon.espresso.util

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource{
    private const val resource = "GLOBAL"
    @JvmField val countingIdlingResource = CountingIdlingResource(resource)

    fun increment(){
        countingIdlingResource.increment()
    }

    fun decrement(){
        if(!countingIdlingResource.isIdleNow){
            countingIdlingResource.decrement()
        }
    }
}