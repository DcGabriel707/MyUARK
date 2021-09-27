package com.dcgabriel.myuark.model

 class TileItem(
    val title: String = "This is a title",
    val colSize: Int = 1,
    val image: Int?,
    val action: TileItem.Action,
    val url: String?,
    val type: TileItem.Type,
    val destination : String? = null,
    val subtext: String? = null

) {

    enum class Action{
        WEB_LINK,
        APP_LINK,
        WEB_VIEW,
        APP_VIEW,

    }

    enum class Type {
        ICON_TITLE,
        LOGO,
        IMAGE,
        IMAGE_TEXT,
        TEXT,
        WIDGET,
    }
}