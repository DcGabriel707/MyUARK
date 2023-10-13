package com.dcgabriel.myuark.model.tiles

import com.dcgabriel.myuark.model.Constants
import com.dcgabriel.myuark.model.URLInfo
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
                1002,
                "News",
                TileItem.Category.CAMPUS,
                6,
                R.drawable.newspaper,
                TileData(
                    URLInfo("News","https://news.uark.edu/"),
                    null,
                    arrayListOf(
                        URLInfo("Submit A Story","https://news.uark.edu/articles/submit"),
                        URLInfo("Campus Experts","https://news.uark.edu/expertrequest"),
                        URLInfo("Contact us","https://news.uark.edu/contactus")
                    ),
                ),
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
                    URLInfo("Passio Go","https://uark.passiogo.com/"),
                    arrayListOf(
                        URLInfo("Facebook", "https://www.facebook.com/UARKservices"),
                        URLInfo("Twitter", "https://twitter.com/UARKservices"),
                        URLInfo("Instagram", "https://www.instagram.com/uarkservices/"),
                    ),
                    arrayListOf(
                        URLInfo("Transit Services", "https://parking.uark.edu/transit-services/index.php"),
                        URLInfo("Maps and Schedules", "https://parking.uark.edu/transit-services/transit-operations/maps-and-schedules.php"),
                        URLInfo("Frequently Asked Questions", "https://parking.uark.edu/transit-services/faq.php"),
                        URLInfo("Safe Ride", "https://parking.uark.edu/transit-services/safe-ride/index.php"),
                        URLInfo("Paratransit", "https://parking.uark.edu/transit-services/paratransit.php"),
                        URLInfo("Bikes", "https://parking.uark.edu/bikes.php"),

                    ),
                    "com.passio3.go",
                    "155 Razorback Road\n" +
                            "Campus Mail Stop: ADSB 131\n" +
                            "Fayetteville, Arkansas 72701",
                    "479-575-PARK (7275)",
                    "parking@uark.edu",
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
                    URLInfo("UARK Parking","https://parking.uark.edu/"),
                    arrayListOf(
                        URLInfo("Facebook", "https://www.facebook.com/UARKservices"),
                        URLInfo("Twitter", "https://twitter.com/UARKservices"),
                        URLInfo("Instagram", "https://www.instagram.com/uarkservices/"),
                    ),
                    arrayListOf(
                        URLInfo("Parking Services", "https://parking.uark.edu/parking-services/index.php"),
                        URLInfo("Parking Map", "https://parking.uark.edu/parkmap.pdf"),
                        URLInfo("Parking Options Chart", "https://parking.uark.edu/_resources/documents/UAParkingOptionsChart.pdf"),
                        URLInfo("Parking Permits", "https://parking.uark.edu/parking-services/parking-permits/index.php"),
                        URLInfo("Frequently Asked Questions", "https://parking.uark.edu/parking-services/faq.php"),
                    ),
                    "group.flowbird.mpp",
                    "155 Razorback Road\n" +
                            "Campus Mail Stop: ADSB 131\n" +
                            "Fayetteville, Arkansas 72701",
                    "479-575-RIDE (7433)",
                    "parking@uark.edu",
                ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                1005,
                "University Housing",
                TileItem.Category.CAMPUS,
                2,
                R.drawable.house_user,
                TileData(
                    URLInfo("University Housing","https://housing.uark.edu/"),
                    arrayListOf(
                        URLInfo("Twitter","https://twitter.com/Uarkhousing"),
                        URLInfo("Instagram","https://www.instagram.com/Uarkhousing/"),
                        URLInfo("Youtube","https://www.youtube.com/channel/UCpg2zTOL2F4zZEuoOQrXBdg"),
                        URLInfo("Wordpress","https://home.uark.edu/")
                    ),
                    arrayListOf(
                        URLInfo("Housing Portal","https://campushousing2.uark.edu/StarRezPortalX/404F7028/1/1/Home-Welcome_Page"),
                        URLInfo("Live Here","https://housing.uark.edu/live-here/index.php"),
                        URLInfo("Halls","https://housing.uark.edu/halls/"),
                        URLInfo("Services","https://housing.uark.edu/services/index.php"),
                        URLInfo("About Us","https://housing.uark.edu/about-us/index.php"),
                        URLInfo("Handbook","https://housing.uark.edu/handbook/index.php"),
                    ),
                    null,
                    "960 W. Douglas St.\n" +
                            "Fayetteville, AR 72701",
                    "479-575-HOUS (4687)",
                    "housing.uark.edu",
                ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                1006,
                "Campus Dining",
                TileItem.Category.CAMPUS,
                4,
                R.drawable.burger_soda,
                TileData(
                    URLInfo("Dine On Campus","https://dineoncampus.com/razorbacks/"),
                    arrayListOf(
                        URLInfo("Facebook","https://www.facebook.com/FoodontheHillAR"),
                        URLInfo("Twitter","https://twitter.com/FoodontheHillAR"),
                        URLInfo("Instagram","https://www.instagram.com/foodonthehill_ar/")
                    ),
                    arrayListOf(
                        URLInfo("Dining Hours","https://dineoncampus.com/razorbacks/hours-of-operation"),
                        URLInfo("What's on the Menu","https://dineoncampus.com/razorbacks/whats-on-the-menu"),
                        URLInfo("Campus Dining Map","https://dineoncampus.com/razorbacks/campus-dining-map"),
                        URLInfo("Frequently Asked Questions","https://dineoncampus.com/razorbacks/frequently-asked-questions"),
                        URLInfo("Dining Rates","https://housing.uark.edu/live-here/dining-information-and-rates.php")
                    ),
                    "com.roaringsky.dineoncampus",
                    "435 N Garland Ave., ARKU 104\n" +
                            "Fayetteville, Arkansas 72701",
                    "(479) 575-3232",

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
                    URLInfo("Pat Walker Health Center","https://health.uark.edu/"),
                    arrayListOf(
                        URLInfo("Facebook","https://www.facebook.com/UofAHealth"),
                        URLInfo("Twitter","https://twitter.com/UofAHealth"),
                        URLInfo("Instagram","https://www.instagram.com/uofahealth/")
                    ),
                    arrayListOf(
                        URLInfo("Patient Portal","https://myhealth.uark.edu/"),
                        URLInfo("Appointments","https://health.uark.edu/medical-health/appointments.php"),
                        URLInfo("Hours and Locations","https://health.uark.edu/about/hours-location.php"),
                        URLInfo("Contact Us","https://health.uark.edu/about/contact-us.php")
                    ),
                    null,
                    "525 N. Garland Ave.\n" +
                            "University of Arkansas\n" +
                            "Fayetteville, AR 72701",
                    "479-575-4451",
                    "pwhc@uark.edu"
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
                TileData(URLInfo("Campus Maps","https://campusmaps.uark.edu/"),
                    arrayListOf(),
                    arrayListOf(
                        URLInfo("Building Directory","https://campusmaps.uark.edu/buildings"),
                        URLInfo("Game Day Map","https://uapd.uark.edu/game-day/index.php"),
                    )
                ),
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
                TileData(URLInfo("Arkansas Razorbacks","https://arkansasrazorbacks.com/"),
                    arrayListOf(
                        URLInfo("Facebook","https://www.facebook.com/ArkansasRazorbacks/"),
                        URLInfo("Twitter","https://twitter.com/ArkRazorbacks"),
                        URLInfo("Instagram","https://www.instagram.com/arkrazorbacks/"),
                        URLInfo("Youtube","https://www.youtube.com/arkrazorbacks"),
                    ),
                    arrayListOf(
                        URLInfo("Social Directory","https://arkansasrazorbacks.com/social-directory/"),
                        URLInfo("Baseball","https://arkansasrazorbacks.com/sport/m-basebl/"),
                        URLInfo("Football","https://arkansasrazorbacks.com/sport/m-footbl/"),
                        URLInfo("Game Day Map","https://uapd.uark.edu/game-day/index.php"),
                        URLInfo("Tickets","https://arkansasrazorbacks.com/tickets/"),
                        URLInfo("Live Stats","http://www.statbroadcast.com/events/statbroadcast.php?gid=ark"),
                    ),
                    "com.ark.gameday",

                    ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )
        allTiles.add(
            TileItem(
                3005,
                "UREC",
                TileItem.Category.CAMPUS,
                2,
                R.mipmap.ic_channel,
                TileData(
                    URLInfo("UREC","https://urec.uark.edu/"),
                    arrayListOf(
                        URLInfo("Facebook","https://www.facebook.com/urecarkansas"),
                        URLInfo("Twitter","https://twitter.com/urecarkansas"),
                        URLInfo("Instagram","https://www.instagram.com/urecarkansas/"),
                        URLInfo("Youtube","https://www.youtube.com/channel/UCe1yxjkFsrKWT3axa0mGnbw")
                    ),
                    arrayListOf(
                        URLInfo("Member Portal","https://urecmembers.uark.edu/"),
                        URLInfo("Facility Hours","https://urec.uark.edu/about-urec/facility-hours/index.php"),
                        URLInfo("Group Fitness Schedule","https://urec.uark.edu/fitness/group-fitness/class-schedule/index.php"),
                        URLInfo("Intramural Sports","https://urec.uark.edu/intramural-sports/index.php"),
                        URLInfo("Sports Injury Clinic","https://urec.uark.edu/urec-sports-injury-clinic/index.php"),
                        URLInfo("Trips and Activities","https://urec.uark.edu/outdoors/trips-and-activities.php"),
                        URLInfo("Employment","https://urec.uark.edu/employment/index.php"),

                        ),
                    "",
                    "HPER 225\n" +
                            "University of Arkansas\n" +
                            "Fayetteville, Arkansas 72701",
                    "479-575-4646",
                    "urec@uark.edu"
                ),
                Action.WEB_VIEW,
                TileItem.Type.LOGO
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
                    URLInfo("University Police","https://uapd.uark.edu/"),
                    arrayListOf(
                        URLInfo("Facebook","https://www.facebook.com/UARKPD/"),
                        URLInfo("Instagram","https://instagram.com/uarkpd"),
                        URLInfo("Twitter","https://x.com/uarkpd"),
                    ),
                    arrayListOf(
                        URLInfo("Campus Safety","https://safety.uark.edu/"),
                        URLInfo("Notification Log","https://uapd.uark.edu/reports-and-logs/notification-log/index.php"),
                        URLInfo("Game Day Map","https://uapd.uark.edu/game-day/index.php"),
                        URLInfo("Community Outreach and Involvement","https://uapd.uark.edu/community-outreach-and-involvement/"),
                        URLInfo("Contact Us","https://uapd.uark.edu/about-us/contact-us.php"),
                    ),
                    "com.criticalarc.safezoneapp",
                    "University of Arkansas\n" +
                            "155 S. Razorback Road\n" +
                            "Fayetteville, Arkansas 72701",
                    "479-575-2222"
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
                TileData(URLInfo("UARK Jobs","https://uasys.wd5.myworkdayjobs.com/UASYS?locations=17a66cdad98201f7890cfb48ca00e249&q=University+of+Arkansas%2C+Fayetteville"),

                    ),
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
                    URLInfo("Full Circle Food Pantry","https://service.uark.edu/services/pantry/index.php"),
                    arrayListOf(
                        URLInfo("Facebook","https://www.facebook.com/UAFullCircle")
                        ),
                    arrayListOf(
                        URLInfo("Pantry OnlineOrdering","https://app.pantrysoft.com/login/uark"),
                        URLInfo("Linktree","https://linktr.ee/fullcirclefoodpantry"),
                        URLInfo("Full Circle Express","https://service.uark.edu/services/pantry/#:~:text=FULL%20CIRCLE-,EXPRESS,-This%20program%20is"),
                    ),
                    "324 Stadium Drive\n" +
                            "WAHR C204\n" +
                            "Bud Walton Hall\n" +
                            "Fayetteville, Arkansas 72701",
                    "479-575-7693",
                    "pantry@uark.edu"
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
                TileData(
                    URLInfo("More Resources","https://sponsored-students.uark.edu/current-students/resources/campus-resources.php")),
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
                TileData(URLInfo("","https://classes.uark.edu/")),
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
                    URLInfo("Blackboard","https://learn.uark.edu/"),
                    arrayListOf(),
                null,
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
                TileData(URLInfo("UAConnect","https://uaconnect.uark.edu/")),
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
                TileData(URLInfo("Calendars","https://registrar.uark.edu/academic-dates/3-year-academic-calendar/2021-2022-five-year-academic-calendar.php")),
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
                    URLInfo("Handshake","https://uark.joinhandshake.com/"),
                    arrayListOf(),
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
                    URLInfo("Career Development Center","https://career.uark.edu/cdc/"),
                    arrayListOf(
                        URLInfo("Facebook","https://www.facebook.com/UACareer/"),
                        URLInfo("Twitter","https://twitter.com/UARK_CDC")
                    ),
                    arrayListOf(),
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
                    URLInfo("Workday","https://workday.uark.edu/"),
                    arrayListOf(
                        URLInfo("Workday","https://wd5.myworkday.com/uasys/d/home.htmld")
                    ),
                    arrayListOf(),
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
                    URLInfo("Libraries","https://libraries.uark.edu/"),
                    arrayListOf(
                        URLInfo("Twitter","https://twitter.com/UARKLibraries"),
                        URLInfo("Instagram","https://www.instagram.com/uarklibraries/"),
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
                    URLInfo("Bookstore","https://uark.bncollege.com/"),
                    arrayListOf(
                        URLInfo("Facebook","https://www.facebook.com/UofABookstore/"),
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
                    URLInfo("Student Success","https://success.uark.edu/"),
                    arrayListOf(
                        URLInfo("Facebook","https://www.facebook.com/uarksuccess"),
                        URLInfo("Twitter","https://twitter.com/uarksuccess"),
                        URLInfo("Instagram","https://www.instagram.com/uarksuccess/")
                    )
                ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )

        allTiles.add(
            TileItem(
                2011,
                "Blackboard Help for Students",
                TileItem.Category.STUDENT,
                1,
                R.drawable.bb,
                TileData(
                    URLInfo("BBHelp","https://bbhelp.uark.edu/"),
                    arrayListOf(),
                    arrayListOf(
                        URLInfo("Blackboard Collaborate", "https://bbhelp.uark.edu/category/blackboard-collaborate/"),
                        URLInfo("Blackboard Help for College or University Students", "https://help.blackboard.com/"),
                        URLInfo("Getting Started with Kaltura Capture", "https://bbhelp.uark.edu/getting-started-with-kaltura-capture/"),
                        URLInfo("Chat with Tech Support", "https://its.uark.edu/chat/index.php?queue=29"),
                        URLInfo("Blackboard Help for Faculty", "https://tips.uark.edu/"),
                    ),
                    null,
                    null,
                    "479-575-HELP (4357)",
                    "bbhelp@uark.edu"

                ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )

        allTiles.add(
            TileItem(
                2012,
                "Degree Programs",
                TileItem.Category.STUDENT,
                1,
                R.drawable.diploma,
                TileData(
                    URLInfo("Majors","https://www.uark.edu/academics/majors.php")
                ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )

        allTiles.add(
            TileItem(
                2013,
                "Scholarships",
                TileItem.Category.STUDENT,
                1,
                R.drawable.ic_envelope_open_dollar,
                TileData(
                    URLInfo("Scholarships","https://scholarships.uark.edu/"),
                    arrayListOf(),
                    arrayListOf(
                        URLInfo("Scholarship List","https://uark.academicworks.com/"),
                        URLInfo("Frequently Asked Questions","https://scholarships.uark.edu/faq.php"),
                        URLInfo("Financial Aid Info","https://finaid.uark.edu/")
                    )
                ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )



        //Start of explore tiles
        allTiles.add(
            TileItem(
                1001,
                "Events",
                TileItem.Category.EXPLORE,
                6,
                R.drawable.calendar_alt,
                TileData(URLInfo("Calendar","https://calendar.uark.edu/")),
                Action.APP_VIEW,
                TileItem.Type.WIDGET,
                Constants.ACTIVITY_EVENTS
            )
        )
        allTiles.add(
            TileItem(
                3001,
                "Hogsync",
                TileItem.Category.EXPLORE,
                4,
                R.drawable.hogsync,
                TileData(URLInfo("Hogsync","https://hogsync.uark.edu/")),
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
                TileData(URLInfo("Directory","https://directory.uark.edu/")),
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
                    URLInfo("University Programs","https://up.uark.edu/"),
                    arrayListOf(
                        URLInfo("Facebook","https://www.facebook.com/UniversityPrograms"),
                        URLInfo("Twitter","https://twitter.com/UParkansas"),
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
                    URLInfo("Multicultural Center","https://multicultural.uark.edu/"),
                    arrayListOf(
                        URLInfo("Facebook","https://www.facebook.com/uarkmc"),
                        URLInfo("Instagram","https://www.instagram.com/uark_mc/"),
                        URLInfo("Youtube","https://www.youtube.com/channel/UCe1yxjkFsrKWT3axa0mGnbw")
                    )
                ),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
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
                    URLInfo("UATV","https://uatvonline.net/"),
                    arrayListOf(
                        URLInfo("Facebook","https://www.facebook.com/uastudenttelevision"),
                        URLInfo("Twitter","https://twitter.com/uatvnews"),
                        URLInfo("Instagram","https://www.instagram.com/uatvnews/"),
                        URLInfo("Youtube","https://www.youtube.com/user/UATV214")
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
                    URLInfo("ASG","https://asg.uark.edu/"),
                    arrayListOf(
                        URLInfo("Facebook","https://www.facebook.com/UofAASG"),
                        URLInfo("Twitter","https://twitter.com/uofaasg"),
                        URLInfo("Instagram","https://www.instagram.com/uarkasg/"),
                        URLInfo("Linkedin","https://www.linkedin.com/company/ua-associated-student-government/")
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
                    URLInfo("Hogsync","https://hogsync.uark.edu/"),
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
                TileData(URLInfo("Other","https://www.uark.edu/a-to-z.php")),
                Action.WEB_VIEW,
                TileItem.Type.ICON_TITLE
            )
        )

    }


}