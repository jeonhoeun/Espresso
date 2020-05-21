package com.hejeon.espresso.mocktest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hejeon.espresso.R
import kotlinx.android.synthetic.main.fragment_my_data_list.*

class MyDataListFragment(
    private val myDataSource: MyDataSource
) : Fragment(),
MyDataListAdapter.InterAction{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_data_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        getData()
    }

    private fun getData() {
        listAdapter.submitList(myDataSource.getMyDatas())
    }

    lateinit var listAdapter : MyDataListAdapter

    private fun initList() {
        list.apply{
            layoutManager = LinearLayoutManager(activity)
            listAdapter = MyDataListAdapter(this@MyDataListFragment)
            adapter = listAdapter
        }
    }

    override fun onItemSelected(position: Int, item: MyData) {
        activity?.run{
            val bundle = Bundle()
            bundle.putInt("mydata_id",item.id)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,MyDataDetailFragment::class.java,bundle)
                .addToBackStack(MyDataDetailFragment::class.java.name)
                .commit()
        }
    }
}
