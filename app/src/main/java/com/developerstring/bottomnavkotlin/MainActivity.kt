package com.developerstring.bottomnavkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView: BottomNavigationView
        bottomNavigationView = findViewById(R.id.bottom_nav)
        bottomNavigationView.setOnNavigationItemSelectedListener(nav)

        supportFragmentManager.beginTransaction().replace(
            R.id.frame_layout,
            FragmentHome()
        ).commit()

    }

    private val nav = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        var fragment:Fragment? = null

        when(item.itemId){

            R.id.home_nav -> fragment = FragmentHome()
            R.id.group_nav -> fragment = FragmentGroup()
            R.id.forum_nav -> fragment = FragmentForum()

        }

        supportFragmentManager.beginTransaction().replace(
            R.id.frame_layout,
            fragment!!
        ).commit()

        true
    }

}