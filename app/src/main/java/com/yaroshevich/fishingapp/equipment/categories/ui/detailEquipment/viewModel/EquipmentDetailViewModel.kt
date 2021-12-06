package com.yaroshevich.fishingapp.equipment.categories.ui.detailEquipment.viewModel

import androidx.lifecycle.LiveData
import com.yaroshevich.fishingapp.model.equipment.NameValueList

interface EquipmentDetailViewModel {


    fun getDetail(id: Int): LiveData<NameValueList>

}