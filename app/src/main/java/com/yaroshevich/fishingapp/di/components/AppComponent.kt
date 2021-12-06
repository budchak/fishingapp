package com.yaroshevich.fishingapp.di.components

import com.yaroshevich.fishingapp.App
import com.yaroshevich.fishingapp.MainActivity
import com.yaroshevich.fishingapp.di.modules.AppModule
import com.yaroshevich.fishingapp.di.modules.EquipmentDescriptionModule
import com.yaroshevich.fishingapp.di.modules.MainScreenModule
import dagger.BindsInstance
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun plus(module: EquipmentDescriptionModule): EquipmentDetailComponent
    fun equipmentComponentBuilder(): EquipmentComponent.Builder
    fun plus(module: MainScreenModule): MainScreenComponent
    fun inject(app: App)
    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }
}