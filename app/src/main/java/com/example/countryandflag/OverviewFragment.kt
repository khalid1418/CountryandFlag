package com.example.countryandflag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.countryandflag.databinding.FragmentOverviewBinding


class OverviewFragment : Fragment() {
    private val viewmodel: FlagViewModel by viewModels()
    private var _binding:FragmentOverviewBinding?=null
    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)
        _binding?.lifecycleOwner = viewLifecycleOwner
        _binding?.shareview = viewmodel

        return _binding?.root


    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
