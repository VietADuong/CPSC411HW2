package org.csuf.cpsc411.hw2

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.LinearLayout

class FieldValueViewGenerator (val ctx : Context) {
    lateinit var layoutObj : LinearLayout
    fun generate() : LinearLayout {

        layoutObj = LinearLayout(ctx)

        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.HORIZONTAL
        layoutObj.setBackgroundColor(Color.WHITE)
        //
        val cParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
        //label Column Generator
        val lcGenerator = LabelColumnGenerator(ctx)
        var lblView = lcGenerator.generate()
        cParams.marginStart=10
        cParams.weight = 5.0F
        layoutObj.addView(lblView, cParams)
        //Value Column Generator
        val vcGenerator = ValueColumnGenerator(ctx)
        lblView = vcGenerator.generate()
        //
        val vParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
        vParams.marginStart = 10
        vParams.weight = 5.0F
        layoutObj.addView(lblView, vParams)

        return layoutObj
    }
}