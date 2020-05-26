package com.hejeon.espresso.mocktestwithdelay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hejeon.espresso.R
import com.hejeon.espresso.mocktest.MyData
import com.hejeon.espresso.mocktest.MyDataSource
import kotlinx.android.synthetic.main.fragment_mock.*


class MyDataDetailFragment(
    private val source : MyDataSource
) : Fragment() {
    lateinit var myData : MyData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{args->
            args.getInt("mydata_id").let{ myDataId ->
                source.getMyData(myDataId)?.let{ myDataFromRemote ->
                    myData = myDataFromRemote
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mock, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateView()
    }

    private fun updateView(){
        mockTitle.text = myData.title
        mockDescription.text = myData.description
    }
}
