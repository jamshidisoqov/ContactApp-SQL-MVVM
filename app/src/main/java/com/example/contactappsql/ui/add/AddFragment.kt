package com.example.contactappsql.ui.add

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.contactappsql.R
import com.example.contactappsql.data.local.models.Contact
import com.example.contactappsql.databinding.AddFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddFragment : Fragment() {

    private var _binding: AddFragmentBinding? = null
    val binding: AddFragmentBinding get() = _binding!!
    private val addViewModel: AddViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = AddFragmentBinding.inflate(inflater, container, false)

        binding.apply {
            btnAdd.setOnClickListener {
                val name = this.edName.text.toString()
                val number = this.edNumber.text.toString()
                if (isNotFieldEmpty(name , number)) {
                    val contact = Contact(0,name,number)
                    addViewModel.addContact(contact)
                }else{
                    Toast.makeText(context, "Propertys is not filled", Toast.LENGTH_SHORT).show()
                }
            }
        }


        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    fun isNotFieldEmpty(name: String, number: String): Boolean =
        !TextUtils.isEmpty(name) && !TextUtils.isEmpty(number)


}