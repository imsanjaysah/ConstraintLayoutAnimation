package com.sanjay.constraintlayoutanimation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.transition.TransitionManager
import android.view.View
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_register.*


class LoginRegisterActivity : AppCompatActivity(), View.OnClickListener {


    private var loginConstraintSet = ConstraintSet()
    private var fadeConstraintSet = ConstraintSet()
    private var registerConstraintSet = ConstraintSet()
    private var isLoginView = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        changeConstraintsForLogin()
    }

    private fun changeConstraintsForLogin() {
        loginConstraintSet.clone(parentConstraintLayout)
        registerConstraintSet.clone(parentConstraintLayout)

        loginConstraintSet.setVisibility(R.id.editTextName, ConstraintSet.GONE)
        loginConstraintSet.setVisibility(R.id.editTextCompany, ConstraintSet.GONE)
        loginConstraintSet.setVisibility(R.id.editTextMobile, ConstraintSet.GONE)

        button.text = getString(R.string.login)
        textViewLogin.text = getString(R.string.register)

        loginConstraintSet.applyTo(parentConstraintLayout)

        fadeConstraintSet.clone(loginConstraintSet)
        fadeConstraintSet.setVisibility(R.id.editTextEmail, ConstraintSet.GONE)
        fadeConstraintSet.setVisibility(R.id.editTextPassword, ConstraintSet.GONE)
        fadeConstraintSet.setVisibility(R.id.button, ConstraintSet.GONE)
        fadeConstraintSet.setVisibility(R.id.textViewLogin, ConstraintSet.GONE)
        fadeConstraintSet.setVisibility(R.id.textViewHelp, ConstraintSet.GONE)

        fadeConstraintSet.applyTo(parentConstraintLayout)

        Handler().postDelayed({
            TransitionManager.beginDelayedTransition(parentConstraintLayout)
            loginConstraintSet.applyTo(parentConstraintLayout)

        }, 500)



        textViewLogin.setOnClickListener(this)
        button.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v == textViewLogin) {
            isLoginView = !isLoginView
            TransitionManager.beginDelayedTransition(parentConstraintLayout)

            if (isLoginView) {
                button.text = getString(R.string.login)
                textViewLogin.text = getString(R.string.register)
                loginConstraintSet.applyTo(parentConstraintLayout)

            } else {
                button.text = getString(R.string.register)
                textViewLogin.text = getString(R.string.login)
                editTextPassword.setText("")
                registerConstraintSet.applyTo(parentConstraintLayout)

            }
        } else {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}
