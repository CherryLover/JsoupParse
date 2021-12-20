package me.monster.jsoupparse

data class BirdYearWinner(
    val title: String,
    val url: String
)

data class UnsplashDay(
    var img: String = "",
    var profileUrl: String = "",
    var userName: String = "",
    var hintText: String = ""
) {
    private var id: String = ""
    var detailUrl: String = ""
        set(value) {
            field = value
            id = value.substring(value.lastIndexOf("/") + 1)
        }

    override fun toString(): String {
        return "UnsplashDay(id='$id', detailUrl='$detailUrl', userName='$userName', profileUrl='$profileUrl', img=$img, hintText='$hintText')"
    }


}