package com.hejeon.espresso.fragmenttest

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

class MyFragmentFactory :FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        if( className==MyFragment::class.java.name){
            return MyFragment()
        }
        return super.instantiate(classLoader, className)
    }
}