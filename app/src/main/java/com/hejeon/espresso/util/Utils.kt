package com.hejeon.espresso.util

import java.lang.StringBuilder

fun stringArrToString( input:List<String>) : String{
    val rtn = StringBuilder()
    input.forEach{
        rtn.append(it)
        rtn.append(" ")
    }
    return rtn.toString()
}