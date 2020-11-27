package org.csuf.cpsc411.hw2

import android.graphics.Color
import android.graphics.Typeface
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import org.w3c.dom.Text

class ClaimService(val ctx : MainActivity) {
    var claimList :MutableList<ClaimEntity> = mutableListOf()
    lateinit var cClaimEntity : ClaimEntity
    lateinit var claimService : ClaimService

    companion object {
        private var claimService : ClaimService? = null
        //
        fun getInstance(act : MainActivity) : ClaimService {
            if(claimService == null) {
                claimService = ClaimService(act)
            }

            return claimService!!
        }
    }
//

    //
    inner class addServiceRespHandler : AsyncHttpResponseHandler() {
        //when success, display the successfully message
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            //print out success message 
            if (responseBody != null) {
                val respStr = String(responseBody)
                val claimView : TextView = ctx.findViewById(R.id.status_msg)
                val dateView : TextView = ctx.findViewById(R.id.claim_date)
                //val titleView:TextView=ctx.findViewById(R.id.claim_title)
                claimView.text = "Claim ${cClaimEntity.title} was successfully created ."
               // dateView.text = "Claim ${cClaimEntity.date} was successfully created ."
                claimView.setTextColor(Color.RED)
                claimView.setTypeface(null, Typeface.BOLD_ITALIC)
                Log.d("Claim Service", "The add claim response : ${respStr}")

            }

        }
        //
        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {//print out message if it is failed to created
            // dateView.text = "Claim ${cClaimEntity.date} was successfully created ."
            val claimView : TextView = ctx.findViewById(R.id.status_msg)
            val dateView:TextView=ctx.findViewById(R.id.claim_date)
           //val titleView:TextView=ctx.findViewById(R.id.claim_title)
            claimView.text="Claim ${cClaimEntity.title} was failed to created "
            Log.d("Claim Service", "The add claim have no value ")

        }
    }

    //add claim functions
    fun addClaim(claimObj : ClaimEntity) {
        cClaimEntity = claimObj
        val client = AsyncHttpClient()
        val requestUrl = "http://192.168.1.29:8084/ClaimService/add"
        // 1. Convert the pObj into JSON string
        val cJsonString= Gson().toJson(claimObj)
        // 2. Send the post request
        val entity = StringEntity(cJsonString)
        // cxt is an Android Application Context object
        client.post(ctx, requestUrl, entity,"application/json", addServiceRespHandler())
    }

}