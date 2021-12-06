package com.yaroshevich.fishingapp.equipment.ui.viewModel

import androidx.lifecycle.LiveData
import com.yaroshevich.fishingapp.model.equipment.Equipment

interface EquipmentViewModel {


    fun getEquipment(): LiveData<Equipment>


}