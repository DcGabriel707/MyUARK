package com.dcgabriel.myuark.model.tiles

import com.dcgabriel.myuark.model.URLInfo

class TileData(
    val url: URLInfo?,
    val socialLinks: ArrayList<URLInfo>? = arrayListOf(),
    val featuredLinks: ArrayList<URLInfo>? = arrayListOf(),
    val applink: String? = null,
    val address: String? = null,
    val phone: String? = null,
    val email: String? = null,
    val subtext: String? = null,

    ) {

}