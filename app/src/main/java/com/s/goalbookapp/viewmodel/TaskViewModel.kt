package com.s.goalbookapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.s.goalbookapp.models.TaskModel
import com.s.goalbookapp.repositories.TaskRepository

class TaskViewModel : ViewModel() {

         fun insert(context: Context, taskModel: TaskModel) {
         TaskRepository.insertTask(context, taskModel)
        }

         fun getAllTask(context: Context):LiveData<List<TaskModel>>?{
            return TaskRepository.getAllTask(context)
        }




}