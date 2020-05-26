package com.hejeon.espresso.mocktestwithdelay

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.hejeon.espresso.mocktest.MyDataSource

class MyDataFragmentFactory(
    private val myDataSource: MyDataSource
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        if( MyDataDetailFragment::class.java.name==className){
            return MyDataDetailFragment(myDataSource)
        }else if( MyDataListFragment::class.java.name==className){
            return MyDataListFragment(myDataSource)
        }
        return super.instantiate(classLoader, className)
    }
}