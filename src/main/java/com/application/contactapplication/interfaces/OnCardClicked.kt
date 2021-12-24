package com.application.contactapplication.interfaces

import com.application.contactapplication.database.ContactDTO

interface OnCardClicked {

    fun onCardClicked(contactDTO: ContactDTO)

}