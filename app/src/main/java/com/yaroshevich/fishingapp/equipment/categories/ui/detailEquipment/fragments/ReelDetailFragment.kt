package com.yaroshevich.fishingapp.equipment.categories.ui.detailEquipment.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yaroshevich.fishingapp.App
import com.yaroshevich.fishingapp.di.modules.EquipmentDescriptionModule
import com.yaroshevich.fishingapp.equipment.categories.ui.detailEquipment.viewModel.EquipmentDetailViewModel
import com.yaroshevich.fishingapp.model.NameValue
import com.yaroshevich.fishingapp.model.equipment.NameValueList
import com.yaroshevich.fishingapp.model.equipment.Reel

class ReelDetailFragment : EquipmentDetailFragment() {

    val rodToValueConverter: (rod: Reel) -> List<NameValue> = { equipment: Reel ->
        mutableListOf(
            NameValue("model", equipment.getTitle()),
            NameValue("test", "min - 15   max - 300")
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        App.getInstance().appComponent.plus(EquipmentDescriptionModule()).inject(this)

        equipmentDetailViewModel = object : EquipmentDetailViewModel {

            override fun getDetail(id: Int): LiveData<NameValueList> {

                return MutableLiveData(Reel("Катушка просто класс"))

            }

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val equipment = equipmentDetailViewModel.getDetail(arg)

        equipment.observe(viewLifecycleOwner, {


        })

    }
}