package com.yaroshevich.fishingapp.mainScreen.model

class AppFunctionTest(val title: String, val imagePath: String) : AppFunction {

    override fun getIconPath(): String {
        return imagePath
    }

    override fun getTitleString(): String {
        return title
    }
}