package com.s.goalbookapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.s.goalbookapp.R
import com.s.goalbookapp.adapter.AllTaskAdapter
import com.s.goalbookapp.models.TaskModel
import com.s.goalbookapp.viewmodel.TaskViewModel

class TaskActivity : AppCompatActivity() {

    private lateinit var viewModel: TaskViewModel
    private lateinit var btnAddNewTask: FloatingActionButton
    private lateinit var mRvGoalList: RecyclerView
    private lateinit var alltaskAdapter: AllTaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

        initView()

        viewModel = ViewModelProvider(this)[TaskViewModel::class.java]

        viewModel.getAllTask(this)?.observe(this, Observer {
            alltaskAdapter.setData(it as ArrayList<TaskModel>)

        })

        btnAddNewTask.setOnClickListener {
            Intent(this@TaskActivity, AddNewTaskActviity::class.java).also {
                startActivity(it)
            }
        }

    }

    override fun onResume() {
        super.onResume()

    }

    private fun initView() {

        mRvGoalList = findViewById<RecyclerView>(R.id.rvGoalList) as RecyclerView
        btnAddNewTask = findViewById<FloatingActionButton>(R.id.btnAddNew) as FloatingActionButton

        alltaskAdapter = AllTaskAdapter(
            context = this@TaskActivity,
            arrayList = ArrayList<TaskModel>()
        )

        mRvGoalList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@TaskActivity)
            adapter = alltaskAdapter
        }

    }

}