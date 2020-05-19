package ru.skillbranch.dev_intensive.extensions

fun String.truncate(length: Int = 16): String {
    val text = this
    var result: StringBuilder = StringBuilder()
    val filler = "..."

    if (text[length] == ' ') {
        result.append(text.substring(0, length)).toString().trim()
    }else{
        result.append(text.substring(0, length)).append(filler).toString().trim()
    }
    return result.toString()
}

fun String.stripHtml(): String {
    var text = this
    TODO("finish String.truncate()")

    return text
}