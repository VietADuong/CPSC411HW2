package org.csuf.cpsc411.hw2

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
//making value column field generator
class ValueColumnGenerator (val ctx : Context) {
    fun generate() : LinearLayout {
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.WHITE)
        //
        val vParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        vParams.topMargin = 5
        //
        var value = EditText(ctx)
        value.id = R.id.claim_title
        value.setTextColor(Color.RED)
        value.setHint("Enter Your Claim Title ")
        //value.setPadding(20,20,20,20)
        layoutObj.addView(value, vParams)
        //
        value = EditText(ctx)
        value.id = R.id.claim_date
        value.setTextColor(Color.BLUE)
        value.setHint("MM/DD/YYYY")
        //value.setPadding(20,20,20,20)
        layoutObj.addView(value, vParams)

        return layoutObj
    }
}