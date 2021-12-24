package com.application.contactapplication.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDataInDatabase(contactDTO: List<ContactDTO>)

    @Query("select * from contact_db order by contact_count")
    fun getAllDatFromDb() : LiveData<List<ContactDTO>>

    @Update
    suspend fun updateContactOfDB(contactDTO: ContactDTO)

}