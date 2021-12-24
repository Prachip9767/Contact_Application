package com.application.contactapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ContactDTO::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun getAppDao(): AppDao

}