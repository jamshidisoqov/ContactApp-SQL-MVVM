package com.example.contactappsql.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactappsql.R
import com.example.contactappsql.databinding.ContactRcvItemBinding

class ContactAdapter() : RecyclerView.Adapter<ContactAdapter.Vh>() {

    private lateinit var binding: ContactRcvItemBinding

    inner class Vh(var binding: ContactRcvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind() {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        binding = ContactRcvItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.contact_rcv_item, parent, false)
        )
        return Vh(binding)
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {

    }

    override fun getItemCount(): Int = 20
}