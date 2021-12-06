package com.yaroshevich.fishingapp.mainScreen.ui.viewmodel

import androidx.lifecycle.LiveData
import com.yaroshevich.fishingapp.mainScreen.model.AppFunction

interface AppFunctionViewModel {

    fun getAppFunction(): LiveData<List<AppFunction>>
}