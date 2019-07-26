package com.example.maththeory.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maththeory.R
import com.example.maththeory.model.Article

class adapter(val items: ArrayList<Article>,val context: Context): RecyclerView.Adapter<adapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val article : Article = items[position]

        holder.textViewTitle.text = article.title
        holder.textViewDescription.text = article.text
    }
    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val textViewTitle= itemView.findViewById(R.id.list_title) as TextView
        val textViewDescription = itemView.findViewById(R.id.list_description) as TextView
    }
}