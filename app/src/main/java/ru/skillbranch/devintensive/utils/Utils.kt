package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: MutableList<String>? = fullName?.split(" ")?.toMutableList()

        val first = parts?.getOrNull(0)?.trim()
        val firstName = if (first?.contains("")!!) null else first
        val last = parts.getOrNull(1)?.trim()
        val lastName = if (last?.contains("")!!) null else last

        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val names = payload.split(" ")
        var finalName: StringBuilder = StringBuilder()
        for (name in names) {
            var translitName: StringBuilder = StringBuilder("")
            for (letter in name.toCharArray()) {
                val small_letter = letter.toLowerCase()
                when(small_letter) {
                    'а' -> translitName.append('a')
                    'б' -> translitName.append('b')
                    'в' -> translitName.append('v')
                    'г' -> translitName.append('g')
                    'д' -> translitName.append('d')
                    'е' -> translitName.append('e')
                    'ё' -> translitName.append('e')
                    'ж' -> translitName.append('z').append('h')
                    'з' -> translitName.append('z')
                    'и' -> translitName.append('i')
                    'й' -> translitName.append('i')
                    'к' -> translitName.append('k')
                    'л' -> translitName.append('l')
                    'м' -> translitName.append('m')
                    'н' -> translitName.append('n')
                    'о' -> translitName.append('o')
                    'п' -> translitName.append('p')
                    'р' -> translitName.append('r')
                    'с' -> translitName.append('s')
                    'т' -> translitName.append('t')
                    'у' -> translitName.append('u')
                    'ф' -> translitName.append('f')
                    'х' -> translitName.append('h')
                    'ц' -> translitName.append('c')
                    'ч' -> translitName.append('c').append('h')
                    'ш' -> translitName.append('s').append('h')
                    'ш' -> translitName.append('s').append('h').append("'")
                    'ъ' -> translitName.append("")
                    'ы' -> translitName.append('i')
                    'ь' -> translitName.append("")
                    'э' -> translitName.append('e')
                    'ю' -> translitName.append('y').append('u')
                    'я' -> translitName.append('y').append('a')
                    else -> translitName.append(small_letter)
                }
            }
            translitName[0] = translitName[0].toUpperCase()
            if (finalName.isEmpty()) {
                finalName.append(translitName)
            } else {
                finalName.append(divider).append(translitName)
            }
        }
        return finalName.toString()
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        return StringBuilder("${firstName?.getOrNull(0)?.toUpperCase()}").append(". ")
            .append("${lastName?.getOrNull(0)?.toUpperCase()}").append(".").toString()
    }
}