package com.dcgabriel.myuark.ui.model

import android.graphics.drawable.Drawable
import java.net.URL

class TileItem(
    val title: String = "This is a title",
    val colSize: Int = 1,
    val image: Int?,
    val type: TileItem.Type,
    val url: String?

) {



    enum class Type{
        WEB_LINK,
        APP_LINK,
        WEB_VIEW,
        APP_VIEW,
        WIDGET,

    }
}