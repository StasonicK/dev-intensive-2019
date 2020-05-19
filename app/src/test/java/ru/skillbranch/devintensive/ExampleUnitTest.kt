package ru.skillbranch.devintensive

import org.junit.*
import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.TimeUnits.MINUTE
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.extensions.truncate
import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.Chat
import ru.skillbranch.devintensive.models.User
import java.util.Date

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
//        val user = User("1")
        val user2 = User("2", "John", "Wick")
//        val user3 = User("3", "John", "Silverhand", null, lastVisit = Date(), isOnline = true)

//        user.printMe()
        user2.printMe()
//        user3.printMe()

//        println("$user $user2 $user3")
//        println("$user")
    }

    @Test
    fun test_factory() {
//        val user = User.makeUser("John Cean")
//        val user2 = User.makeUser("John Wick")
//        val user3 = User.makeUser("John Silverhand")

        val user4 = User.makeUser("John Wick")
        val user5 = user4.copy(id = "2", lastName = "Cena", lastVisit = Date())
        print("$user4 \n$user5")
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Wick")

        fun getUserInfo() = user

        val (id, firstName, lastName) = getUserInfo()
        println("$id, $firstName, $lastName")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
//        val user2 = user.copy()
        val user2 = user.copy(lastVisit = Date())
        val user3 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        val user4 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))

        println(
            """
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
            ${user4.lastVisit?.format()}
        """.trimIndent()
        )

//        if (user === user2) {
//            println("equals address \n${System.identityHashCode(user)}\n" +
//                    "${System.identityHashCode(user2)}")
//        } else {
//            println("not equals address \n${System.identityHashCode(user)} \n${System.identityHashCode(user2)}")
//        }
    }

    @Test
    fun test_data_mapping() {
        val user = User.makeUser("John Wick")
        val newUser = user.copy(lastVisit = Date().add(-7, MINUTE))
        println(newUser)

        val userView = newUser.toUserView()
        userView.printMe()
    }

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("John Wick")
        val txtMessage =
            BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type = "text", date = Date())
        val imgMessage =
            BaseMessage.makeMessage(user, Chat("0"), payload = "any image url", type = "image", date = Date())

//        when (imgMessage) {
//            is TextMessage -> println("this is text message")
//            is ImageMessage -> println("this is image message")
//        }

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }

    @Test
    fun test_truncate(){
        println("Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate())
        println("Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15))
        println("A     ".truncate(3))
    }
}
