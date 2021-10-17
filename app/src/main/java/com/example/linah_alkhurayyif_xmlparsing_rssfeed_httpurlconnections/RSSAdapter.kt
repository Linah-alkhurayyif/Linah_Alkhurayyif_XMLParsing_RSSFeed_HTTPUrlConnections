package com.example.linah_alkhurayyif_xmlparsing_rssfeed_httpurlconnections

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RSSAdapter (private val titleList: ArrayList<String>):  RecyclerView.Adapter<RSSAdapter.ItemViewHolder>(){
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false ))}
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val title = titleList[position]
        holder.itemView.apply {
            textView.text = title

        }
    }
    override fun getItemCount() = titleList.size

}