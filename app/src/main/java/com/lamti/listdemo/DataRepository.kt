package com.lamti.listdemo

private const val IMAGE_PATH = "https://i.guim.co.uk/img/media/07b2967dec8efa3dcc13ce848a39a55adfabc291/0_177_5400_3241/master/5400.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=d3eec42754428ac5abfb871f2968b650"

object DataRepository {

    val data = listOf(
        MyItem(
            title = "First item",
            imagePath = IMAGE_PATH,
            description = "This is the first item"
        ),
        MyItem(
            title = "Second item",
            imagePath = IMAGE_PATH,
            description = "This is the second item"
        ),
        MyItem(
            title = "Third item",
            imagePath = IMAGE_PATH,
            description = "This is the third item"
        ),
        MyItem(
            title = "Fourth item",
            imagePath = IMAGE_PATH,
            description = "This is the fourth item"
        ),
        MyItem(
            title = "Fifth item",
            imagePath = IMAGE_PATH,
            description = "This is the fifth item"
        ),
        MyItem(
            title = "Sixth item",
            imagePath = IMAGE_PATH,
            description = "This is the sixth item"
        ),
        MyItem(
            title = "Seventh item",
            imagePath = IMAGE_PATH,
            description = "This is the seventh item"
        ),
    )

}