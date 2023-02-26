package com.example.bitfitpart1

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private const val TAG = "MainActivity/"

class MainActivity : AppCompatActivity() {
    private val bitFit = mutableListOf<DisplayFit>()
    private lateinit var fitRV: RecyclerView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: Defining activity_main items
        val addBtn = findViewById<View>(R.id.addBtn)
        val lastEntry = findViewById<View>(R.id.date) as TextView
        val avgCal = findViewById<View>(R.id.avg_cal) as TextView
        fitRV = findViewById(R.id.FitView)


        // TODO: Set up BitFit Adapter with fits
        val bitFitAdapter = FitAdapter(this, bitFit)
        fitRV.adapter = bitFitAdapter
        fitRV.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            fitRV.addItemDecoration(dividerItemDecoration)
        }

        // TODO: Add the date
        val currentLDT = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy")
        lastEntry.text = "\t\t\tDate: " + currentLDT.format(formatter)

        // TODO: Get and display the data
        lifecycleScope.launch {
            (application as FitApplication).db.FitDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    DisplayFit(
                        entity.food_name,
                        entity.food_calories,
                    )
                }.also { mappedList ->
                    bitFit.clear()
                    bitFit.addAll(mappedList)
                    bitFitAdapter.notifyDataSetChanged()
                }
            }
        }
        // TODO: Add the Average Calories
        val avg = 0
        val cal = 0
        val counter = 0


        // TODO: Redirect to add page on click of button
        addBtn.setOnClickListener{
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }

        //TODO: On Landscape mode add a picture



    }
}