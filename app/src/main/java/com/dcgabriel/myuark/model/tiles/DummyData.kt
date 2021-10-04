package com.dcgabriel.myuark.model.tiles

import com.dcgabriel.myuark.model.Constants
import com.dcgabriel.myuark.model.tiles.TileItem.Action
import com.example.myuark.R

object DummyData {
    fun getCampusTiles(): List<TileItem> {
        var list = ArrayList<TileItem>()
        list.addAll(
            listOf(
                TileItem(
                    "Events",
                    3,
                    R.mipmap.ic_channel,
                    TileData("https://calendar.uark.edu/",),
                    Action.APP_VIEW,
                    TileItem.Type.WIDGET,
                    Constants.ACTIVITY_EVENTS
                ),
                TileItem(
                    "News",
                    3,
                    R.mipmap.ic_channel,
                    TileData("https://news.uark.edu/"),
                    Action.APP_VIEW,
                    TileItem.Type.WIDGET,
                    Constants.ACTIVITY_NEWS
                ),
                TileItem(
                    "Transit",
                    4,
                    R.drawable.ic_baseline_directions_bus_24,
                    TileData("https://uark.passiogo.com/"),
                    Action.WEB_VIEW,
                    TileItem.Type.ICON_TITLE,
                ),
                TileItem(
                    "Parking",
                    2,
                    R.drawable.ic_baseline_local_parking_24,
                    TileData("https://parking.uark.edu/"),
                    Action.WEB_LINK,
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Housing",
                    2,
                    R.drawable.ic_baseline_home_work_24,
                    TileData("https://housing.uark.edu/"),
                    Action.WEB_VIEW,
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Dining",
                    4,
                    R.drawable.ic_baseline_fastfood_24,
                    TileData("https://dineoncampus.com/razorbacks/"),
                    Action.WEB_VIEW,
                    TileItem.Type.ICON_TITLE
                ),

                TileItem(
                    "Pat Walker Health Center",
                    4,
                    R.drawable.ic_baseline_health_and_safety_24,
                    TileData("https://health.uark.edu/"),
                    Action.WEB_VIEW,
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Map",
                    2,
                    R.drawable.ic_baseline_place_24,
                    TileData("https://campusmaps.uark.edu/"),
                    Action.WEB_VIEW,
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Razorbacks",
                    2,
                    R.drawable.razor,
                    TileData("https://arkansasrazorbacks.com/"),
                    Action.WEB_VIEW,
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "UAPD",
                    2,
                    R.drawable.ic_outline_local_police_24,
                    TileData("https://uapd.uark.edu/"),
                    Action.WEB_VIEW,
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Full Circle Food Pantry",
                    2,
                    R.drawable.ic_baseline_food_bank_24,
                    TileData("https://service.uark.edu/services/pantry/index.php"),
                    Action.WEB_VIEW,
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "More Resources",
                    2,
                    R.drawable.ic_baseline_add_circle_outline_24,
                    TileData("https://sponsored-students.uark.edu/current-students/resources/campus-resources.php"),
                    Action.WEB_VIEW,
                    TileItem.Type.ICON_TITLE
                ),
            )
        )
        return list
    }


    fun getStudentTiles(): List<TileItem> {
        var list = ArrayList<TileItem>()
        list.addAll(
            listOf(
                TileItem(
                    "Courses",
                    1,
                    R.drawable.ic_baseline_book_24,
                    TileData("https://classes.uark.edu/"),
                    Action.WEB_VIEW,
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Blackboard",
                    2,
                    R.drawable.bb,
                    TileData("https://learn.uark.edu/"),
                    Action.WEB_VIEW,
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "UAConnect",
                    2,
                    null,
                    TileData("https://uaconnect.uark.edu/"),
                    Action.WEB_VIEW,
                    TileItem.Type.TEXT
                ),
                TileItem(
                    "Library",
                    1,
                    R.drawable.ic_baseline_local_library_24,
                    TileData("https://libraries.uark.edu/"),
                    Action.WEB_LINK,
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Handshake",
                    1,
                    R.drawable.handshake,
                    TileData("https://uark.joinhandshake.com/"),
                    Action.WEB_LINK,
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Career Development Center",
                    2,
                    R.drawable.ic_baseline_work_24,
                    TileData("https://career.uark.edu/cdc/"),
                    Action.WEB_LINK,
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Bookstore",
                    1,
                    R.drawable.ic_baseline_menu_book_24,
                    TileData("https://uark.bncollege.com/"),
                    Action.WEB_LINK,
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Student Success",
                    1,
                    R.drawable.ic_baseline_star_outline_24,
                    TileData("https://success.uark.edu/"),
                    Action.WEB_LINK,
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Degree Programs",
                    1,
                    R.drawable.ic_outline_school_24_outline,
                    TileData("https://www.uark.edu/academics/majors.php"),
                    Action.WEB_LINK,
                    TileItem.Type.ICON_TITLE
                ),
            )
        )


        return list
    }

    fun getExploreTiles(): List<TileItem> {
        var list = ArrayList<TileItem>()
        list.addAll(
            listOf(

                TileItem(
                    "Hogsync",
                    4,
                    R.drawable.hogsync,
                    TileData("https://hogsync.uark.edu/"),
                    Action.WEB_LINK,
                    TileItem.Type.LOGO
                ),
                TileItem(
                    "Directory",
                    2,
                    R.drawable.ic_baseline_contacts_24,
                    TileData("https://directory.uark.edu/"),
                    Action.WEB_VIEW,
                    TileItem.Type.ICON_TITLE
                ),

                TileItem(
                    "University Programs",
                    2,
                    R.drawable.up,
                    TileData("https://up.uark.edu/"),
                    Action.WEB_VIEW,
                    TileItem.Type.LOGO
                ),
                TileItem(
                    "Multicultural Center",
                    2,
                    R.mipmap.ic_mc,
                    TileData("https://multicultural.uark.edu/"),
                    Action.WEB_VIEW,
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "UREC",
                    2,
                    R.mipmap.ic_channel,
                    TileData("https://urec.uark.edu/"),
                    Action.WEB_VIEW,
                    TileItem.Type.LOGO
                ),

                TileItem(
                    "UATV",
                    2,
                    R.mipmap.ic_uatv,
                    TileData("https://uatvonline.net/"),
                    Action.WEB_VIEW,
                    TileItem.Type.LOGO
                ),
                TileItem(
                    "ASG",
                    2,
                    R.mipmap.ic_asg,
                    TileData("https://asg.uark.edu/"),
                    Action.WEB_VIEW,
                    TileItem.Type.LOGO
                ),
                TileItem(
                    "Add More",
                    2,
                    R.drawable.ic_baseline_add_circle_outline_24,
                    TileData("https://hogsync.uark.edu/"),
                    Action.WEB_VIEW,
                    TileItem.Type.ICON_TITLE
                ),

            )
        )

        return list
    }

    fun otherTiles(): List<TileItem> {
        var list = ArrayList<TileItem>()
        list.addAll(
            listOf(
                TileItem(
                    "A-Z Directory",
                    2,
                    R.drawable.ic_baseline_format_list_bulleted_24,
                    TileData("https://www.uark.edu/a-to-z.php"),
                    Action.WEB_VIEW,
                    TileItem.Type.ICON_TITLE
                ),
            )
        )
        return list
    }
}