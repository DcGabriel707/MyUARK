package com.dcgabriel.myuark.model.tiles

import com.dcgabriel.myuark.model.Constants
import com.dcgabriel.myuark.model.tiles.TileItem.Action
import com.example.myuark.R

object DummyData {
    var allTiles = ArrayList<TileItem>()

    init {
        createTiles()
    }

    fun getTile(key: Int) = allTiles.find { tile -> tile.id == key }
    fun getCampusTiles() = allTiles.filter { tile -> tile.category == TileItem.Category.CAMPUS }
    fun getStudentTiles() = allTiles.filter { tile -> tile.category == TileItem.Category.STUDENT }
    fun getExploreTiles() = allTiles.filter { tile -> tile.category == TileItem.Category.EXPLORE }
    fun getOtherTiles() = allTiles.filter { tile -> tile.category == TileItem.Category.OTHER }


    private fun createTiles() {

        //Start of campus tiles.
        allTiles.add(
            TileItem(
                1001,
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
                1002,
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
                1003,
                "Transit",
                TileItem.Category.CAMPUS,
                4,
                R.drawable.bus_alt,
                TileData(
                    "https://uark.passiogo.com/",
                    arrayListOf(
                        "https://twitter.com/uatandp",
                        "https://www.instagram.com/uatandp/"
                    ),
                    "com.passio3.go"
                ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE,
            )
        )
        allTiles.add(
            TileItem(
                1004,
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
                    ),
                    "group.flowbird.mpp"
                ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                1005,
                "Housing",
                TileItem.Category.CAMPUS,
                2,
                R.drawable.house_user,
                TileData(
                    "https://housing.uark.edu/",
                    arrayListOf(
                        "https://twitter.com/Uarkhousing",
                        "https://www.instagram.com/Uarkhousing/",
                        "https://www.youtube.com/channel/UCpg2zTOL2F4zZEuoOQrXBdg",
                        "https://www.laundryalert.com/cgi-bin/razorbacks/LMPage?CallingPage=LMRoom&RoomPersistence=&MachinePersistenceA=010&MachinePersistenceB"
                    )
                ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                1006,
                "Dining",
                TileItem.Category.CAMPUS,
                4,
                R.drawable.burger_soda,
                TileData(
                    "https://dineoncampus.com/razorbacks/",
                    arrayListOf(
                        "https://www.facebook.com/FoodontheHillAR",
                        "https://twitter.com/FoodontheHillAR",
                        "https://www.instagram.com/foodonthehill_ar/"
                    )
                ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )

        allTiles.add(
            TileItem(
                1007,
                "Pat Walker Health Center",
                TileItem.Category.CAMPUS,
                4,
                R.drawable.heartbeat,
                TileData(
                    "https://health.uark.edu/",
                    arrayListOf(
                        "https://www.facebook.com/UofAHealth",
                        "https://twitter.com/UofAHealth",
                        "https://www.instagram.com/uofahealth/"
                    ),

                    ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                1008,
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
                1009,
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
                1010,
                "UAPD",
                TileItem.Category.CAMPUS,
                2,
                R.drawable.shield_alt,
                TileData(
                    "https://uapd.uark.edu/",
                    arrayListOf(
                        "https://www.facebook.com/UARKPD/",
                    ),
                    "com.criticalarc.safezoneapp"
                ),

                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                1011,
                "Jobs",
                TileItem.Category.CAMPUS,
                2,
                R.drawable.briefcase,
                TileData("https://uasys.wd5.myworkdayjobs.com/UASYS?locations=17a66cdad98201f7890cfb48ca00e249&q=University+of+Arkansas%2C+Fayetteville"),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                1012,
                "Full Circle Food Pantry",
                TileItem.Category.CAMPUS,
                2,
                R.drawable.hands_heart,
                TileData(
                    "https://service.uark.edu/services/pantry/index.php",
                    arrayListOf(
                        "https://www.facebook.com/UAVAC/",
                        "https://twitter.com/uacce",

                        )
                ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                1013,
                "More Resources",
                TileItem.Category.CAMPUS,
                2,
                R.drawable.plus_circle,
                TileData("https://sponsored-students.uark.edu/current-students/resources/campus-resources.php"),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )








        //Start of student tiles
        allTiles.add(
            TileItem(
                2001,
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
                2002,
                "Blackboard",
                TileItem.Category.STUDENT,
                2,
                R.drawable.bb,
                TileData(
                    "https://learn.uark.edu/",
                    arrayListOf(),
                    "com.blackboard.android.bbstudent"
                ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                2003,
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
                2004,
                "Academic Calendar",
                TileItem.Category.STUDENT,
                1,
                R.drawable.calendar_alt,
                TileData("https://registrar.uark.edu/academic-dates/3-year-academic-calendar/2021-2022-five-year-academic-calendar.php"),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                2005,
                "Handshake",
                TileItem.Category.STUDENT,
                1,
                R.drawable.handshake,
                TileData(
                    "https://uark.joinhandshake.com/",
                    arrayListOf(),
                    "com.joinhandshake.student"
                ),
                Action.WEB_LINK,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                2006,
                "Career Development Center",
                TileItem.Category.STUDENT,
                2,
                R.drawable.briefcase,
                TileData(
                    "https://career.uark.edu/cdc/",
                    arrayListOf(
                        "https://www.facebook.com/UACareer/",
                        "https://twitter.com/UARK_CDC"
                    ),
                    "com.joinhandshake.student"
                ),
                Action.WEB_LINK,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                2007,
                "Workday",
                TileItem.Category.STUDENT,
                2,
                R.drawable.logo_wday,
                TileData(
                    "https://workday.uark.edu/",
                    arrayListOf(
                        "https://wd5.myworkday.com/uasys/d/home.htmld"
                    ),
                    "com.workday.workdroidapp"
                ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )

        allTiles.add(
            TileItem(
                2008,
                "Library",
                TileItem.Category.STUDENT,
                1,
                R.drawable.book_open,
                TileData(
                    "https://libraries.uark.edu/",
                    arrayListOf(
                        "https://twitter.com/UARKLibraries",
                        "https://www.instagram.com/uarklibraries/",
                    )
                ),
                Action.WEB_LINK,
                TileItem.Type.ICON_TITLE
            )
        )

        allTiles.add(
            TileItem(
                2009,
                "Bookstore",
                TileItem.Category.STUDENT,
                1,
                R.drawable.books,
                TileData(
                    "https://uark.bncollege.com/",
                    arrayListOf(
                        "https://www.facebook.com/UofABookstore/",
                    )
                ),
                Action.WEB_LINK,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                2010,
                "Student Success",
                TileItem.Category.STUDENT,
                1,
                R.drawable.user_graduate,
                TileData(
                    "https://success.uark.edu/",
                    arrayListOf(
                        "https://www.facebook.com/uarksuccess",
                        "https://twitter.com/uarksuccess",
                        "https://www.instagram.com/uarksuccess/"
                    )
                ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                2011,
                "Degree Programs",
                TileItem.Category.STUDENT,
                1,
                R.drawable.diploma,
                TileData("https://www.uark.edu/academics/majors.php"
                ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )

        allTiles.add(
            TileItem(
                2012,
                "Scholarships",
                TileItem.Category.STUDENT,
                1,
                R.drawable.ic_envelope_open_dollar,
                TileData("https://scholarships.uark.edu/",
                    arrayListOf(
                        "https://uark.academicworks.com/",
                        "https://scholarships.uark.edu/faq.php",
                        "https://finaid.uark.edu/"
                    )
                ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )










        //Start of explore tiles
        allTiles.add(
            TileItem(
                3001,
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
                3002,
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
                3003,
                "University Programs",
                TileItem.Category.EXPLORE,
                2,
                R.drawable.up,
                TileData(
                    "https://up.uark.edu/",
                    arrayListOf(
                        "https://www.facebook.com/UniversityPrograms",
                        "https://twitter.com/UParkansas",
                    ),

                    ),
                Action.WEB_VIEW,
                TileItem.Type.LOGO
            )
        )
        allTiles.add(
            TileItem(
                3004,
                "Multicultural Center",
                TileItem.Category.EXPLORE,
                2,
                R.mipmap.ic_mc,
                TileData(
                    "https://multicultural.uark.edu/",
                    arrayListOf(
                        "https://www.facebook.com/uarkmc",
                        "https://www.instagram.com/uark_mc/",
                        "https://www.youtube.com/channel/UCe1yxjkFsrKWT3axa0mGnbw"
                    )
                ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                3005,
                "UREC",
                TileItem.Category.EXPLORE,
                2,
                R.mipmap.ic_channel,
                TileData(
                    "https://urec.uark.edu/",
                    arrayListOf(
                        "https://www.facebook.com/urecarkansas",
                        "https://twitter.com/urecarkansas",
                        "https://www.instagram.com/urecarkansas/",
                        "https://www.youtube.com/channel/UCe1yxjkFsrKWT3axa0mGnbw"
                    )
                ),
                Action.WEB_VIEW,
                TileItem.Type.LOGO
            )
        )
        allTiles.add(
            TileItem(
                3006,
                "UATV",
                TileItem.Category.EXPLORE,
                2,
                R.mipmap.ic_uatv,
                TileData(
                    "https://uatvonline.net/",
                    arrayListOf(
                        "https://www.facebook.com/uastudenttelevision",
                        "https://twitter.com/uatvnews",
                        "https://www.instagram.com/uatvnews/",
                        "https://www.youtube.com/user/UATV214"
                    ),
                ),
                Action.WEB_VIEW,
                TileItem.Type.LOGO
            )
        )
        allTiles.add(
            TileItem(
                3007,
                "ASG",
                TileItem.Category.EXPLORE,
                2,
                R.mipmap.ic_asg,
                TileData(
                    "https://asg.uark.edu/",
                    arrayListOf(
                        "https://www.facebook.com/UofAASG",
                        "https://twitter.com/uofaasg",
                        "https://www.instagram.com/uarkasg/",
                        "https://www.linkedin.com/company/ua-associated-student-government/"
                    )
                ),
                Action.WEB_VIEW,
                TileItem.Type.LOGO
            )
        )
        allTiles.add(
            TileItem(
                3008,
                "Add More",
                TileItem.Category.EXPLORE,
                2,
                R.drawable.plus_circle,
                TileData(
                    "https://hogsync.uark.edu/",
                ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )


        //Start of others tiles
        allTiles.add(
            TileItem(
                4001,
                "A-Z Directory",
                TileItem.Category.OTHER,
                2,
                R.drawable.sort_alpha_down,
                TileData("https://www.uark.edu/a-to-z.php"),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )

    }


}