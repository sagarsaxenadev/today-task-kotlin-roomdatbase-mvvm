package com.s.goalbookapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import androidx.room.Index



@Entity(tableName = "task")
data class TaskModel(
    var title: String,
    var startTime: String,
    var endTime: String,
    var detail: String
):Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}