package com.example.contactappsql.ui.add.usecase

import com.example.contactappsql.data.local.DatabaseQueryImpl
import com.example.contactappsql.data.local.models.Contact

class AddUseCase(var databaseQueryImpl: DatabaseQueryImpl) {
    fun addContact(contact: Contact) {
        databaseQueryImpl.insertContact(contact)
    }
}