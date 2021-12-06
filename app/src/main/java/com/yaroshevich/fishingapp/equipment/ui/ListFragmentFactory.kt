package com.yaroshevich.fishingapp.equipment.ui

import androidx.fragment.app.Fragment
import com.yaroshevich.fishingapp.equipment.categories.ui.listEquipment.fragments.EquipmentListFragment

import javax.inject.Inject

class ListFragmentFactory @Inject constructor() {

    fun createFragment(type: String): Fragment {

        return EquipmentListFragment.newInstance(type)
    }
}