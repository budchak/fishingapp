package com.yaroshevich.fishingapp.di.modules

import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.fishingapp.mainScreen.ui.viewmodel.AppFunctionViewModel
import com.yaroshevich.fishingapp.mainScreen.ui.viewmodel.TestAppFunctionViewModel
import com.yaroshevich.fishingapp.recycler.BounceEdgeEffectFactory
import dagger.Binds
import dagger.Module

@Module
interface BindsMainScreenModule {

    @Binds
    fun bindBounceEdgeEffectFactoryToRecyclerEdgeEffectFactory(edgeEffectFactory: BounceEdgeEffectFactory): RecyclerView.EdgeEffectFactory

    @Binds
    fun bindAppFunctionViewModel(viewModel: TestAppFunctionViewModel): AppFunctionViewModel
}