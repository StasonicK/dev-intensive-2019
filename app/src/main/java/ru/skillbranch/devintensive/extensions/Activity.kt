package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.view.inputmethod.InputMethodManager

fun Activity.hideKeyboard() {
    val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    val view = this.currentFocus
    imm.hideSoftInputFromWindow(view?.windowToken, 0)
}


//TODO finish it!
fun Activity.isKeyboardOpen() {
}