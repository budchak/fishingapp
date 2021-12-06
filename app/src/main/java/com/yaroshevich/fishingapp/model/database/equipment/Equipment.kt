package com.yaroshevich.fishingapp.model.database.equipment

interface Equipment {

    fun getName(): String

    fun getIconList(): List<String>

    fun getDescription(): String

}