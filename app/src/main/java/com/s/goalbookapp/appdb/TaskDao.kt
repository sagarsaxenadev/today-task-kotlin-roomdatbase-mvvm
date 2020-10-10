package com.s.goalbookapp.appdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.s.goalbookapp.models.TaskModel

@Dao
interface TaskDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(taskModel: TaskModel) : Long

    @Query("SELECT * FROM task order by id asc ")
     fun allTask(): LiveData<List<TaskModel>>


}