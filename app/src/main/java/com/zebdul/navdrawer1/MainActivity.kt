package com.zebdul.navdrawer1

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawer_layout)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_nav,
            R.string.close_nav
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.homeBtn)
        }


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.homeBtn -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()

            R.id.messageBtn -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MessageFragment()).commit()

            R.id.personBtn -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, UserFragment()).commit()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
/*
        1. add a menu from res folder type:menu
        2. pass two attribute in xm Menu
            A. xmlns:tools="http://schemes.android.com/tools"
            B. tools:ShowIn = "navigation_view"
            C. add group type single
            D. add 3 items in group
        3. layout -> new layout resource file
        4. add background image
        5. main.xml ->
            A. give layour id
            B. android:fitsSystemWindows="true"
            C. tools:openDrawer="start"
            D. add a linear layout
            E. add toolbar in linear layout
                i. android:elevation="4dp"
                ii. add background in this
                iii. android:theme="@style.Theme.Appcompat.DayNight.DarkActionBar"
                iv.  app:popupTheme="@style.ThemeOverlay.AppCompat.Light"
            F. add a frame layout in linear layout
                i. give them id
            G. add a navigation.materialView
                i. height match parent
                ii. width wrap content
                iii. android:layout_gravity="start"
                iv.  add header layout --> app:headerLayout="@layout/nav_header"
                v. app:menu="@menu/nav_menu"
          6. main.kt
            A. initialize private late int drawerLayout : DrawerLayout
            B. findViewById drawerLayout
            C. findViewById toolbar -> setSupportActionBar(toolbar)
            D. findViewById naviagationView
            E. navigationView.setNavigationItemSelectedListener(this)
            F. add navigation viewselect listner
                i. class MainActivity : AppCompactActivity(), NavigationView.OnNavigationItemSelectedListner
                ii. and add implement member
            G. add toggle  = ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_nav, R.string.close_nav)
                toggle.syncState()

            7. drawerLayout.addDrawerListener(toggle)
            8. if (savedInstanceState == null){
                supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
                navigationView.setCheckedItem(R.id.homeBtn)
                           }
}
            override fun onNavigationItemSelected(Items:MenuItem):Boolean{
            when(item.itemID){
            R.id.homeBtn -> supportFragment.BeginTransaction()
            .replace(R.id.fragment_container), HomeFragment())

            R.id.messageBtn -> messageFragment.BeginTransaction()
            .replace(R.id.fragment_container), MessageFragment())

            R.id.userBtn -> userFragment.BeginTransaction()
            .replace(R.id.fragment_container), UserFragment())
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            return true

            override fun onBackPressed(){
                if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START)
                 }
                 else {
                 onBackPressedDispotcher.onBackPressed()
                 }                 }
}
         */