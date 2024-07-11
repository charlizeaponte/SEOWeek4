package edu.quinnipiac.seoweek4

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

object UserData {
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "progress")

    suspend fun setProgress(context: Context, subject: Int, progress: Double) {
        val key = doublePreferencesKey(subject.toString())
        context.dataStore.edit { preferences ->
            preferences[key] = progress
        }
    }

    suspend fun getProgress(context: Context, subject: Int): Double {
        val key = doublePreferencesKey(subject.toString())
        val preferences = context.dataStore.data.first()
        if (!preferences.contains(key)) {
            setProgress(context, subject, 0.0)
        }
        return preferences[key] ?: 0.0
    }

}