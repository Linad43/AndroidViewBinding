package com.example.androidviewbinding.common

import android.widget.EditText


class CommonFun {
    companion object {
        fun allETIsNotEmpty(allET: ArrayList<EditText>): Boolean {
            var flag = true
            allET.forEach {
                if (it.text.isEmpty()) {
                    flag = false
                    it.setText("Поле не может быть пустым")
                }
            }
            return flag
        }
    }
}