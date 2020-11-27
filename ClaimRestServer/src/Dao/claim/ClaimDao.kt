package csuf.cpsc411.Dao.claim

import csuf.cpsc411.Dao.Dao
import org.csuf.cpsc411test.Dao.Database

class ClaimDao : Dao() {

    fun addClaim(claimEntityObj : ClaimEntity) {
        // First, get database connection
        val conn = Database.getInstance()?.getDbConnection()
        // Second, prepare the SQL statement
        sqlStmt = "insert into claim (title, date) values ('${claimEntityObj.title}', '${claimEntityObj.date}')"
        // Third, submit the SQL statement
        conn?.exec(sqlStmt)
    }


    fun getAll() : List<ClaimEntity> {
        // First, get database connection
        val conn = Database.getInstance()?.getDbConnection()

        // Second, prepare the SQL statement
        sqlStmt = "select title, date from claim"

        // Third, submit the SQL statement
        var claimEntityList : MutableList<ClaimEntity> = mutableListOf()
        val st = conn?.prepare(sqlStmt)

        while(st?.step()!!){
            //Convert each record into Claim object
            val title = st.columnString(0)
            val date = st.columnString(1)
            claimEntityList.add(ClaimEntity(title,date))
        }

        return claimEntityList
    }

}