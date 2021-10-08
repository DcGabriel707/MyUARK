package com.dcgabriel.myuark.model.events

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "content", strict = false)
class ImageContent(
    @field:Attribute(name = "url")
    var url: String? = null
) {

}