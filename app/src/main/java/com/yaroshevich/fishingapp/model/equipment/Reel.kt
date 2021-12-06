package com.yaroshevich.fishingapp.model.equipment

import com.yaroshevich.fishingapp.model.NameValue

class Reel(val brand: String) : Equipment, NameValueList {


    override fun getImage(): String {
        return "image path"
    }

    override fun getTitle(): String {
        return brand
    }

    override fun getFishingCount(): String {
        return "2"
    }

    override fun getCatchCount(): String {
        return "32"
    }

    override fun toNameValue(): List<NameValue> {
        TODO("Not yet implemented")
    }

    override fun fromNameValueList(list: List<NameValue>): Equipment {
        return this
    }
}