package com.yaroshevich.fishingapp.equipment.categories.ui.listEquipment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yaroshevich.fishingapp.model.equipment.Equipment

abstract class EquipmentListViewModel() {

    protected val liveEquipment: MutableLiveData<out List<EquipmentPreview>> = MutableLiveData()

    fun getEquipmentList(): LiveData<out List<EquipmentPreview>>{
        return liveEquipment
    }

    abstract fun loadEquipmentList(type: String)


}