package com.yaroshevich.fishingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.yaroshevich.fishingapp.databinding.FragmentInWorkBinding

class HolderFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentInWorkBinding>(
            inflater,
            R.layout.fragment_in_work,
            container,
            false
        )
        return binding.root
    }
}