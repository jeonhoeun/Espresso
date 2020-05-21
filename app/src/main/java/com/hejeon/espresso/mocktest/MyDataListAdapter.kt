package com.hejeon.espresso.mocktest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hejeon.espresso.R
import kotlinx.android.synthetic.main.mydata_list_view_holder.view.*

class MyDataListAdapter(
    private val interAction: InterAction?
) : RecyclerView.Adapter<MyDataListAdapter.MyDataListViewHolder>() {
    interface InterAction{
        fun onItemSelected(position: Int, item:MyData)
    }
    class MyDataListViewHolder(
        itemView: View,
        private val interAction: InterAction?
    ) : RecyclerView.ViewHolder(itemView){
        fun bind(item:MyData){
            with(itemView){
                itemView.setOnClickListener {
                    interAction?.onItemSelected(adapterPosition, item)
                }
                view_holder_title.text = item.title
            }
        }
    }

    val diffCallback = object : DiffUtil.ItemCallback<MyData>(){
        override fun areItemsTheSame(oldItem: MyData, newItem: MyData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MyData, newItem: MyData): Boolean {
            return oldItem==newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDataListViewHolder {
        return MyDataListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.mydata_list_view_holder,
                parent,
                false
            ),
            interAction
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: MyDataListViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    fun submitList(list:List<MyData>){
        differ.submitList(list)
    }
}