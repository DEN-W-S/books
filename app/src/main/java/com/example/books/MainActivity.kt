package com.example.books

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.books.adapter.BooksAdapter
import com.example.books.api.ApiService
import com.example.books.pojo.SearchBook
import com.google.android.material.navigation.NavigationView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    lateinit var nav_view: NavigationView
    lateinit var drawer : DrawerLayout
    lateinit var buttonMain : Button
    lateinit var adapter: BooksAdapter
    lateinit var recyclerViewBooks: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view = findViewById(R.id.nav_view)
        buttonMain = findViewById(R.id.buttonMenu)
        drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        recyclerViewBooks = findViewById(R.id.recyclerViewBooks)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        adapter = BooksAdapter()
        adapter.setSearchBook(ArrayList<SearchBook>())
        recyclerViewBooks.layoutManager = LinearLayoutManager(this)
        recyclerViewBooks.adapter = adapter
        nav_view.setNavigationItemSelectedListener (this)
        val apiService = ApiService .getInstance ()?.getSearchBook ()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({
                if (it != null) {
                    adapter.setSearchBook(it.getData() as List<SearchBook>)
                    
                }
            },{

            })



        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId){
                R.id.radioButton ->{Toast.makeText(applicationContext, "Первый переключатель",
                    Toast.LENGTH_SHORT).show();}
                R.id.radioButton2 ->{ Toast.makeText(
                    applicationContext, "Второй переключатель",
                    Toast.LENGTH_SHORT).show();}
                R.id.radioButton3 ->{ Toast.makeText(
                    applicationContext, "Третий переключатель",
                    Toast.LENGTH_SHORT).show();}
            }

            findViewById<RadioButton>(checkedId)?.apply {


            }
        }
    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {


        when(item.itemId){
            R.id.id_main_screen ->{}

            R.id.id_category -> {
                val category = Intent(this, CategoryActivity::class.java)
                startActivity(category)
            }
            R.id.id_information -> {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse("https://www.rexit.info")
                startActivity(openURL)
            }

            R.id.id_impressum -> {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse("https://www.google.com")
                startActivity(openURL)
            }
        }

        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    fun onClickMenu(view : View) {
        drawer.openDrawer(GravityCompat.START)
    }

}


