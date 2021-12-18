package me.monster.jsoupparse

import com.google.gson.Gson

fun Any.toJson(): String {
    return Gson().toJson(this)
}
