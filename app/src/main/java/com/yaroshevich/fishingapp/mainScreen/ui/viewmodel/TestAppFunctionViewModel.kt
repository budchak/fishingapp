package com.yaroshevich.fishingapp.mainScreen.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yaroshevich.fishingapp.mainScreen.model.AppFunction
import com.yaroshevich.fishingapp.mainScreen.model.AppFunctionTest
import javax.inject.Inject

class TestAppFunctionViewModel @Inject constructor() : AppFunctionViewModel {

    private val appFunction = MutableLiveData<List<AppFunction>>()

    init {
        val list = mutableListOf<AppFunction>()
        list.add(AppFunctionTest("Снаряжение", "rod_test"))
        list.add(AppFunctionTest("Рыбалки", "rod_test"))
        list.add(AppFunctionTest("Погода", "rod_test"))



        appFunction.value = list
    }

    override fun getAppFunction(): LiveData<List<AppFunction>> {

        return appFunction

    }
}