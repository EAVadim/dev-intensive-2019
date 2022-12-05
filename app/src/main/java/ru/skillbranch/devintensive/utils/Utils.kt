package ru.skillbranch.devintensive.utils

object Utils {

    fun parsFullName(fullName: String?): Pair<String?, String?> {
        return when (fullName) {
            null, "", " " -> {
                null to null
            }
            else -> {
                val parts: List<String> = fullName.trim().split(" ")
                val firstName = parts.getOrNull(0)
                val lastName = parts.getOrNull(1)
                when (lastName) {
                    null -> {
                        return firstName to null
                    }
                    else -> return firstName to lastName
                }
            }
        }
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        return when {
            firstName == null && lastName == null -> {
                null
            }
            firstName == null -> {
                return null
            }
            lastName == null -> {
                val firstLetterOfFirstName = firstName[0]
                return "${firstLetterOfFirstName.uppercaseChar()}"
            }
            else -> {
                val firstLetterOfFirstName = firstName[0]
                val firstLetterOfLastName = lastName[0]
                return "${firstLetterOfFirstName.uppercaseChar()}${firstLetterOfLastName.uppercaseChar()}"
            }
        }
    }

    fun transliteration(payload: String, divider: String = " "): String {
        return payload.replace(Regex("[абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ ]")) {
            when (it.value) {
                "А" -> "A" "а" -> "a"
                "Б" -> "B" "б" -> "b"
                "В" -> "V" "в" -> "v"
                "Г" -> "G" "г" -> "g"
                "Д" -> "D" "д" -> "d"
                "Е" -> "E" "е" -> "e"
                "Ё" -> "E" "ё" -> "e"
                "Ж" -> "Zh" "ж" -> "zh"
                "З" -> "Z" "з" -> "z"
                "И" -> "I" "и" -> "i"
                "Й" -> "I" "й" -> "i"
                "К" -> "K" "к" -> "k"
                "Л" -> "L" "л" -> "l"
                "М" -> "M" "м" -> "m"
                "Н" -> "N" "н" -> "n"
                "О" -> "O" "о" -> "o"
                "П" -> "P" "п" -> "p"
                "Р" -> "R" "р" -> "r"
                "С" -> "S" "с" -> "s"
                "Т" -> "T" "т" -> "t"
                "У" -> "U" "у" -> "u"
                "Ф" -> "F" "ф" -> "f"
                "Х" -> "H" "х" -> "h"
                "Ц" -> "C" "ц" -> "c"
                "Ч" -> "Ch" "ч" -> "ch"
                "Ш" -> "Sh" "ш" -> "sh"
                "Щ" -> "Sh'" "щ" -> "sh'"
                "Ъ" -> "" "ъ" -> ""
                "Ы" -> "I" "ы" -> "i"
                "Ь" -> "" "ь" -> ""
                "Э" -> "E" "э" -> "e"
                "Ю" -> "Yu" "ю" -> "yu"
                "Я" -> "Ya" "я" -> "ya"
                " " -> divider
                else -> it.value
            }
        }
    }
}