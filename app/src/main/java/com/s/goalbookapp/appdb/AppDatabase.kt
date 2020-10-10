package com.s.goalbookapp.appdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.s.goalbookapp.models.TaskModel


@Database(entities = [TaskModel::class], version = 2,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getTaskDao(): TaskDao

    companion object {

        const val DATABASE_NAME = "myapptaskdb"

        @Volatile
        var appDatabase: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (appDatabase == null) {

                synchronized(AppDatabase::class.java) {
                    if (appDatabase == null) {
                        appDatabase =
                            Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                                .build()
                    }


                }

            }
            return appDatabase
        }


    }
}