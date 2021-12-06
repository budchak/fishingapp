package com.yaroshevich.fishingapp.model.equipment

interface Equipment {

    fun getImage(): String

    fun getTitle(): String

    fun getFishingCount(): String

    fun getCatchCount(): String
}