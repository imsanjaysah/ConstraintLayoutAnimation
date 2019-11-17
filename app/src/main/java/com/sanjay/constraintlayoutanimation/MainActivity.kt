package com.sanjay.constraintlayoutanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.transition.TransitionManager
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var constraintSet = ConstraintSet()
    private var animateConstraintSet = ConstraintSet()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        animateViews()
    }

    private fun animateViews() {
        constraintSet.clone(parentConstraintLayout)
        animateConstraintSet.clone(this, R.layout.content_main_2)

        Handler().postDelayed({
            TransitionManager.beginDelayedTransition(parentConstraintLayout)
            animateConstraintSet.applyTo(parentConstraintLayout)
        }, 2000)

    }
}
