package com.yaroshevich.fishingapp.model.equipment

import com.yaroshevich.fishingapp.model.NameValue

class Rod(val model: String, val length: String, val test: Test) : Equipment, NameValueList {


    override fun getImage(): String {
        return "image path"
    }

    override fun getTitle(): String {
        return model
    }

    override fun getFishingCount(): String {
        return "2"
    }

    override fun getCatchCount(): String {
        return "32"
    }

    override fun toNameValue(): List<NameValue> {
        return listOf(
            NameValue("Модель", getTitle()),
            NameValue("тест", "мин - ${test.min}   макс - ${test.max}"),
            NameValue("длина", "$length см")

        )

    }

    override fun fromNameValueList(list: List<NameValue>): Equipment {
        return this
    }


}

class Test(val min: String, val max: String)