package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.util.*
import java.text.SimpleDateFormat as SimpleDateFormat

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker : Button = findViewById(R.id.datePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)

        btnDatePicker.setOnClickListener {
            clickDatePicker()
        }

    }

    fun clickDatePicker(){

        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,
            { view, selectedYear, selectedMonth, selectedDayOfMonth ->

                Toast.makeText(this,
                    "Year was $selectedYear, Month was ${selectedMonth+1}, Day was $selectedDayOfMonth", Toast.LENGTH_LONG).show()

                val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

                tvSelectedDate?.text = selectedDate
                
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)
            },
            year,
            month,
            day
            ).show()

    }
}