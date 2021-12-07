package com.yaroshevich.fishingapp.equipment.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yaroshevich.fishingapp.HolderFragment
import com.yaroshevich.fishingapp.equipment.model.CategoryEnum
import com.yaroshevich.fishingapp.equipment.ui.viewModel.EquipmentCategoriesViewModel
import javax.inject.Inject

class EquipmentCategoriesStateAdapter @Inject constructor(
    fragment: Fragment,
    val viewModel: EquipmentCategoriesViewModel,
    val factory: ListFragmentFactory
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return viewModel.getCategoriesCount()
    }

    override fun createFragment(position: Int): Fragment {
        return when (viewModel.getCategory(position)) {
            CategoryEnum.ROD -> factory.createFragment("Rod")
            CategoryEnum.REEL -> factory.createFragment("Reel")
            CategoryEnum.BAIT -> factory.createFragment("Bait")
            CategoryEnum.OTHER -> factory.createFragment("Rig")
            else -> HolderFragment()
        }


    }


}