package com.example.androiduistudyprojects.input

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.androiduistudyprojects.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.blank_fragment.*
import timber.log.Timber
import javax.inject.Inject

class InputFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<InputViewModel> { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.blank_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.d(viewModel.toString())

        val item = listOf("Material", "Design", "Components", "Android")
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.list_item, item)

        (array_input.editText as? AutoCompleteTextView)?.setAdapter(arrayAdapter)
    }
}
