package com.hejeon.espresso.fragmenttest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hejeon.espresso.R
import com.hejeon.espresso.util.stringArrToString
import kotlinx.android.synthetic.main.fragment_list_arg.*

/**
 * A simple [Fragment] subclass.
 */
class ListArgFragment : Fragment() {
    private val listData : ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{ arg ->
            @Suppress("UNCHECKED_CAST")
            listData.addAll( arg.get("ARG") as List<String>)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_arg, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        argList.text = stringArrToString(listData)
    }


}
