package com.hejeon.espresso.util

import android.util.Log

object EspressoIdlingResource{
    fun increment(){
        Log.i("Test","Release Mode increment")
    }

    fun decrement(){
        Log.i("Test","Release Mode decrement")
    }
}