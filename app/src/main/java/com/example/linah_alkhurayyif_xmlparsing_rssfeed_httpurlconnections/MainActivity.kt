package com.example.linah_alkhurayyif_xmlparsing_rssfeed_httpurlconnections

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class MainActivity : AppCompatActivity() {
        val TAG = "MainActivity"
        private  val BASE_URL = "https://rss.nytimes.com/services/xml/"
        lateinit var item_Title_List: ArrayList<String>
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            item_Title_List = arrayListOf()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()
            val feedAPI = retrofit.create(channelAPI::class.java)
            val call = feedAPI.feed
            call!!.clone().enqueue(object : Callback<Rsschannel?> {
                override fun onResponse(call: Call<Rsschannel?>, response: Response<Rsschannel?>) {

                    val channel = response.body()!!.channel
                    val items= channel!!.item
                    Title_tv.text =  channel.title

                    for (item in items!!) {
                        item_Title_List.add(item.item_Title.toString())
                    }
                    initializeRV()
                }
                override fun onFailure(call: Call<Rsschannel?>, t: Throwable) {
                    Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.message)
                    Toast.makeText(this@MainActivity, "An Error Occured", Toast.LENGTH_SHORT).show()
                }
            })

        }
    private fun initializeRV(){
        recyclerView.adapter = RSSAdapter(item_Title_List)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
    }