package com.example.books

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    lateinit var nav_view: NavigationView
    lateinit var drawer : DrawerLayout
    lateinit var buttonMain : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view = findViewById(R.id.nav_view)
        buttonMain = findViewById(R.id.buttonMenu)
        drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout

        nav_view.setNavigationItemSelectedListener (this)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.id_main_screen ->
            {

                Toast.makeText(this, "main", Toast.LENGTH_SHORT).show()
            }
            R.id.id_category -> Toast.makeText(this, "category", Toast.LENGTH_SHORT).show()
            R.id.id_information -> {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.setData(Uri.parse("https://www.rexit.info"))
                startActivity(openURL)
                Toast.makeText(this, "information", Toast.LENGTH_SHORT).show()
            }

            R.id.id_impressum -> {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.setData(Uri.parse("https://www.google.com"))
                startActivity(openURL)
                Toast.makeText(this, "impressum", Toast.LENGTH_SHORT).show()
            }
        }

        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    fun onClickMenu(view : View) {
        drawer.openDrawer(GravityCompat.START)
    }
}