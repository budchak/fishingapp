package com.yaroshevich.fishingapp.equipment.ui.fragments

import com.yaroshevich.fishingapp.equipment.categories.ui.listEquipment.viewModel.EquipmentListViewModel
import com.yaroshevich.fishingapp.recycler.BindingRecyclerViewAdapter
import javax.inject.Inject
import javax.inject.Provider

class EquipmentInjector @Inject constructor(
    val viewModelMap: Map<String, @JvmSuppressWildcards Provider<EquipmentListViewModel>>,
    val adapterMap: Map<String, @JvmSuppressWildcards Provider<BindingRecyclerViewAdapter>>
) {


    fun getViewModel(type: String): EquipmentListViewModel {
        return viewModelMap[type]?.get() ?: throw Exception("Нет такого типа $type")
    }

    fun getAdapter(type: String): BindingRecyclerViewAdapter {
        return adapterMap[type]?.get() ?: throw Exception("Нет такого типа $type")
    }
}