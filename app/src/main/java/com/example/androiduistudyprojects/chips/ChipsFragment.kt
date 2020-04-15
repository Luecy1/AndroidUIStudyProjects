package com.example.androiduistudyprojects.chips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androiduistudyprojects.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_chips.*

class ChipsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chips, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        actionChip.setOnClickListener {
            Snackbar.make(view, "Click!", Snackbar.LENGTH_LONG).show()
        }
    }
}
