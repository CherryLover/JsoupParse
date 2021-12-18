package me.monster.jsoupparse

class KtEntrance {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(System.getProperty("user.dir"))

            println(Parse.parseBird("https://zh.birdpoty.com/2021-winners").toJson())
        }
    }
}