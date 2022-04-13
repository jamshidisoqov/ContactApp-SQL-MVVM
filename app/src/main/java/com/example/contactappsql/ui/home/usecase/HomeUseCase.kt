package com.example.contactappsql.ui.home.usecase

import com.example.contactappsql.data.local.DatabaseQueryImpl
import com.example.contactappsql.data.local.models.Contact

class HomeUseCase(var queryImpl: DatabaseQueryImpl) {

    fun getAllContact(): List<Contact> = queryImpl.getAllContact()

}