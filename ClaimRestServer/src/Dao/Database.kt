package org.csuf.cpsc411test.Dao
import com.almworks.sqlite4java.SQLiteConnection
import java.io.File

class Database constructor(var dbName : String = ""){

    init {
        // Create the database, tables, and keep the database connection
        dbName = "C:\\Users\\vieta\\Desktop\\claimDb1.db"
        val dbConn = SQLiteConnection(File(dbName))
        dbConn.open()
        val sqlStmt = "create table if not exists claim (title text, date text)"
        dbConn.exec(sqlStmt)
    }

    fun getDbConnection() : SQLiteConnection{
        val dbConn = SQLiteConnection(File(dbName))
        dbConn.open()
        return dbConn
    }

    companion object {
        private var dbObj : Database? = null

        fun getInstance() : Database?{
            if(dbObj == null){
                dbObj = Database()
            }
            return dbObj
        }
    }
}