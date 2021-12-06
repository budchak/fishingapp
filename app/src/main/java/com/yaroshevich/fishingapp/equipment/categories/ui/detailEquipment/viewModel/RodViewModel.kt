package com.yaroshevich.fishingapp.equipment.categories.ui.detailEquipment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yaroshevich.fishingapp.model.equipment.NameValueList

class RodViewModel : EquipmentDetailViewModel {

    override fun getDetail(id: Int): LiveData<NameValueList> {

        return MutableLiveData()

    }
}