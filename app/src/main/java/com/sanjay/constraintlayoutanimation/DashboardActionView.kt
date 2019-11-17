package com.logicare.treel.ui.customviews

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.sanjay.constraintlayoutanimation.R


/**
 * @author Sanjay Sah on 02/11/2017.
 */
class DashboardActionView(context: Context, attrs: AttributeSet): FrameLayout(context, attrs) {


    var title: TextView
    private var backgroundView: View

    init {
        val a = context.obtainStyledAttributes(attrs,
                R.styleable.DashboardActionViewAttrs, 0, 0)

        val textValue = a.getString(R.styleable.DashboardActionViewAttrs_text)
        @SuppressLint("ResourceAsColor")
        val textColor = a.getColor(R.styleable.DashboardActionViewAttrs_textColor, android.R.color.white)
        a.recycle()

        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.dashboard_action, this, true)

        backgroundView = getChildAt(0)
        backgroundView.rotation = 45f
        title = getChildAt(1) as TextView
        title.text = textValue
        title.setTextColor(textColor)

    }

    fun getView(): View {
        return backgroundView
    }

    fun setText(text: String) {
        title.text = text
    }
}