package com.example.androiduistudyprojects.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androiduistudyprojects.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_dialogs.*

class DialogsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialogs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_1.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Title")
                .setMessage("マテリアルダイアログのメッセージ")
                .setNegativeButton(android.R.string.no) { _, witch ->
                    Snackbar.make(view, "click! -> $witch", Snackbar.LENGTH_SHORT).show()
                }
                .setPositiveButton(android.R.string.ok) { _, witch ->
                    Snackbar.make(view, "click! -> $witch", Snackbar.LENGTH_SHORT).show()
                }
                .show()
        }

        val items = arrayOf("Item 1", "Item 2", "Item 3")

        simple_dialog.setOnClickListener {
            MaterialAlertDialogBuilder(context)
                .setTitle("Title")
                .setItems(items) { _, which ->
                    Snackbar.make(view, "click! -> ${items[which]}", Snackbar.LENGTH_SHORT).show()
                }
                .show()

        }
    }
}
