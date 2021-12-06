package com.yaroshevich.fishingapp.fishing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.datepicker.MaterialDatePicker
import com.yaroshevich.fishingapp.R
import com.yaroshevich.fishingapp.databinding.FragmentCreateFishingBinding
import com.yaroshevich.fishingapp.model.FishingInfo
import com.yaroshevich.fishingapp.utils.hideKeyboard
import java.text.SimpleDateFormat
import java.util.*

class CreateFishingFragment : Fragment() {

    val builder = MaterialDatePicker.Builder.dateRangePicker()
    val now = Calendar.getInstance()


    lateinit var binding: FragmentCreateFishingBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_create_fishing, container, false
        )
        binding.fisingInfo = FishingInfo()
        binding.lifecycleOwner = this

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        builder.setSelection(androidx.core.util.Pair(now.timeInMillis, now.timeInMillis))
        val picker =
            builder.setTheme(R.style.ThemeOverlay_MaterialComponents_MaterialCalendar).build()
        picker.addOnNegativeButtonClickListener { picker.dismiss() }
        picker.addOnPositiveButtonClickListener {
            val start = Date(it.first)
            val end = Date(it.second)
            val format = SimpleDateFormat("dd.MM.YYYY", Locale.getDefault())

            binding.dateRangeTv.text = "${format.format(start)} - ${format.format(end)}"

        }


        binding.dateView.setOnClickListener {

            picker.show(activity?.supportFragmentManager!!, picker.toString())

        }

        binding.timeView.setOnClickListener {
            picker.show(activity?.supportFragmentManager!!, picker.toString())
        }

        binding.rootView.setOnClickListener {
            binding.nameEd.clearFocus()
            hideKeyboard()
        }

    }

}