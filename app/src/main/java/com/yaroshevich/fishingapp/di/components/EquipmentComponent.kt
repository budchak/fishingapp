package com.yaroshevich.fishingapp.di.components

import com.yaroshevich.fishingapp.di.modules.EquipmentModule
import com.yaroshevich.fishingapp.equipment.categories.ui.listEquipment.fragments.EquipmentListFragment
import com.yaroshevich.fishingapp.equipment.ui.fragments.EquipmentCategoriesFragment

import dagger.Subcomponent

@Subcomponent(modules = [EquipmentModule::class])
interface EquipmentComponent {

    fun inject(fragment: EquipmentCategoriesFragment)
    fun inject(fragment: EquipmentListFragment)

    @Subcomponent.Builder
    interface Builder {
        fun equipmentCategoryModule(module: EquipmentModule): Builder
        fun build(): EquipmentComponent
    }
}