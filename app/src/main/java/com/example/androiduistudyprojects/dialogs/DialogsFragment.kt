package com.example.androiduistudyprojects.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androiduistudyprojects.databinding.FragmentDialogsBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_dialogs.*
import timber.log.Timber
import javax.inject.Inject

class DialogsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<DialogsViewModel> { viewModelFactory }

    private lateinit var binding: FragmentDialogsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDialogsBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.dialogFlg1.observe(viewLifecycleOwner, Observer { dialogFlg ->

            if (dialogFlg.not()) {
                return@Observer
            }

            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Title")
                .setMessage("マテリアルダイアログのメッセージ")
                .setNegativeButton(android.R.string.no) { _, witch ->
                    Snackbar.make(view, "click! -> $witch", Snackbar.LENGTH_SHORT).show()
                    viewModel.onCloseDialog1()
                }
                .setPositiveButton(android.R.string.ok) { _, witch ->
                    Snackbar.make(view, "click! -> $witch", Snackbar.LENGTH_SHORT).show()
                    viewModel.onCloseDialog1()
                }
                .show()
        })

        val items = arrayOf("Item 1", "Item 2", "Item 3")

        simple_dialog.setOnClickListener {
            MaterialAlertDialogBuilder(context)
                .setTitle("Title")
                .setItems(items) { _, which ->
                    Snackbar.make(view, "click! -> ${items[which]}", Snackbar.LENGTH_SHORT).show()
                }
                .show()

        }

        val checkedItem = 1

        single_click.setOnClickListener {
            MaterialAlertDialogBuilder(context)
                .setTitle("SingleClick")
                .setNeutralButton(android.R.string.no) { _, which ->
                    Snackbar.make(view, "cancel", Snackbar.LENGTH_SHORT).show()
                }
                .setPositiveButton(android.R.string.yes) { _, which ->
                    Snackbar.make(view, "click Positive", Snackbar.LENGTH_SHORT).show()
                }
                .setSingleChoiceItems(items, checkedItem) { _, which ->
                    Snackbar.make(
                        view,
                        "click SingleChoice -> ${items[which]}",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                .show()
        }

        multi_dialog.setOnClickListener {
            val multiItems = arrayOf("Item 1", "Item 2", "Item 3")
            val checkedItems = booleanArrayOf(true, false, false, false)

            MaterialAlertDialogBuilder(context)
                .setMultiChoiceItems(multiItems, checkedItems) { _, which, checked ->
                    Timber.d("which -> $which")
                    Timber.d("checked -> $checked")
                }
                .show()
        }

    }
}
