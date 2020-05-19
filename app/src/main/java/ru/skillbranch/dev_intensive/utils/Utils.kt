package ru.skillbranch.dev_intensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val names: List<String> = payload.split(divider)
        var finalName: StringBuilder = StringBuilder()
        for (name in names) {
            var translitName: StringBuilder = StringBuilder("")
            for (letter in name.toCharArray())
                when (letter.toLowerCase()) {
//                    'a' -> translitName.append('а')
//                    'b' -> translitName.append('б')
//                    'c' -> translitName.append('с')
//                    'd' -> translitName.append('д')
//                    'e' -> translitName.append('е')
//                    'f' -> translitName.append('ф')
//                    'g' -> translitName.append('г')
//                    'h' -> translitName.append('х')
//                    'i' -> translitName.append('и')
//                    'j' -> translitName.append('д').append('ж')
//                    'k' -> translitName.append('к')
//                    'l' -> translitName.append('л')
//                    'm' -> translitName.append('м')
//                    'n' -> translitName.append('н')
//                    'o' -> translitName.append('о')
//                    'p' -> translitName.append('п')
//                    'q' -> translitName.append('к')
//                    'r' -> translitName.append('р')
//                    's' -> translitName.append('с')
//                    't' -> translitName.append('т')
//                    'u' -> translitName.append('у')
//                    'v' -> translitName.append('в')
//                    'w' -> translitName.append('в')
//                    'x' -> translitName.append('к').append('с')
//                    'y' -> translitName.append('у').append('а').append('й')
//                    'z' -> translitName.append('з')
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
                    'х' -> translitName.append('k').append('h')
                    'ц' -> translitName.append('c')
                    'ч' -> translitName.append('c').append('h')
                    'ш' -> translitName.append('s').append('h')
                    'щ' -> translitName.append('s').append('c')
                    'ъ' -> translitName.append("i").append("e")
                    'ы' -> translitName.append('y')
                    'ь' -> translitName.append("")
                    'э' -> translitName.append('e')
                    'ю' -> translitName.append('i').append('u')
                    'я' -> translitName.append('i').append('a')
                }
            translitName[0] = translitName[0].toUpperCase()
            if (finalName.isEmpty()) {
                finalName.append(translitName)
            } else {
                finalName.append("_").append(translitName)
            }
        }
        return finalName.toString()
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        return StringBuilder("${firstName?.getOrNull(0)?.toUpperCase()}").append(". ")
            .append("${lastName?.getOrNull(0)?.toUpperCase()}").append(".").toString()
    }
}