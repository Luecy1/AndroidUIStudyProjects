package com.example.androiduistudyprojects.componentlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androiduistudyprojects.R
import com.example.androiduistudyprojects.componentlist.dummy.DummyContent
import com.example.androiduistudyprojects.componentlist.dummy.FragmentItem
import timber.log.Timber

class ComponentFragment : Fragment(), OnListFragmentInteractionListener {

    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_component_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter =
                    ComponentRecyclerViewAdapter(
                        DummyContent.ITEMS,
                        this@ComponentFragment
                    )
            }
        }
        return view
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onListFragmentInteraction(item: FragmentItem) {
        Timber.d(item.toString())

        when (item.id) {
            "1" -> findNavController().navigate(R.id.action_componentFragment_to_blankFragment)
        }
    }
}
