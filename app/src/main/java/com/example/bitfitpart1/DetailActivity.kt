package com.example.bitfitpart1


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    private lateinit var foodNameTextView: EditText
    private lateinit var foodCaloriesTextView: EditText
    private lateinit var addListButton: Button

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_item)

        // TODO: Find the views for the screen
        foodNameTextView = findViewById(R.id.food_Name)
        foodCaloriesTextView = findViewById(R.id.food_Calories)
        addListButton = findViewById(R.id.button)

        // TODO: Add the date
        val currentLDT = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy")
        val time =currentLDT.format(formatter)

        // TODO: On click of button Add to database and redirect to main activity page
        addListButton.setOnClickListener {
            val foodName = foodNameTextView.text.toString()
            val calCount = foodCaloriesTextView.text.toString()

            lifecycleScope.launch(IO) {
//                (application as FitApplication).db.FitDao().deleteAll()
                (application as FitApplication).db.FitDao().insertAll(
                    listOf(
                        FitEntity(
                            food_name = foodName,
                            food_calories = calCount
                        )
                    )
                )
            }

            // TODO: Redirect to list page on click of button
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}