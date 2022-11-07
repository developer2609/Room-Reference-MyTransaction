package com.example.cardtransaction.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cardtransaction.R
import com.example.cardtransaction.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater)

        binding.cardButton.setOnClickListener {
            findNavController().navigate(R.id.cardFragment)
        }

        binding.transaction.setOnClickListener {
            findNavController().navigate(R.id.transactionFragment)
        }

        // Inflate the layout for this fragment
        return binding.root
    }


}