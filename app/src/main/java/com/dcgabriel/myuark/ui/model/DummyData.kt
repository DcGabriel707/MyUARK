package com.dcgabriel.myuark.ui.model

import com.example.myuark.R

object DummyData {
    fun getCampusTiles(): List<TileItem>{
        var list = ArrayList<TileItem>()
        list.addAll(listOf(
            TileItem("Transit",
                2,
                R.drawable.ic_baseline_directions_bus_24,
                TileItem.Action.WEB_VIEW,
                "https://uark.passiogo.com/", TileItem.Type.ICON_TITLE
            ),
            TileItem(
                "Parking",
                1,
                R.drawable.ic_baseline_local_parking_24,
                TileItem.Action.WEB_LINK,
                "https://parking.uark.edu/",
                TileItem.Type.ICON_TITLE
            ),
            TileItem(
                "Housing",
                1,

                R.drawable.ic_baseline_home_work_24,
                TileItem.Action.WEB_VIEW,
                "https://housing.uark.edu/", TileItem.Type.ICON_TITLE
            ),
            TileItem(
                "Dining",
                2,
                R.drawable.ic_baseline_fastfood_24,
                TileItem.Action.WEB_VIEW,
                "https://dineoncampus.com/razorbacks/",
                TileItem.Type.ICON_TITLE
            ),

            TileItem(
                "Pat Walker Health Center",
                2,
                R.drawable.ic_baseline_health_and_safety_24,
                TileItem.Action.WEB_VIEW,
                "https://health.uark.edu/",
                TileItem.Type.ICON_TITLE
            ),
            TileItem(
                "Map",
                1,
                R.drawable.ic_baseline_place_24,
                TileItem.Action.WEB_VIEW,
                "https://campusmaps.uark.edu/",
                TileItem.Type.ICON_TITLE
            ),
            TileItem(
                "Events",
                1,
                R.drawable.ic_baseline_event_24,
                TileItem.Action.WEB_LINK,
                "https://calendars.uark.edu/",
                TileItem.Type.ICON_TITLE
            ),
            TileItem("News",
                2,
                R.drawable.ic_baseline_feed_24,
                TileItem.Action.APP_VIEW,
                "https://news.uark.edu/", TileItem.Type.ICON_TITLE
            ),
        )
        )
        return list
    }




    fun getStudentTiles(): List<TileItem>{
        var list = ArrayList<TileItem>()
        list.addAll(listOf(
            TileItem("Courses",
                1,
                R.drawable.ic_baseline_book_24,
                TileItem.Action.WEB_LINK,
                "https://classes.uark.edu/",
                TileItem.Type.ICON_TITLE
            ),
            TileItem("Blackboard",
                2,
                R.drawable.bb,
                TileItem.Action.WEB_VIEW,
                "https://learn.uark.edu/",
                TileItem.Type.ICON_TITLE
            ),
            TileItem("UAConnect",
                2,
                null,
                TileItem.Action.WEB_VIEW,
                "https://uaconnect.uark.edu/",
                TileItem.Type.TEXT
            ),
            TileItem("Library",
                1,
                R.drawable.ic_baseline_local_library_24,
                TileItem.Action.WEB_LINK,
                "https://libraries.uark.edu/",
                TileItem.Type.ICON_TITLE
            ),
            TileItem("Handshake",
                1,
                R.mipmap.ic_handshake,
                TileItem.Action.WEB_LINK,
                "https://uark.joinhandshake.com/",
                TileItem.Type.ICON_TITLE
            ),
            TileItem("Hogsync",
                2,
                R.drawable.hogsync,
                TileItem.Action.WEB_LINK,
                "https://hogsync.uark.edu/",
                TileItem.Type.LOGO
            ),
            TileItem("Career Development Center",
                2,
                null,
                TileItem.Action.WEB_LINK,
                "https://career.uark.edu/cdc/",
                TileItem.Type.TEXT
            ),
            TileItem("Bookstore",
                1,
                R.drawable.ic_baseline_menu_book_24,
                TileItem.Action.WEB_LINK,
                "https://uark.bncollege.com/",
                TileItem.Type.ICON_TITLE
            ),
            TileItem("Student Success",
                1,
                R.drawable.ic_baseline_star_outline_24,
                TileItem.Action.WEB_LINK,
                "https://success.uark.edu/",
                TileItem.Type.ICON_TITLE
            ),
        )
        )


        return list
    }

    fun getExploreTiles() : List<TileItem> {
        var list = ArrayList<TileItem>()
        list.addAll(listOf(
            TileItem(
                "Events",
                3,
                R.mipmap.ic_channel,
                TileItem.Action.WEB_VIEW,
                "https://urec.uark.edu/",
                TileItem.Type.WIDGET
            ),
            TileItem(
                "News",
                3,
                R.mipmap.ic_channel,
                TileItem.Action.WEB_VIEW,
                "https://urec.uark.edu/",
                TileItem.Type.WIDGET
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
                "UAPD",
                2,
                R.mipmap.ic_uapd,
                TileItem.Action.WEB_VIEW,
                "https://uapd.uark.edu/",
                TileItem.Type.LOGO
            ),
            TileItem("Multicultural Center",
                2,
                R.mipmap.ic_mc,
                TileItem.Action.WEB_VIEW,
                "https://multicultural.uark.edu/",
                TileItem.Type.ICON_TITLE
            ),
        ))

        return list
    }
}