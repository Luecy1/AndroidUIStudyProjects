package com.example.androiduistudyprojects.componentlist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androiduistudyprojects.DrawerActivity
import com.example.androiduistudyprojects.R
import com.example.androiduistudyprojects.ScrollingActivity
import com.example.androiduistudyprojects.book.BookListActivity
import com.example.androiduistudyprojects.bottomappbar.BottomAppBarActivity
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

        if (item.actionId != null) {
            findNavController().navigate(item.actionId)
        } else {

            when (item.id) {
                "3" -> {
                    val intent = Intent(requireContext(), BottomAppBarActivity::class.java)
                    startActivity(intent)
                }
                "7" -> {
                    val intent = Intent(requireContext(), DrawerActivity::class.java)
                    startActivity(intent)
                }
                "8" -> {
                    val intent = Intent(requireContext(), ScrollingActivity::class.java)
                    startActivity(intent)
                }
                "9" -> {
                    val intent = Intent(requireContext(), BookListActivity::class.java)
                    startActivity(intent)
                }
            }

        }

    }
}
