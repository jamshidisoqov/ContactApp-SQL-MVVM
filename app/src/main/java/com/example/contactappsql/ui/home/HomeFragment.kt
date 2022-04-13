package com.example.contactappsql.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contactappsql.R
import com.example.contactappsql.databinding.HomeFragmentBinding
import com.example.contactappsql.ui.home.adapter.ContactAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: HomeFragmentBinding? = null
    val binding: HomeFragmentBinding get() = _binding!!
    val viewModel: HomeViewModel by viewModel()
    private lateinit var adapter: ContactAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = HomeFragmentBinding.inflate(inflater, container, false)

        adapter = ContactAdapter()

        binding.contactRcv.adapter=adapter

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}