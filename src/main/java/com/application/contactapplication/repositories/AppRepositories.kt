package com.application.contactapplication.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.application.contactapplication.database.AppDao
import com.application.contactapplication.database.ContactDTO
import com.application.contactapplication.ui.PagingSourceItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AppRepositories @Inject constructor(
    private val appDao: AppDao
) {

    fun getPagingData(context: ArrayList<ContactDTO>) = Pager(
        config = PagingConfig(
            pageSize = 20
        ),
        pagingSourceFactory = { PagingSourceItem(context) }
    ).liveData

    fun insertDataToDb(contactDTO: List<ContactDTO>) {
        CoroutineScope(Dispatchers.IO).launch {
            appDao.insertDataInDatabase(contactDTO)
        }
    }


    fun getAllDataFromDb(): LiveData<List<ContactDTO>> {
        return appDao.getAllDatFromDb()
    }

    fun updateDbData(contactDTO: ContactDTO) {
        CoroutineScope(Dispatchers.IO).launch {
            appDao.updateContactOfDB(contactDTO)
        }
    }
}