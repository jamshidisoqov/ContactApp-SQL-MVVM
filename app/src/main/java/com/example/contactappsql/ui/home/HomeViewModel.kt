package com.example.contactappsql.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.contactappsql.data.local.models.Contact
import com.example.contactappsql.ui.home.usecase.HomeUseCase

class HomeViewModel(application: Application, var homeUseCase: HomeUseCase) :
    AndroidViewModel(application) {

    private var _allContact: MutableLiveData<List<Contact>> = MutableLiveData<List<Contact>>()
    val allContact: LiveData<List<Contact>> get() = _allContact

    fun getAllData() {
        val list = homeUseCase.getAllContact()
        _allContact.value = list
    }

}