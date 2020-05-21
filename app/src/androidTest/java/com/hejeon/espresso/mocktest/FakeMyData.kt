package com.hejeon.espresso.mocktest

object FakeMyData {
    val myDatas = arrayOf(
        MyData(0, "Good Day", "Good Day Description"),
        MyData(1, "My Load", "Go to My Load"),
        MyData(2, "Last1", "This is Last1"),
        MyData(3, "Last2", "This is Last2"),
        MyData(4, "Last3", "This is Last3"),
        MyData(5, "Last4", "This is Last4"),
        MyData(6, "Last5", "This is Last5"),
        MyData(7, "Last6", "This is Last6"),
        MyData(8, "Last7", "This is Last7"),
        MyData(9, "Last8", "This is Last8"),
        MyData(10, "Last9", "This is Last9"),
        MyData(11, "Last10", "This is Last10"),
        MyData(12, "Last11", "This is Last11"),
        MyData(13, "Last12", "This is Last12"),
        MyData(14, "Last13", "This is Last13"),
        MyData(15, "Last14", "This is Last14"),
        MyData(16, "Last15", "This is Last15"),
        MyData(17, "Last16", "This is Last16"),
        MyData(18, "Last17", "This is Last17"),
        MyData(19, "Last18", "This is Last18"),
        MyData(20, "Last19", "This is Last19"),
        MyData(21, "Last20", "This is Last20")
    )
}

class FakeMyDataSource : MyDataSource {
    private val MyData = LinkedHashMap<Int, MyData>(FakeMyData.myDatas.size)

    init {
        for (myData in FakeMyData.myDatas) {
            MyData[myData.id] = myData
        }
    }

    override fun getMyData(id: Int): MyData? {
        return MyData[id]
    }

    override fun getMyDatas(): List<MyData> {
        return ArrayList(MyData.values)
    }

}