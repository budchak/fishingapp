package com.yaroshevich.fishingapp.utils.dateFormat

import java.text.SimpleDateFormat
import java.util.*

class DateFormatImpl(val formatString: String) : DateFormat {

    val format = SimpleDateFormat(formatString, Locale.getDefault())

    override fun format(date: Date): String {
        return format(date)
    }
}