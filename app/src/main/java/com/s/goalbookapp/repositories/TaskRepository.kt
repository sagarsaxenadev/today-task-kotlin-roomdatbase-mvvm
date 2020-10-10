package com.s.goalbookapp.repositories

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.s.goalbookapp.appdb.AppDatabase
import com.s.goalbookapp.models.TaskModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskRepository {

    companion object {
        private var appDatabase:AppDatabase?=null


        private fun initialiseDB(context: Context):AppDatabase?
        {
            return  AppDatabase.getInstance(context)
        }

         fun insertTask(context: Context, taskModel: TaskModel) {
             appDatabase = initialiseDB(context)


            CoroutineScope(Dispatchers.IO).launch {
               var data= appDatabase?.getTaskDao()?.insert(taskModel)
                Log.d("db insert > ",data.toString())

            }
        }

        fun getAllTask(context: Context): LiveData<List<TaskModel>>? {
            appDatabase = initialiseDB(context)

            var allTaskList: LiveData<List<TaskModel>>? = null
                allTaskList = appDatabase?.getTaskDao()?.allTask()



            return allTaskList
        }

    }
}