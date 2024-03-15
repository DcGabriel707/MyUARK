package com.dcgabriel.myuark.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class MyUtils {
    companion object {
        fun formatToHHMM(dateString: String): String {
            val isoFormat: DateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME
            val dateTime: LocalDateTime = LocalDateTime.parse(dateString, isoFormat)
            return dateTime.format(DateTimeFormatter.ofPattern("hh:mm a"))
        }
    }
}
