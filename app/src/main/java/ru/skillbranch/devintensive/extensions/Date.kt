package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

const val SECOND = 1000L
const val MINUTE = SECOND * 60
const val HOUR = MINUTE * 60
const val DAY = HOUR * 24

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

public fun Date.humanizeDiff(date: Date = Date()): String {
    val difference = (date.time - this.time)
    return when {
        difference == 1 * SECOND -> "${difference/1000} секунду назад"
        difference in 2..4 * SECOND -> "${difference/1000} секунды назад"
        difference in 5..10 * SECOND -> "${difference/1000} секунд назад"
        difference == -1 * SECOND -> "через ${difference/1000} секунду"
        difference in -2..4 * SECOND -> "через ${difference/1000} секунды"
        difference in -5..10 * SECOND -> "через ${difference/1000} секунд"
        difference == 1 * MINUTE -> "${difference/1000/60} минуту назад"
        difference in 2..4 * MINUTE -> "${difference/1000/60} минуты назад"
        difference in 5..10 * MINUTE -> "${difference/1000/60} минут назад"
        difference == -1 * MINUTE -> "через ${difference/1000/60} минуту"
        difference in -2..4 * MINUTE -> "через ${difference/1000/60} минуты"
        difference in -5..10 * MINUTE -> "через ${difference/1000/60} минут"
        difference == 1 * HOUR -> "${difference/1000/60/60} час назад"
        difference in 2..4 * HOUR -> "${difference/1000/60/60} несколько часов назад"
        difference in 5..24 * HOUR -> "${difference/1000/60/60} несколько часов назад"
        difference < DAY -> "около суток назад"
        difference < 10 * DAY -> "несколько дней назад"
        difference < 28 * DAY -> "около месяца назад"
        difference < 12 * 90 * DAY -> "несколько месяцев назад"
        else -> "больше года назад"
    }
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}