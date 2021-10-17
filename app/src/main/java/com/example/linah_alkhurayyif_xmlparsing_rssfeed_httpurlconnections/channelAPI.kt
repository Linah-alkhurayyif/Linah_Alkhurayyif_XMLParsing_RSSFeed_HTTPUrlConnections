package com.example.linah_alkhurayyif_xmlparsing_rssfeed_httpurlconnections


import retrofit2.Call
import retrofit2.http.GET

interface channelAPI {
    @get:GET("rss/nyt/HomePage.xml")
    val feed: Call<Rsschannel?>?
    companion object {
        const val BASE_URL = "https://rss.nytimes.com/services/xml/"
    }
}