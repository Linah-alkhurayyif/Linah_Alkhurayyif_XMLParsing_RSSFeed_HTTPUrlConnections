package com.example.linah_alkhurayyif_xmlparsing_rssfeed_httpurlconnections

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable



@Root(name = "rss", strict = false)
class Rsschannel constructor() : Serializable {


    @field:Element(name = "channel")
    var channel: Channel? = null
}

