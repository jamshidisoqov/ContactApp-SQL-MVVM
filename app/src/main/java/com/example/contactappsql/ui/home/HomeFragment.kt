package com.example.contactappsql.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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

        viewModel.getAllData()

        adapter = ContactAdapter()

        binding.contactRcv.adapter = adapter

        binding.apply {
            imgAdd.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_addFragment)
            }
        }

        viewModel.allContact.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}