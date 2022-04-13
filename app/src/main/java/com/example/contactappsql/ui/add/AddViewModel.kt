package com.example.contactappsql.ui.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.contactappsql.data.local.models.Contact
import com.example.contactappsql.ui.add.usecase.AddUseCase

class AddViewModel(application: Application,var addUseCase: AddUseCase) : AndroidViewModel(application) {

    fun addContact(contact: Contact){
        addUseCase.addContact(contact)
    }

}