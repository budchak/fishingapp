package com.yaroshevich.fishingapp

import android.app.Application
import androidx.fragment.app.Fragment
import com.yaroshevich.fishingapp.di.components.AppComponent
import com.yaroshevich.fishingapp.di.components.DaggerAppComponent
import com.yaroshevich.fishingapp.di.components.EquipmentComponent
import com.yaroshevich.fishingapp.di.modules.EquipmentModule
import com.yaroshevich.fishingapp.di.modules.RodModule

class App : Application() {


    lateinit var appComponent: AppComponent


    fun getCategoryComponent(fragment: Fragment): EquipmentComponent {
        return appComponent.equipmentComponentBuilder()
            .equipmentCategoryModule(EquipmentModule(fragment))
            .rodModule(RodModule()).build()
    }


    override fun onCreate() {
        super.onCreate()

        setInstance(this)

        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()

        appComponent.inject(this)

    }


    companion object {

        private lateinit var app: App

        private fun setInstance(app: App) {

            this.app = app

        }

        fun getInstance() = app

    }
}