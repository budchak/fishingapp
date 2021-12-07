package com.yaroshevich.fishingapp.equipment.categories.ui.listEquipment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yaroshevich.fishingapp.model.equipment.Equipment
import com.yaroshevich.fishingapp.model.equipment.Rod
import com.yaroshevich.fishingapp.model.equipment.Test

import javax.inject.Inject

class TestEquipmentViewModel @Inject constructor() : EquipmentListViewModel() {

    val rods = listOf(
        EquipmentPreview(1,"Rod","Крутая удочка" ),
        EquipmentPreview(1,"Bait","Крутая удочка" ),
        EquipmentPreview(1,"Reel","Крутая удочка" ),
        EquipmentPreview(1,"Reel","Крутая удочка" ),
        EquipmentPreview(1,"Rod","Крутая удочка" ),
        EquipmentPreview(1,"Rig","Крутая удочка" ),
        EquipmentPreview(1,"Reel","просто катушка" ),
        EquipmentPreview(1,"Rod","Крутая удочка" ),
        EquipmentPreview(1,"Rod","Крутая удочка" ),
        EquipmentPreview(1,"Reel","Крутая катушка" ),
        EquipmentPreview(1,"Rod","Крутая удочка" )

    )

    override fun loadEquipmentList(type: String) {

        liveEquipment.value = rods.getBy(type)
        
    }





}

fun List<EquipmentPreview>.getBy(type: String): List<EquipmentPreview>{
    val result = mutableListOf<EquipmentPreview>()

    this.forEach {
        if (it.type == type) result.add(it)
    }

    return result
}


class EquipmentPreview(val id: Int, val type: String, val name: String)