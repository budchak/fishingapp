package com.yaroshevich.fishingapp.equipment.categories.ui.listEquipment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yaroshevich.fishingapp.model.equipment.Equipment
import com.yaroshevich.fishingapp.model.equipment.Reel
import javax.inject.Inject

class ReelViewModel @Inject constructor() : EquipmentListViewModel {

    val rods = listOf(
        Reel("Reel 1"),
        Reel("Reel 2"),
        Reel("Reel 3"),
        Reel("Reel 4"),
        Reel("Reel 5"),
        Reel("Reel 6"),
        Reel("Reel 7"),
        Reel("Reel 8")
    )

    private val liveRodList = MutableLiveData<List<Equipment>>(mutableListOf())

    init {
        liveRodList.value = rods
    }


    override fun getEquipmentList(): LiveData<out List<Equipment>> {
        return liveRodList
    }
}