package org.csuf.cpsc411.hw2

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class LabelColumnGenerator (val ctx : Context) {

    fun generate() : LinearLayout {
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.WHITE)
        val lbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        lbParams.weight = 5.0F
        lbParams.topMargin = 5
        lbParams.setMargins(5,0,0,0)
        //claim title column
        var lbl = TextView(ctx)
        lbl.text = "Claim Title"
        lbl.textSize= 18F
        lbl.setPadding(5,5,5,5)
        lbl.setTextColor(Color.RED)
        lbl.setTypeface(null, Typeface.BOLD)
        lbl.gravity = Gravity.CENTER_VERTICAL
        lbl.setBackgroundColor(Color.WHITE)
        layoutObj.addView(lbl, lbParams)
        //Date column
        lbl = TextView(ctx)
        lbl.text = "Date"
        lbl.textSize= 18F
        lbl.setPadding(5,5,5,5)
        lbl.setTextColor(Color.BLUE)
        lbl.setTypeface(null, Typeface.BOLD)
        lbl.gravity = Gravity.CENTER_VERTICAL
        lbl.setBackgroundColor(Color.WHITE)
        layoutObj.addView(lbl, lbParams)

        return layoutObj
    }
}