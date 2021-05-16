package com.example.books.adapter

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.books.R
import com.example.books.pojo.SearchBook
import com.example.books.pojo.SearchCategories

class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    private var searchCategory: List<SearchCategories> = listOf()

    fun setSearchCategory(searchCategory: List<SearchCategories>) {
        this.searchCategory = searchCategory
        notifyDataSetChanged()
    }

    class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewCategories: TextView = itemView.findViewById(R.id.textViewCategories)
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CategoriesViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_layout_categotyes, viewGroup, false)
        return CategoriesViewHolder(view)
    }

    override fun getItemCount(): Int {
       return searchCategory.size
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.textViewCategories.text = searchCategory[position].name
    }
}