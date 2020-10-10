package com.s.goalbookapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.s.goalbookapp.R
import com.s.goalbookapp.models.TaskModel

class AllTaskAdapter(val context: Context, var arrayList: ArrayList<TaskModel>) :
    RecyclerView.Adapter<AllTaskAdapter.MyViewmodel>() {

    inner class MyViewmodel(view: View) : RecyclerView.ViewHolder(view) {
        val mTitle = view.findViewById<TextView>(R.id.title)
        val mDetail = view.findViewById<TextView>(R.id.detail)
        val date_time = view.findViewById<TextView>(R.id.date_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewmodel {

        return MyViewmodel(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_all_task, parent, false)
        )

    }

    override fun onBindViewHolder(holder: MyViewmodel, position: Int) {

        holder.apply {
            mTitle.text = arrayList[position].title
            mDetail.text = arrayList[position].detail
            date_time.text = arrayList[position].startTime + " - " + arrayList[position].endTime
        }
    }

    override fun getItemCount(): Int = arrayList.size

    fun setData(taskModel: ArrayList<TaskModel>) {
        arrayList = taskModel
        notifyDataSetChanged()
    }
}