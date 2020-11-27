package org.csuf.cpsc411.hw2

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView


class ClaimObjDetailScreenGenerator(val ctx : Context) {

    lateinit var layoutObj : LinearLayout
    fun generate() : LinearLayout {
        // 1. Create a LinearLayout Obj
        layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL

        //Title header
        val tlbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        tlbParams.weight = 1.0F
        tlbParams.topMargin = 5
        var lbl = TextView(ctx)
        lbl.text = "Please Enter Claim Information"
        lbl.setTextColor(Color.MAGENTA)
        lbl.setTypeface(null, Typeface.BOLD)
        lbl.textSize = 20F
        lbl.gravity = Gravity.CENTER_HORIZONTAL
        lbl.setBackgroundColor(Color.WHITE)
        layoutObj.addView(lbl, tlbParams)

        //2. Add ObjDetailSection
        val fldRowGenerator = FieldValueViewGenerator(ctx)
        val colView = fldRowGenerator.generate()
        layoutObj.addView(colView)

        //3. Add add Button
        val nLayout = LinearLayout(ctx)
        val nParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        nParams.gravity = Gravity.RIGHT
        nParams.setMargins(20,20,50,20)
        nLayout.orientation = LinearLayout.HORIZONTAL
        nLayout.layoutParams = nParams
        nLayout.setBackgroundColor(Color.WHITE)
        //
        val nButton = Button(ctx)
        nButton.text = "Add"
        nButton.setTypeface(null, Typeface.BOLD)
        nButton.setBackgroundColor(Color.CYAN)
        nButton.setId(R.id.add_btn)
        //nButton.setPadding(20,20,50,20)
        // nButton.setOnClickListener(
        //    View.OnClickListener { {
        //        nButton.text="You just click me"
        //     } }
        // )
        val nbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        //
       // val sMessageGenerator = StatusMessageGenerator(ctx)
       // val bColView = sMessageGenerator.generate()
       // layoutObj.addView(bColView)
        //bColView.setHorizontalGravity(20)
        nbParams.gravity= Gravity.BOTTOM
        nLayout.addView(nButton, nbParams)
        layoutObj.addView(nLayout)
        //generate status messages at the bottom by calling StatusMessageGenerator
        //////////////////////

       var sMsgGenerator = StatusMessageGenerator(ctx)
        val ColView = sMsgGenerator.generate()
        layoutObj.addView(ColView)
        //bColView.setHorizontalGravity(20)


        return layoutObj
    }
}
class StatusMessageGenerator (val ctx : Context) {
    fun generate(): LinearLayout {

        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.HORIZONTAL
        layoutObj.setBackgroundColor(Color.WHITE)

        //Status side by side
        val slbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        var lbl = TextView(ctx)
        slbParams.gravity = Gravity.BOTTOM
        lbl.text = "                             Status: "
        lbl.gravity=Gravity.CENTER_HORIZONTAL
        lbl.setBackgroundColor(Color.WHITE)
        lbl.setTextColor(Color.GREEN)
        lbl.setTypeface(null, Typeface.BOLD)
        lbl.gravity = Gravity.CENTER
        layoutObj.addView(lbl, slbParams)
        //Status Message side by side
        val msglbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        //lbParams2.topMargin = 10
        msglbParams.weight = 20.0F
        lbl = TextView(ctx)
        lbl.text = "<Status Message>"
        lbl.setBackgroundColor(Color.WHITE)
        lbl.setTypeface(null, Typeface.BOLD)
        lbl.id = R.id.status_msg
        lbl.setTextColor(Color.GREEN)
        lbl.gravity = Gravity.CENTER
        layoutObj.addView(lbl, msglbParams)

        return layoutObj
    }
}

