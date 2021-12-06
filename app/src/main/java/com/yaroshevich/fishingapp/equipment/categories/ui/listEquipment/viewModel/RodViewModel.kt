package com.yaroshevich.fishingapp.equipment.categories.ui.listEquipment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yaroshevich.fishingapp.model.equipment.Equipment
import com.yaroshevich.fishingapp.model.equipment.Rod
import com.yaroshevich.fishingapp.model.equipment.Test

import javax.inject.Inject

class RodViewModel @Inject constructor() : EquipmentListViewModel {

    val rods = listOf(
        Rod("Крутая удочка", "175", Test("15", "223")),
        Rod("Крутая удочка", "175", Test("15", "223")),
        Rod("Крутая удочка", "175", Test("15", "223")),
        Rod("Крутая удочка", "175", Test("15", "223")),
        Rod("Крутая удочка", "175", Test("15", "223")),
        Rod("Крутая удочка", "175", Test("15", "223")),
        Rod("Крутая удочка", "175", Test("15", "223")),
        Rod("Крутая удочка", "175", Test("15", "223")),
        Rod("Крутая удочка", "175", Test("15", "223")),
        Rod("Крутая удочка", "175", Test("15", "223")),
        Rod("Крутая удочка", "175", Test("15", "223"))

    )

    private val liveRodList = MutableLiveData<List<Equipment>>(rods)

    init {
        liveRodList.value = rods
    }

    override fun getEquipmentList(): LiveData<List<Equipment>> {
        return liveRodList
    }

}