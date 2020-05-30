package ru.skillbranch.devintensive.models

class Bander(var status: Status = Status.NORMAL, var question: Questiion = Questiion.NAME) {

    fun askQuestion(): String = when (question) {
        Questiion.NAME -> Questiion.NAME.question
        Questiion.PROFESSION -> Questiion.PROFESSION.question
        Questiion.MATERIAL -> Questiion.MATERIAL.question
        Questiion.BDAY -> Questiion.BDAY.question
        Questiion.SERIAL -> Questiion.SERIAL.question
        Questiion.IDLE -> Questiion.IDLE.question
    }

    fun listenAnswer(answer: String): Pair<String, Triple<Int, Int, Int>> {
        return if (question.answers.contains(answer)) {
            "Отлично - это правильный ответ!" to status.color
        } else {
            "Отлично - это правильный ответ!" to status.color
        }
    }

    enum class Status(val color: Triple<Int, Int, Int>) {
        NORMAL(Triple(255, 255, 255)),
        WARNING(Triple(255, 120, 0)),
        DANGER(Triple(255, 60, 60)),
        CRITICAL(Triple(255, 255, 0))
    }

    enum class Questiion(val question: String, val answers: List<String>) {
        NAME("Как меня зовут?", listOf("бендер", "bender")),
        PROFESSION("Назови мою профессию?", listOf("сгибальщик", "bender")),
        MATERIAL("Из чего я сделан?", listOf("металл", "дерево", "metal", "iron", "wood")),
        BDAY("Когда меня создали?", listOf("2993")),
        SERIAL("Какой мой серийный номер?", listOf("2716057")),
        IDLE("На этом всё, вопросов больше нет", listOf())
    }
}