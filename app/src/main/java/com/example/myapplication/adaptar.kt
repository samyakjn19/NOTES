package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class adaptar ( var context: Context , data: ArrayList<subject>) : RecyclerView.Adapter<adaptar.ViewHolder> () {



    var data:List<subject>

    init {
        this.data = data
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var layout = LayoutInflater.from(context).inflate(R.layout.item_subject , parent , false)

        return ViewHolder(layout)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title.text = data[position].title
        holder.disc.text = data[position].desc
        holder.id.text = data[position].id


    }

    override fun getItemCount(): Int {

        return data.size
    }



    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        var title:TextView
        var disc:TextView
        var id:TextView

        init {
            title = item.findViewById(R.id.title_textview)
            disc = item.findViewById(R.id.desc_textview)
            id = item.findViewById(R.id.id_textview2)
        }


    }
}