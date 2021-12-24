package com.application.contactapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_db")
data class ContactDTO(

    @ColumnInfo(name = "contact_name")
    var contactName: String,
    @ColumnInfo(name = "contact_number")
    var contactPhoneNumber: String,
    @ColumnInfo(name = "contact_count")
    var contactCount: Int? = 0,
) {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
