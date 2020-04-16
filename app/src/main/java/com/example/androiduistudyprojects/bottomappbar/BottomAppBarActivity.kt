package com.example.androiduistudyprojects.bottomappbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiduistudyprojects.R
import kotlinx.android.synthetic.main.activity_bottom_app_bar.*

class BottomAppBarActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_app_bar)

        long_text.text = (0..50).map { 'あ' + it }.joinToString("\n")

        bar.setOnMenuItemClickListener { true }
    }
}
