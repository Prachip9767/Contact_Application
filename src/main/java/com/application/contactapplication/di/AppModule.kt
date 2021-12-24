package com.application.contactapplication.di

import android.content.Context
import androidx.room.Room
import com.application.contactapplication.database.AppDao
import com.application.contactapplication.database.AppRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppRoomDatabase {
        val builder = Room.databaseBuilder(
            context,
            AppRoomDatabase::class.java,
            "contact_db"
        )
        builder.fallbackToDestructiveMigration()
        return builder.build()
    }

    @Provides
    @Singleton
    fun providesDao(db: AppRoomDatabase): AppDao {
        return db.getAppDao()
    }
}