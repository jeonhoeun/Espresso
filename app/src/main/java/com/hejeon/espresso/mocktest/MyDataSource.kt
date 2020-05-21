package com.hejeon.espresso.mocktest

interface MyDataSource {
    fun getMyData(id:Int) : MyData?
    fun getMyDatas() : List<MyData>
}