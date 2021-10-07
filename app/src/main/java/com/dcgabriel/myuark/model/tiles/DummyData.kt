package com.dcgabriel.myuark.model.tiles

import com.dcgabriel.myuark.model.Constants
import com.dcgabriel.myuark.model.tiles.TileItem.Action
import com.example.myuark.R

object DummyData {
    var allTiles = ArrayList<TileItem>()

    init {
        createTiles()
    }

    fun getTile(key: Int) = allTiles.find{tile -> tile.id == key}
    fun getCampusTiles() = allTiles.filter { tile -> tile.category == TileItem.Category.CAMPUS }
    fun getStudentTiles() = allTiles.filter { tile -> tile.category == TileItem.Category.STUDENT }
    fun getExploreTiles() = allTiles.filter { tile -> tile.category == TileItem.Category.EXPLORE }
    fun getOtherTiles() = allTiles.filter { tile -> tile.category == TileItem.Category.OTHER }


    private fun createTiles() {
        allTiles.add(
            TileItem(
                1,
                "Events",
                TileItem.Category.CAMPUS,
                3,
                R.drawable.calendar_alt,
                TileData("https://calendar.uark.edu/"),
                Action.APP_VIEW,
                TileItem.Type.WIDGET,
                Constants.ACTIVITY_EVENTS
            )
        )
        allTiles.add(
            TileItem(
                2,
                "News",
                TileItem.Category.CAMPUS,
                3,
                R.drawable.newspaper,
                TileData("https://news.uark.edu/"),
                Action.APP_VIEW,
                TileItem.Type.WIDGET,
                Constants.ACTIVITY_NEWS
            )
        )
        allTiles.add(
            TileItem(
                3,
                "Transit",
                TileItem.Category.CAMPUS,
                4,
                R.drawable.bus_alt,
                TileData(
                    "https://uark.passiogo.com/",
                    arrayListOf("https://twitter.com/uatandp", "https://www.instagram.com/uatandp/")
                ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE,
            )
        )
        allTiles.add(
            TileItem(
                4,
                "Parking",
                TileItem.Category.CAMPUS,
                2,
                R.drawable.cars,
                TileData(
                    "https://parking.uark.edu/",
                    arrayListOf(
                        "https://www.facebook.com/UATandP/",
                        "https://twitter.com/UATandP",
                        "https://www.instagram.com/UATandP/"
                    )
                ),
                Action.WEB_LINK,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                5,
                "Housing",
                TileItem.Category.CAMPUS,
                2,
                R.drawable.house_user,
                TileData("https://housing.uark.edu/"),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                6,
                "Dining",
                TileItem.Category.CAMPUS,
                4,
                R.drawable.burger_soda,
                TileData("https://dineoncampus.com/razorbacks/"),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )

        allTiles.add(
            TileItem(
                7,
                "Pat Walker Health Center",
                TileItem.Category.CAMPUS,
                4,
                R.drawable.heartbeat,
                TileData("https://health.uark.edu/"),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                8,
                "Map",
                TileItem.Category.CAMPUS,
                2,
                R.drawable.map_marked_alt,
                TileData("https://campusmaps.uark.edu/"),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                9,
                "Razorbacks",
                TileItem.Category.CAMPUS,
                2,
                R.drawable.razor,
                TileData("https://arkansasrazorbacks.com/"),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                10,
                "UAPD",
                TileItem.Category.CAMPUS,
                2,
                R.drawable.shield_alt,
                TileData("https://uapd.uark.edu/"),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                11,
                "Full Circle Food Pantry",
                TileItem.Category.CAMPUS,
                2,
                R.drawable.hands_heart,
                TileData("https://service.uark.edu/services/pantry/index.php"),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                12,
                "More Resources",
                TileItem.Category.CAMPUS,
                2,
                R.drawable.plus_circle,
                TileData("https://sponsored-students.uark.edu/current-students/resources/campus-resources.php"),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )





        allTiles.add(
            TileItem(
                13,
                "Courses",
                TileItem.Category.STUDENT,
                1,
                R.drawable.chalkboard_teacher,
                TileData("https://classes.uark.edu/"),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                14,
                "Blackboard",
                TileItem.Category.STUDENT,
                2,
                R.drawable.bb,
                TileData("https://learn.uark.edu/"),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                15,
                "UAConnect",
                TileItem.Category.STUDENT,
                2,
                null,
                TileData("https://uaconnect.uark.edu/"),
                Action.WEB_VIEW,
                TileItem.Type.TEXT
            )
        )
        allTiles.add(
            TileItem(
                16,
                "Library",
                TileItem.Category.STUDENT,
                1,
                R.drawable.book_open,
                TileData("https://libraries.uark.edu/"),
                Action.WEB_LINK,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                17,
                "Handshake",
                TileItem.Category.STUDENT,
                1,
                R.drawable.handshake,
                TileData("https://uark.joinhandshake.com/"),
                Action.WEB_LINK,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                18,
                "Career Development Center",
                TileItem.Category.STUDENT,
                2,
                R.drawable.briefcase,
                TileData("https://career.uark.edu/cdc/"),
                Action.WEB_LINK,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                19,
                "Bookstore",
                TileItem.Category.STUDENT,
                1,
                R.drawable.books,
                TileData("https://uark.bncollege.com/"),
                Action.WEB_LINK,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                20,
                "Student Success",
                TileItem.Category.STUDENT,
                1,
                R.drawable.user_graduate,
                TileData("https://success.uark.edu/"),
                Action.WEB_LINK,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                21,
                "Degree Programs",
                TileItem.Category.STUDENT,
                1,
                R.drawable.diploma,
                TileData("https://www.uark.edu/academics/majors.php"),
                Action.WEB_LINK,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                21,
                "Hogsync",
                TileItem.Category.EXPLORE,
                4,
                R.drawable.hogsync,
                TileData("https://hogsync.uark.edu/"),
                Action.WEB_LINK,
                TileItem.Type.LOGO
            )
        )
        allTiles.add(
            TileItem(
                22,
                "Directory",
                TileItem.Category.EXPLORE,
                2,
                R.drawable.id_card,
                TileData("https://directory.uark.edu/"),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                23,
                "University Programs",
                TileItem.Category.EXPLORE,
                2,
                R.drawable.up,
                TileData("https://up.uark.edu/"),
                Action.WEB_VIEW,
                TileItem.Type.LOGO
            )
        )
        allTiles.add(
            TileItem(
                24,
                "Multicultural Center",
                TileItem.Category.EXPLORE,
                2,
                R.mipmap.ic_mc,
                TileData("https://multicultural.uark.edu/"),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                25,
                "UREC",
                TileItem.Category.EXPLORE,
                2,
                R.mipmap.ic_channel,
                TileData("https://urec.uark.edu/"),
                Action.WEB_VIEW,
                TileItem.Type.LOGO
            )
        )
        allTiles.add(
            TileItem(
                26,
                "UATV",
                TileItem.Category.EXPLORE,
                2,
                R.mipmap.ic_uatv,
                TileData("https://uatvonline.net/"),
                Action.WEB_VIEW,
                TileItem.Type.LOGO
            )
        )
        allTiles.add(
            TileItem(
                27,
                "ASG",
                TileItem.Category.EXPLORE,
                2,
                R.mipmap.ic_asg,
                TileData("https://asg.uark.edu/"),
                Action.WEB_VIEW,
                TileItem.Type.LOGO
            )
        )
        allTiles.add(
            TileItem(
                28,
                "Add More",
                TileItem.Category.EXPLORE,
                2,
                R.drawable.plus_circle,
                TileData("https://hogsync.uark.edu/"),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )

        allTiles.add(
            TileItem(
                29,
                "A-Z Directory",
                TileItem.Category.OTHER,
                2,
                R.drawable.plus_circle,
                TileData("https://www.uark.edu/a-to-z.php"),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )

    }


}