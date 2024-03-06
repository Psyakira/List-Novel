package com.example.android_beginner

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListNovelAdapter (private val listNovel: ArrayList<Novel>) : RecyclerView.Adapter<ListNovelAdapter.ListViewHolder>(){

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_novel, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (tittle, sinopsis, price, publisher, cover) = listNovel[position]
        holder.imgcover.setImageResource(cover)
        holder.tvtittle.text = tittle
        holder.tvsinopsis.text = sinopsis

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailNovel::class.java)
            intentDetail.putExtra("key_novel", listNovel[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listNovel.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgcover: ImageView = itemView.findViewById(R.id.img_cover)
        val tvtittle: TextView = itemView.findViewById(R.id.tv_tittle)
        val tvsinopsis: TextView = itemView.findViewById(R.id.tv_sinopsis)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Novel)

    }
}