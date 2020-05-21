package com.hejeon.espresso.mocktest

class MyDataSourceImpl : MyDataSource {
    private val myData = LinkedHashMap<Int,MyData>(3)
    init{
        addMyData(0,"Good Day","Good Day Description")
        addMyData(1,"My Load","Go to My Load")
        addMyData(2,"Last1","This is Last1")
        addMyData(3,"Last2","This is Last2")
        addMyData(4,"Last3","This is Last3")
        addMyData(5,"Last4","This is Last4")
        addMyData(6,"Last5","This is Last5")
        addMyData(7,"Last6","This is Last6")
        addMyData(8,"Last7","This is Last7")
        addMyData(9,"Last8","This is Last8")
        addMyData(10,"Last9","This is Last9")
        addMyData(11,"Last10","This is Last10")
        addMyData(12,"Last11","This is Last11")
        addMyData(13,"Last12","This is Last12")
        addMyData(14,"Last13","This is Last13")
        addMyData(15,"Last14","This is Last14")
        addMyData(16,"Last15","This is Last15")
        addMyData(17,"Last16","This is Last16")
        addMyData(18,"Last17","This is Last17")
        addMyData(19,"Last18","This is Last18")
        addMyData(20,"Last19","This is Last19")
        addMyData(21,"Last20","This is Last20")

    }

    private fun addMyData(id:Int, title:String, description:String){
        myData[id]=MyData(id,title, description)
    }

    override fun getMyData(id: Int): MyData? {
        return myData[id]
    }

    override fun getMyDatas(): List<MyData> {
        return ArrayList(myData.values)
    }
}