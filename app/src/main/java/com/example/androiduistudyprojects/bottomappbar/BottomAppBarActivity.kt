package com.example.androiduistudyprojects.bottomappbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiduistudyprojects.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_bottom_app_bar.*

class BottomAppBarActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_app_bar)

        long_text.text = ('あ'..'ん').joinToString("\n")

        bar.setOnMenuItemClickListener { true }

        bar.setNavigationOnClickListener {
            Snackbar.make(it, "Click", Snackbar.LENGTH_SHORT).show()
        }
    }
}
