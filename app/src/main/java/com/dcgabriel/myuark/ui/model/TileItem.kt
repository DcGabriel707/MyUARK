package com.dcgabriel.myuark.ui.model

 class TileItem(
    val title: String = "This is a title",
    val colSize: Int = 1,
    val image: Int?,
    val action: TileItem.Action,
    val url: String?,
    val type: TileItem.Type

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