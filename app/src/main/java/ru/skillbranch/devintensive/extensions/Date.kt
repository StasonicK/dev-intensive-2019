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
        difference in (0 * SECOND)..(1 * SECOND) -> "только что"
        difference in (1 * SECOND)..(45 * SECOND) -> "несколько секунд назад"
        difference in -(1 * SECOND) downTo -(45 * SECOND) -> "через несколько секунд"
        difference in (45 * SECOND)..(75 * SECOND) -> "минуту назад"
        difference in -(45 * SECOND) downTo -(75 * SECOND) -> "через минуту"
        difference in (75 * SECOND)..(45 * MINUTE) -> "${difference / MINUTE} минут назад"
        difference in -(75 * SECOND) downTo -(45 * MINUTE) -> "через ${-difference / MINUTE} минут"
        difference in (45 * MINUTE)..(75 * MINUTE) -> "час назад"
        difference in -(45 * MINUTE) downTo -(75 * MINUTE) -> "через час"
        difference in (75 * MINUTE)..(22 * HOUR) -> "${difference / HOUR} часов назад"
        difference in -(75 * MINUTE) downTo -(22 * HOUR) -> "через ${-difference / HOUR} часов"
        difference in (22 * HOUR)..(26 * HOUR) -> "день назад"
        difference in -(22 * HOUR) downTo -(26 * HOUR) -> "через день"
        difference in (26 * HOUR)..(360 * DAY) -> "${difference / DAY} дней назад"
        difference in -(26 * HOUR) downTo -(360 * DAY) -> "через ${-difference / DAY} дней"
        difference > -360 * DAY -> "через года"
        else -> "более года назад"
    }
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}