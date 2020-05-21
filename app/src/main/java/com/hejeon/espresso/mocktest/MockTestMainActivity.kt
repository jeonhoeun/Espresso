package com.hejeon.espresso.mocktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hejeon.espresso.R

class MockTestMainActivity : AppCompatActivity() {
    lateinit var myDataSource : MyDataSource
    override fun onCreate(savedInstanceState: Bundle?) {
        initDependencies()
        supportFragmentManager.fragmentFactory = MyDataFragmentFactory(
            myDataSource
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mock)
        init()
    }

    private fun initDependencies() {
        if( !::myDataSource.isInitialized){
            myDataSource = MyDataSourceImpl()
        }
    }


    private fun init(){
        if(supportFragmentManager.fragments.size==0){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MyDataListFragment::class.java,null)
                .commit()
        }
    }
}
