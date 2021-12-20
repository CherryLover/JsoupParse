package me.monster.jsoupparse

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import java.io.File
import java.net.URL

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

  fun parseUnSplashDayImg() {
    val url = "https://unsplash.dogedoge.com/"
    val get = Jsoup.connect(url).get().body()
    File((System.getProperty("user.dir") + "/test.html")).writeText(get.toString())
//    val get = Jsoup.parse(File(System.getProperty("user.dir") + "/test.html"), Charsets.UTF_8.name()).body()

    val unsplashDay = UnsplashDay()
    processUnsplashImage(get, unsplashDay)
    processUnsplashText(get, unsplashDay)
    println("Unsplash Info ${unsplashDay.toJson()}")
  }

  private fun processUnsplashImage(get: Element, unsplashDay: UnsplashDay) {
    val imgTags = get.getElementsByTag("img")
    if (imgTags.size < 1) {
      return
    }
    val img = imgTags[0]
    val webAddress = img.attr("src")
    val url = URL(webAddress)
    unsplashDay.img = webAddress
  }

  private fun processUnsplashText(get: Element, unsplashDay: UnsplashDay) {
    val photoByEleParent = get.getElementsByClass("Z9ulD")
    if (photoByEleParent.size < 1) {
      return
    }
    val photoByEle = photoByEleParent[0].getElementsByAttributeValueStarting("title", "View the photo by")
    if (photoByEle.size < 1) {
      return
    }
    val photoElement = photoByEle[0]
    unsplashDay.detailUrl = photoElement.attr("href").toString()
    unsplashDay.hintText = photoElement.text()

    val userByEle = photoByEleParent[0].getElementsByClass("yayNa")
    if (userByEle.size < 1) {
      return
    }
    var profileEle = userByEle[0]
    profileEle = profileEle.getElementsByAttribute("href")[0]
    unsplashDay.profileUrl = profileEle.attr("href")
    unsplashDay.userName = profileEle.text()
  }

  private fun printClassInfo(tag: String, elements: Elements) {
    repeat(elements.size) {
      val ele = elements[it]
      println("$tag -> element class ${ele.classNames()} text ${ele.text()}")
    }
  }
}