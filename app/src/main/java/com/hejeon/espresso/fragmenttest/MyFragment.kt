package com.hejeon.espresso.fragmenttest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hejeon.espresso.R
import kotlinx.android.synthetic.main.fragment_my.*


class MyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        gotoArgmentFragment.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("ARG","bundle from release fragment")
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, ArgumentFragment::class.java, bundle)
                ?.commit()
        }
        super.onViewCreated(view, savedInstanceState)
    }
}
