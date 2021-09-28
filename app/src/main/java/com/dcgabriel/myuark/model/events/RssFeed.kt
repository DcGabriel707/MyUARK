package com.dcgabriel.myuark.model.events

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
class RssFeed(
    @field:Element(name = "channel")
    var channel: RssChannel? = null
)
{
@Override
override fun toString(): String {
    return "RssFeed [channel=" + channel + "]"
}

}