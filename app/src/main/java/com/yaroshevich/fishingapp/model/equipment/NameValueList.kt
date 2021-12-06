package com.yaroshevich.fishingapp.model.equipment

import com.yaroshevich.fishingapp.model.NameValue

interface NameValueList {


    fun toNameValue(): List<NameValue>

    fun fromNameValueList(list: List<NameValue>): Equipment
}