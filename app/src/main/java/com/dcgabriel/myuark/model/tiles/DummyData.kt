package com.dcgabriel.myuark.model.tiles

import com.dcgabriel.myuark.model.Constants
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
                    TileItem.Action.WEB_VIEW,
                    "https://calendars.uark.edu/",
                    TileItem.Type.WIDGET
                ),
                TileItem(
                    "News",
                    3,
                    R.mipmap.ic_channel,
                    TileItem.Action.APP_VIEW,
                    "https://urec.uark.edu/",
                    TileItem.Type.WIDGET,
                    Constants.ACTIVITY_NEWS
                ),
                TileItem(
                    "Transit",
                    4,
                    R.drawable.ic_baseline_directions_bus_24,
                    TileItem.Action.WEB_VIEW,
                    "https://uark.passiogo.com/",
                    TileItem.Type.ICON_TITLE,

                ),
                TileItem(
                    "Parking",
                    2,
                    R.drawable.ic_baseline_local_parking_24,
                    TileItem.Action.WEB_LINK,
                    "https://parking.uark.edu/",
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Housing",
                    2,

                    R.drawable.ic_baseline_home_work_24,
                    TileItem.Action.WEB_VIEW,
                    "https://housing.uark.edu/", TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Dining",
                    4,
                    R.drawable.ic_baseline_fastfood_24,
                    TileItem.Action.WEB_VIEW,
                    "https://dineoncampus.com/razorbacks/",
                    TileItem.Type.ICON_TITLE
                ),

                TileItem(
                    "Pat Walker Health Center",
                    4,
                    R.drawable.ic_baseline_health_and_safety_24,
                    TileItem.Action.WEB_VIEW,
                    "https://health.uark.edu/",
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Map",
                    2,
                    R.drawable.ic_baseline_place_24,
                    TileItem.Action.WEB_VIEW,
                    "https://campusmaps.uark.edu/",
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Razorbacks",
                    2,
                    R.drawable.razor,
                    TileItem.Action.WEB_VIEW,
                    "https://arkansasrazorbacks.com/",
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "UAPD",
                    2,
                    R.drawable.ic_outline_local_police_24,
                    TileItem.Action.WEB_VIEW,
                    "https://uapd.uark.edu/",
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Full Circle Food Pantry",
                    2,
                    R.drawable.ic_baseline_food_bank_24,
                    TileItem.Action.WEB_VIEW,
                    "https://service.uark.edu/services/pantry/index.php",
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "More Resources",
                    2,
                    R.drawable.ic_baseline_add_circle_outline_24,
                    TileItem.Action.WEB_VIEW,
                    "https://sponsored-students.uark.edu/current-students/resources/campus-resources.php",
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
                    TileItem.Action.WEB_VIEW,
                    "https://classes.uark.edu/",
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Blackboard",
                    2,
                    R.drawable.bb,
                    TileItem.Action.WEB_VIEW,
                    "https://learn.uark.edu/",
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "UAConnect",
                    2,
                    null,
                    TileItem.Action.WEB_VIEW,
                    "https://uaconnect.uark.edu/",
                    TileItem.Type.TEXT
                ),
                TileItem(
                    "Library",
                    1,
                    R.drawable.ic_baseline_local_library_24,
                    TileItem.Action.WEB_LINK,
                    "https://libraries.uark.edu/",
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Handshake",
                    1,
                    R.drawable.handshake,
                    TileItem.Action.WEB_LINK,
                    "https://uark.joinhandshake.com/",
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Career Development Center",
                    2,
                    R.drawable.ic_baseline_work_24,
                    TileItem.Action.WEB_LINK,
                    "https://career.uark.edu/cdc/",
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Bookstore",
                    1,
                    R.drawable.ic_baseline_menu_book_24,
                    TileItem.Action.WEB_LINK,
                    "https://uark.bncollege.com/",
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Student Success",
                    1,
                    R.drawable.ic_baseline_star_outline_24,
                    TileItem.Action.WEB_LINK,
                    "https://success.uark.edu/",
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "Degree Programs",
                    1,
                    R.drawable.ic_outline_school_24_outline,
                    TileItem.Action.WEB_LINK,
                    "https://www.uark.edu/academics/majors.php",
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
                    TileItem.Action.WEB_LINK,
                    "https://hogsync.uark.edu/",
                    TileItem.Type.LOGO
                ),
                TileItem(
                    "Directory",
                    2,
                    R.drawable.ic_baseline_contacts_24,
                    TileItem.Action.WEB_VIEW,
                    "https://directory.uark.edu/",
                    TileItem.Type.ICON_TITLE
                ),

                TileItem(
                    "University Programs",
                    2,
                    R.drawable.up,
                    TileItem.Action.WEB_VIEW,
                    "https://up.uark.edu/",
                    TileItem.Type.LOGO
                ),
                TileItem(
                    "Multicultural Center",
                    2,
                    R.mipmap.ic_mc,
                    TileItem.Action.WEB_VIEW,
                    "https://multicultural.uark.edu/",
                    TileItem.Type.ICON_TITLE
                ),
                TileItem(
                    "UREC",
                    2,
                    R.mipmap.ic_channel,
                    TileItem.Action.WEB_VIEW,
                    "https://urec.uark.edu/",
                    TileItem.Type.LOGO
                ),

                TileItem(
                    "UATV",
                    2,
                    R.mipmap.ic_uatv,
                    TileItem.Action.WEB_VIEW,
                    "https://uatvonline.net/",
                    TileItem.Type.LOGO
                ),
                TileItem(
                    "ASG",
                    2,
                    R.mipmap.ic_asg,
                    TileItem.Action.WEB_VIEW,
                    "https://asg.uark.edu/",
                    TileItem.Type.LOGO
                ),
                TileItem(
                    "Add More",
                    2,
                    R.drawable.ic_baseline_add_circle_outline_24,
                    TileItem.Action.WEB_VIEW,
                    "https://hogsync.uark.edu/",
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
                    TileItem.Action.WEB_VIEW,
                    "https://www.uark.edu/a-to-z.php",
                    TileItem.Type.ICON_TITLE
                ),
            )
        )
        return list
    }
}