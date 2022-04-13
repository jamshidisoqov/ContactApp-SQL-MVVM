package com.example.contactappsql.data.local

import com.example.contactappsql.data.local.models.Contact

interface DatabaseQuery {

    fun insertContact(contact: Contact)

    fun getAllContact():List<Contact>

    fun searchContact():List<Contact>

    fun deleteContact(pos:Int)


}