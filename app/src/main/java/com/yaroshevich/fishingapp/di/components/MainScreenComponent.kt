package com.yaroshevich.fishingapp.di.components

import com.yaroshevich.fishingapp.di.modules.MainScreenModule
import com.yaroshevich.fishingapp.mainScreen.ui.fragments.AppFunctionFragment
import dagger.Subcomponent

@Subcomponent(modules = [MainScreenModule::class])
interface MainScreenComponent {
    fun inject(fragment: AppFunctionFragment)
}