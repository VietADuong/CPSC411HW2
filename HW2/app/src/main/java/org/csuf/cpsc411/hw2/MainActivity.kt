package org.csuf.cpsc411.hw2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

open class MainActivity : AppCompatActivity() {
    lateinit var cClaimEntity : ClaimEntity
    lateinit var claimService : ClaimService
    lateinit var newClaimEntity : ClaimEntity
    fun refreshScreen() {
        //
        Log.d("Person Service", "Refreshing the Screen. ")
        val claimView : EditText = findViewById(R.id.claim_title)
        val statusView : TextView = findViewById(R.id.status_msg)
        val dateView : EditText = findViewById(R.id.claim_date)
        claimView.setText("")
        claimView.setTextColor(Color.RED)
        dateView.setText("")
        dateView.setTextColor(Color.BLUE)
        statusView.setText("")
        statusView.setTextColor(Color.CYAN)
        //

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Claim Service", "Refreshing the Screen. ")
        val fldRowGenerator = ClaimObjDetailScreenGenerator(this)
        val viewAll = fldRowGenerator.generate()
        setContentView(viewAll)
        //
        val bView : Button = findViewById(R.id.add_btn)
        bView.setOnClickListener{

            val claimView : EditText = findViewById(R.id.claim_title)
            val statusView : TextView = findViewById(R.id.status_msg)
            val dateView : EditText = findViewById(R.id.claim_date)
            if (claimView.text.toString().equals("")&&
                dateView.text.toString().equals("")
            //&&statusView.text.toString()==""
            ) {
                bView.setEnabled(true)//disabled the button 
               // statusView.text =
                    "Invalid,You add no value,please try again!" //print out the invalid message if adding no value
                //statusView.setTextColor(Color.RED)
            }else {
                newClaimEntity = ClaimEntity(claimView.text.toString()!!, dateView.text.toString()!!)
                //
                claimService = ClaimService.getInstance(this)
                claimService.addClaim(newClaimEntity)
                /*)
                dateView
                claimView.setTextColor(Color.RED)
                claimView.setText("".setTextColor(Color.BLUE)
                dateView.setText("")
                statusView.setTextColor(Color.CYAN)
                statusView.setText("")
                */
                refreshScreen()
                Log.d("Clear method", "clear the user input")
            }
        }
    }
}