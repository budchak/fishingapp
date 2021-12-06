package com.yaroshevich.fishingapp.di.components

import com.yaroshevich.fishingapp.di.modules.EquipmentDescriptionModule
import com.yaroshevich.fishingapp.equipment.categories.ui.detailEquipment.fragments.ReelDetailFragment
import com.yaroshevich.fishingapp.equipment.categories.ui.detailEquipment.fragments.RodDetailFragment

import dagger.Subcomponent


@Subcomponent(modules = [EquipmentDescriptionModule::class])
interface EquipmentDetailComponent {
    fun inject(fragment: RodDetailFragment)
    fun inject(fragment: ReelDetailFragment)

}