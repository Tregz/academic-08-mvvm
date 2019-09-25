package com.tregz.mvvm.core.date

import java.util.*

object DateUtil {

    fun addMonth(then: Date, i: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = then
        calendar.add(Calendar.MONTH, i)
        return calendar.time
    }

}