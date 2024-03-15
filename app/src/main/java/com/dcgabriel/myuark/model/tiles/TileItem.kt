package com.dcgabriel.myuark.model.tiles

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class TileItem(
    val id: Int,
    val title: String = "This is a title",
    val category: Category,
    val colSize: Int = 1,
    val image: Int?,
    val tileData: TileData,
    val action: Action,
    val type: Type,
    val destination: String? = null,
    )  {

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
        STUDENT_ID
    }
    enum class Category {
        CAMPUS,
        STUDENT,
        EXPLORE,
        OTHER
    }
}