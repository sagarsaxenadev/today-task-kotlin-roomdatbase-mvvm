package com.s.goalbookapp.ui

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.s.goalbookapp.R
import com.s.goalbookapp.models.TaskModel
import com.s.goalbookapp.utils.Utils
import com.s.goalbookapp.viewmodel.TaskViewModel
import java.text.SimpleDateFormat
import java.util.*

class AddNewTaskActviity : AppCompatActivity() {

    private lateinit var mEdtTitle: EditText
    private lateinit var mEdtDetail: EditText
    private lateinit var tvStartTime: TextView
    private lateinit var tvEndTime: TextView
    private lateinit var mBtnAddTask: Button
    val START_TIME = 1
    val END_TIME = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_task_actviity)

        mEdtTitle = findViewById<EditText>(R.id.edt_title)
        mEdtDetail = findViewById<EditText>(R.id.edt_detail)
        tvStartTime = findViewById<TextView>(R.id.tvStartTime)
        tvEndTime = findViewById<TextView>(R.id.tvEndTime)
        mBtnAddTask = findViewById<Button>(R.id.tvAddTask)

        val viewmodel = ViewModelProvider(this)[TaskViewModel::class.java]
        mBtnAddTask.setOnClickListener {

            viewmodel.insert(
                this, TaskModel(
                    title = mEdtTitle.text.toString().trim(),
                    startTime = tvStartTime.text.toString().trim(),
                    endTime = tvEndTime.text.toString().trim(),
                    detail = mEdtDetail.text.toString().trim()
                )
            )

        }

        tvStartTime.setOnClickListener {
            timerpik(START_TIME)
        }

        tvEndTime.setOnClickListener {
            timerpik(END_TIME)
        }

    }

    fun timerpik(selectTime: Int) {
        lateinit var time: String

        val cal = Calendar.getInstance()
        val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)
          //  var time = SimpleDateFormat("HH:mm").format(cal.time)
            time=Utils.getManagedTimeString(hour,minute)
            when (selectTime) {
                START_TIME -> tvStartTime.text = time
                END_TIME -> tvEndTime.text = time
            }

        }
        TimePickerDialog(
            this,
            timeSetListener,
            cal.get(Calendar.HOUR_OF_DAY),
            cal.get(Calendar.MINUTE),
            true
        ).show()
    }

}