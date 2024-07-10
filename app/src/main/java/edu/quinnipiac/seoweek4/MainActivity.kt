package edu.quinnipiac.seoweek4

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import edu.quinnipiac.seoweek4.databinding.ActivityMainBinding
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val appBarConfiguration = AppBarConfiguration.Builder(navController.graph)
            .setOpenableLayout(drawer)
            .build()

        toolbar.setupWithNavController(navController, appBarConfiguration)
        val navView = findViewById<NavigationView>(R.id.nav_view)
        NavigationUI.setupWithNavController(navView, navController)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return item.onNavDestinationSelected(navController)
                || super.onOptionsItemSelected(item)
    }
    }
