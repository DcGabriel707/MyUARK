package com.dcgabriel.myuark.model.events

import com.google.gson.annotations.SerializedName

sealed class EventItem{
    val type: Type = Type.ITEM
}

enum class Type {
    HEADER,
    ITEM
}