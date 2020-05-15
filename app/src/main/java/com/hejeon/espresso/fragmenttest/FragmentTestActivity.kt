package com.hejeon.espresso.fragmenttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hejeon.espresso.R

class FragmentTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = MyFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_test)
        init()
    }

    private fun init() {
        if(supportFragmentManager.fragments.size==0){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MyFragment::class.java,null)
                .commit()
        }
    }
}
