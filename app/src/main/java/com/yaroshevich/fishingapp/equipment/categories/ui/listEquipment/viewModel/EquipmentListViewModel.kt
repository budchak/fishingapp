package com.yaroshevich.fishingapp.equipment.categories.ui.listEquipment.viewModel

import androidx.lifecycle.LiveData
import com.yaroshevich.fishingapp.model.equipment.Equipment

interface EquipmentListViewModel {

    fun getEquipmentList(): LiveData<out List<Equipment>>
}