package com.example.books

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.books.adapter.BooksAdapter
import com.example.books.adapter.CategoriesAdapter
import com.example.books.api.ApiService
import com.example.books.pojo.SearchBook
import com.example.books.pojo.SearchCategories
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.ArrayList

class CategoryActivity : AppCompatActivity() {


    lateinit var adapter: CategoriesAdapter
    lateinit var recyclerViewCategory : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        recyclerViewCategory = findViewById(R.id.recyclerViewCategory)
        adapter = CategoriesAdapter()
        adapter.setSearchCategory(ArrayList<SearchCategories>())
        recyclerViewCategory.layoutManager = LinearLayoutManager(this)
        recyclerViewCategory.adapter = adapter

        val apiService = ApiService .getInstance ()?.getSearchCategories()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({
                if (it != null) {
                adapter.setSearchCategory(it.getDataCategory() as List<SearchCategories>)
                }
            },{

            })
    }

    fun onClickCategoryMenu (view: View) {
        val mune = Intent(this, MainActivity::class.java)
        startActivity(mune)
    }

    fun onClickCategoryMain (view: View) {
        val main = Intent(this, MainActivity::class.java).apply {

        }
        startActivity(main)
    }
}