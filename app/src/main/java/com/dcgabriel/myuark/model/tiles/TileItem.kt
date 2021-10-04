package com.dcgabriel.myuark.model.tiles

class TileItem(
    val title: String = "This is a title",
    val colSize: Int = 1,
    val image: Int?,
    val tileData: TileData,
    val action: Action,
    val type: Type,
    val destination: String? = null,
    ) {

    enum class Action {
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