package com.example.androiduistudyprojects.menus

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.example.androiduistudyprojects.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_menus.*


class MenusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menus)

        button_1.setOnClickListener {
            PopupMenu(this, it).apply {
                menuInflater.inflate(R.menu.custom_menu, menu)
                setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.search -> {
                            Snackbar.make(it, "Click search", Snackbar.LENGTH_SHORT).show()
                        }
                        R.id.help -> {
                            Snackbar.make(it, "Click help", Snackbar.LENGTH_SHORT).show()
                        }
                        else -> {
                            Snackbar.make(it, "non reach", Snackbar.LENGTH_SHORT).show()
                        }
                    }

                    return@setOnMenuItemClickListener true
                }
            }.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.custom_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.search -> {
                Snackbar.make(menu_root_view, "Click search", Snackbar.LENGTH_SHORT).show()
                true
            }
            R.id.help -> {
                Snackbar.make(menu_root_view, "Click help", Snackbar.LENGTH_SHORT).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
