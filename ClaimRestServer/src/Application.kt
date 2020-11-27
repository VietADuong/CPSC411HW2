package csuf.cpsc411

import com.google.gson.Gson
import csuf.cpsc411.Dao.claim.ClaimEntity
import csuf.cpsc411.Dao.claim.ClaimDao
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.utils.io.*
import java.util.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    routing {
        get("/ClaimService/getAll"){
            val claimList = ClaimDao().getAll()
            println("The number of claims is:  ${claimList.size}")
            val respJsonStr = Gson().toJson(claimList)
            println("HTTP message is using GET method with /getAll")
            call.respondText(respJsonStr, status = HttpStatusCode.OK, contentType = ContentType.Application.Json)
        }

        post("/ClaimService/add"){
            val data = call.request.receiveChannel()
            val dataLength = data.availableForRead
            val output = ByteArray(dataLength)
            data.readAvailable(output)
            val str1 = String(output)

            var gsStr = Gson().fromJson(str1, ClaimEntity::class.java)
            var cObj : ClaimEntity
            cObj = ClaimEntity(gsStr.title, gsStr.date)
            ClaimDao().addClaim(cObj)

            println("HTTP message is using POST method with /Add")
            call.respondText("The POST request was successfully processed...",
                status = HttpStatusCode.OK, contentType = ContentType.Text.Plain)
        }

    }

}

