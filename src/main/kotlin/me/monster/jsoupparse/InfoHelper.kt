package me.monster.jsoupparse

/**
 * @description
 * @author: Created jiangjiwei in 2021/12/3 10:48 上午
 */
object InfoHelper {
  fun printInfos() {
    System.getenv().forEach { t, u ->
      println("key $t value $u")
    }
  }
}