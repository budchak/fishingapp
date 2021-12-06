package com.yaroshevich.fishingapp.di.modules

import com.yaroshevich.fishingapp.App
import com.yaroshevich.fishingapp.di.components.EquipmentComponent
import dagger.Module


@Module(subcomponents = [EquipmentComponent::class])
abstract class AppModule(val app: App) {

}