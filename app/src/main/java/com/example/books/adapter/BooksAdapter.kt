package com.example.books.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.books.R
import com.example.books.pojo.SearchBook
import java.lang.String

class BooksAdapter : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>(){

    private var searchBook: List<SearchBook> = listOf()

    fun setSearchBook(searchBook: List<SearchBook>) {
        this.searchBook = searchBook
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): BooksViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_layout, viewGroup, false)
        return BooksViewHolder(view)
    }


    override fun getItemCount(): Int {
        return searchBook.size
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.textTitleCard.text = searchBook[position].title
        holder.textDetailsCard.text = searchBook[position].dUrl
        holder.textNewPrice.text = searchBook[position].nPrice
        holder.textOldPrice.text = searchBook[position].oPrice
        //holder.imageViewBook.setImageResource(searchBook[position].)

    }


    class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewBook : ImageView = itemView.findViewById(R.id.imageViewBook)
        val textTitleCard: TextView = itemView.findViewById(R.id.textTitleCard)
        val textDetailsCard: TextView = itemView.findViewById(R.id.textDetailsCard)
        val textNewPrice: TextView = itemView.findViewById(R.id.textNewPrice)
        val textOldPrice: TextView = itemView.findViewById(R.id.textOldPrice)

    }


}