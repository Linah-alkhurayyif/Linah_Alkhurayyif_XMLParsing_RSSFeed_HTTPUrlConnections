package com.example.linah_alkhurayyif_xmlparsing_rssfeed_httpurlconnections

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import retrofit2.http.Path
import java.io.Serializable

@Root(name = "item", strict = false)
class Item @JvmOverloads constructor(
    @field:Element(name = "title")
    @param:Element(name = "title")
    var item_Title: String? = null,

//    @field:Element(name = "description", required = false)
//    @param:Element(name = "description", required = false)
//    var description : String? = null,
    ): Serializable