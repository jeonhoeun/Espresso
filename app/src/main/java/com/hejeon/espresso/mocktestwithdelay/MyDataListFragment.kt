package com.hejeon.espresso.mocktestwithdelay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hejeon.espresso.R
import com.hejeon.espresso.mocktest.MyData
import com.hejeon.espresso.mocktest.MyDataSource
import com.hejeon.espresso.util.EspressoIdlingResource
import kotlinx.android.synthetic.main.fragment_my_data_list.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
        EspressoIdlingResource.increment() // delay 코드에서 테스트를 위한 코드
        val fakeDelay = GlobalScope.launch(IO){
            delay(3000L)
        }
        fakeDelay.invokeOnCompletion {
            GlobalScope.launch(Main){
                listAdapter.submitList(myDataSource.getMyDatas())
                EspressoIdlingResource.decrement() // delay 코드에서 테스트를 위한 코드
            }
        }
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
