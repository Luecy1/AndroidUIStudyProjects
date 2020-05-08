package com.example.androiduistudyprojects.gesture

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.androiduistudyprojects.R
import kotlinx.android.synthetic.main.fragment_gesture.*
import timber.log.Timber

class GestureFragment : Fragment() {

    private lateinit var gestureDetector: GestureDetector

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gesture, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gestureDetector =
            GestureDetector(requireContext(), object : GestureDetector.SimpleOnGestureListener() {

                override fun onDown(e: MotionEvent?): Boolean {
                    Timber.d("method call onDown")
                    return true
                }

                override fun onScroll(
                    e1: MotionEvent?,
                    e2: MotionEvent?,
                    distanceX: Float,
                    distanceY: Float
                ): Boolean {
                    Timber.d("method call onScroll")
                    Timber.d("onScroll:%s", e1.toString())
                    Timber.d("onScroll:%s", e2.toString())
                    Timber.d("onScroll:distanceX $distanceX")
                    Timber.d("onScroll:distanceY $distanceY")

                    text_view.text = String.format("X:%.4f , Y:%.4f", distanceX, distanceY)
                    if (distanceY > 0f) {
                        text_view.y = text_view.y - distanceY
                    } else {
                        text_view.y = text_view.y - distanceY
                    }

                    Timber.d("y:${text_view.y}")
                    // min 1f
                    // max 100f
                    val textSize = text_view.y / 1600f * 100f
                    text_view.textSize = textSize

                    return true
                }
            })

        root_frame_layout.setOnTouchListener { _, event ->
            gestureDetector.onTouchEvent(event)
        }
    }
}
