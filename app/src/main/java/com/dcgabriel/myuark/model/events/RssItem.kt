package com.dcgabriel.myuark.model.events

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import org.simpleframework.xml.ElementList


@Root(name = "item", strict = false)
class RssItem(
    @field:Element(name = "title")
    var title: String? = null,


    @field:Element(name = "link")
    var link: String? = null,


    @field:Element(name = "pubDate")
    var pubDate: String? = null,

    @field:Element(name = "description")
    var description: String? = null,

    @field:Element(name = "content")
    var imageContent: ImageContent? = null,
) : EventItem() {
    override fun toString(): String {
        return ("RssItem [title=" + title + ", link=" + link + ", pubDate=" + pubDate
                + ", description=" + description + "]")
    }
}