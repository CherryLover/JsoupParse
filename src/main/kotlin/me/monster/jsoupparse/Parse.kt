package me.monster.jsoupparse

import org.jsoup.Jsoup

/**
 * @description
 * @author: Created jiangjiwei in 2021/12/3 10:51 上午
 */
object Parse {
  /**
   * 鸟类年度作品展示
   */
  fun parseBird(url: String): MutableList<BirdYearWinner> {
    val get = Jsoup.connect(url).get()
    val elementsByClass = get.body().getElementsByClass("margin-wrapper")
    println("all margin wrapper size is ${elementsByClass.size} ")
    val resultList = mutableListOf<BirdYearWinner>()
    for (elementsByClass in elementsByClass) {
      val aLinkEles = elementsByClass.getElementsByAttribute("href")
      for (element in aLinkEles) {
        val link = element.attr("href")
        val text = element.attr("data-title")
        resultList.add(BirdYearWinner(text, link))
      }
    }
    return resultList
  }
}