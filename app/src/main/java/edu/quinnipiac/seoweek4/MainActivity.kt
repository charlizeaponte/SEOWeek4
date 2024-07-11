package edu.quinnipiac.seoweek4

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import edu.quinnipiac.seoweek4.databinding.ActivityMainBinding
import java.util.Locale


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

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        menu.findItem(R.id.action_translate_es)?.setOnMenuItemClickListener {
            switchLocale("es")
            true
        }
        menu.findItem(R.id.action_translate_fr)?.setOnMenuItemClickListener {
            switchLocale("fr")
            true
        }
        menu.findItem(R.id.action_translate_de)?.setOnMenuItemClickListener {
            switchLocale("de")
            true
        }
        return super.onPrepareOptionsMenu(menu)
    }

    private fun switchLocale(langCode: String) {
        val locale = Locale(langCode)
        Locale.setDefault(locale)
        val config = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)

        // Save the selected locale
        val editor = getSharedPreferences("Settings", MODE_PRIVATE).edit()
        editor.putString("My_Lang", langCode)
        editor.apply()

        // Recreate the activity's content to apply the new locale
        recreate()
    }

    private fun loadLocale() {
        val prefs = getSharedPreferences("Settings", MODE_PRIVATE)
        val language = prefs.getString("My_Lang", "") ?: return
        switchLocale(language)
    }
    }
