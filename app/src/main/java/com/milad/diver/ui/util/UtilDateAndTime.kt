package com.milad.diver.ui.util

import java.text.SimpleDateFormat
import java.util.*

private const val UTC_PATTERN="yyyyMMddHHmmss"
private const val EXCEPTION_DATE_FORMAT="00-00-0000 00:00"
private const val UTC="UTC"
private const val YEAR_PATTERN="yyyy"
private const val MONTH_PATTERN="MM"
private const val DAY_PATTERN="dd"
private const val TIME_PATTERN="HH:ss"
class UtilDateAndTime {

    fun getDataFromUTC(ourDate: String): Triple<String, String, String>? {

        var ourYear: String?
        var ourMonth: String?
        var ourDay: String?
        try {
            val formatter =
                SimpleDateFormat(UTC_PATTERN)
            formatter.timeZone = TimeZone.getTimeZone(UTC)
            val value = formatter.parse(ourDate)

            val year =
                SimpleDateFormat(YEAR_PATTERN)
            year.timeZone = TimeZone.getDefault()
            ourYear = year.format(value)

            val month =
                SimpleDateFormat(MONTH_PATTERN)
            month.timeZone = TimeZone.getDefault()
            ourMonth = month.format(value)

            val day =
                SimpleDateFormat(DAY_PATTERN)
            day.timeZone = TimeZone.getDefault()
            ourDay = day.format(value)

        } catch (e: Exception) {
            ourYear = EXCEPTION_DATE_FORMAT
            ourMonth= EXCEPTION_DATE_FORMAT
            ourDay= EXCEPTION_DATE_FORMAT
        }
        return Triple(ourYear.toString(), ourMonth.toString(), ourDay.toString())
    }

    fun getTimeFromUTC(ourDate: String): String {
        val ourTime: String?

        val formatter = SimpleDateFormat(UTC_PATTERN)
        formatter.timeZone = TimeZone.getTimeZone(UTC)
        val value = formatter.parse(ourDate)

        val time = SimpleDateFormat(TIME_PATTERN)
        time.timeZone = TimeZone.getDefault()
        ourTime = time.format(value)
        return ourTime

    }

    fun gregorianToJalali(gy: Int, gm: Int, gd: Int): IntArray {
        val g_d_m: IntArray = intArrayOf(0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334)
        val gy2: Int = if (gm > 2) (gy + 1) else gy
        var days: Int =
            355666 + (365 * gy) + ((gy2 + 3) / 4) - ((gy2 + 99) / 100) + ((gy2 + 399) / 400) + gd + g_d_m[gm - 1]
        var jy: Int = -1595 + (33 * (days / 12053))
        days %= 12053
        jy += 4 * (days / 1461)
        days %= 1461
        if (days > 365) {
            jy += ((days - 1) / 365)
            days = (days - 1) % 365
        }
        val jm: Int
        val jd: Int
        if (days < 186) {
            jm = 1 + (days / 31)
            jd = 1 + (days % 31)
        } else {
            jm = 7 + ((days - 186) / 30)
            jd = 1 + ((days - 186) % 30)
        }
        return intArrayOf(jy, jm, jd)
    }

    fun getMonthName(month: Int): String {

        return when (month) {
            MONTHES.FARVARDIN.ordinal -> {
                "قروردین"
            }
            MONTHES.ORDIBEHESHT.ordinal -> {
                "اردیبهشت"
            }
            MONTHES.KHORDAD.ordinal -> {
                "حرداد"
            }
            MONTHES.TIR.ordinal -> {
                "تیر"
            }
            MONTHES.MORDAD.ordinal -> {
                "مرداد"
            }
            MONTHES.SHAHRIVAR.ordinal -> {
                "شهریور"
            }
            MONTHES.MEHR.ordinal -> {
                "مهر"
            }
            MONTHES.ABAN.ordinal -> {
                "آبان"
            }
            MONTHES.AZAR.ordinal -> {
                "آدر"
            }
            MONTHES.DEY.ordinal -> {
                "دی"
            }
            MONTHES.BAHMAN.ordinal -> {
                "بهمن"
            }
            MONTHES.ESFAND.ordinal -> {
                "اسقند"
            }
            else -> {
                "نامشخص"
            }
        }
    }

    enum class MONTHES {
        FARVARDIN,
        ORDIBEHESHT,
        KHORDAD,
        TIR,
        MORDAD,
        SHAHRIVAR,
        MEHR,
        ABAN,
        AZAR,
        DEY,
        BAHMAN,
        ESFAND
    }
}