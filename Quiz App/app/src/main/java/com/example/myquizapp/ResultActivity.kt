package com.example.myquizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var username:TextView=findViewById(R.id.user_name)
        var diplay:TextView=findViewById(R.id.display)
        var btnfinish:Button=findViewById(R.id.btn_finish)
        val total:Int=intent.getIntExtra(Constants.TOTAL_QUESTION,10)
        val correct:Int = intent.getIntExtra(Constants.CORRECT_ANSWER,0)
        username.text=intent.getStringExtra(Constants.USER_NAME)
        diplay.text="Your Score is $correct out of $total"
        btnfinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }


    }
}