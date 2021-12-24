package com.application.contactapplication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.application.contactapplication.database.ContactDTO
import com.application.contactapplication.repositories.AppRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContactViewModels @Inject constructor(private val appRepositories: AppRepositories) : ViewModel(){

    fun getAllPagingData(context : ArrayList<ContactDTO>) = appRepositories.getPagingData(context)

    fun insertDataToDb(contactDTO: ArrayList<ContactDTO>){
        appRepositories.insertDataToDb(contactDTO)
    }

    fun getAppContactFromDb() : LiveData<List<ContactDTO>>{
        return appRepositories.getAllDataFromDb()
    }

    fun updateContact(contactDTO: ContactDTO){
        appRepositories.updateDbData(contactDTO)
    }



}