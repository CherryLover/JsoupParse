package me.monster.jsoupparse

import org.jsoup.Jsoup

/**
 * @description
 * @author: Created jiangjiwei in 2021/12/3 10:51 上午
 */
object Parse {
  fun parse(url: String) {
    val get = Jsoup.connect(url).get()
    val elementsByClass = get.body().getElementsByClass("margin-wrapper")
    println("all margin wrapper size is ${elementsByClass.size} ")
    for (elementsByClass in elementsByClass) {
      val aLinkEles = elementsByClass.getElementsByAttribute("href")
      for (element in aLinkEles) {
        val link = element.attr("href")
        val text = element.attr("data-title")
        println("data title $text link $link")
      }
    }
  }
}