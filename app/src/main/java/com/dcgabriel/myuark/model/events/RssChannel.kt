package com.dcgabriel.myuark.model.events

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root


@Root(name = "channel", strict = false)
class RssChannel(
    @field:Element(name = "title")
    var title: String? = null,

    @field:ElementList(name = "item", inline = true, required = false)
    var item: List<RssItem>? = null
) {

    override fun toString(): String {
        return "Channel [item=$item]"
    }
}