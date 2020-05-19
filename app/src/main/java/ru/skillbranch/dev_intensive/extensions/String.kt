package ru.skillbranch.dev_intensive.extensions

fun String.truncate(length: Int = 16): String {
    var text = this
    var result: StringBuilder = StringBuilder()
    val filler = "..."
    if (text[length - 1] == ' ' && text[length] == ' ') return result.append(text.substring(0, length)).toString()
        .trim()

    if (text[length - 1] != ' ') {
        return result.append(text.substring(0, length)).append(filler).toString()
    } else {
        text = result.append(text.substring(0, length)).toString().trim()
        for (s in text.length..0) {
            if (text[s] == ' ') text = text.substring(0, s)
        }
    }
    return text + filler
}

fun String.stripHtml(): String {
    var text = this
    TODO("finish String.truncate()")

    return text
}