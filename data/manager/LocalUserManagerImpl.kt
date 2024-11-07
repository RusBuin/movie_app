package com.example.myapplication.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.preferencesDataStoreFile

import com.example.myapplication.domain.manager.LocalUserManager
import com.example.myapplication.util.Constants
import com.example.myapplication.util.Constants.APP_ENTRY
import com.example.myapplication.util.Constants.USER_SETTTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(private val context: Context): LocalUserManager {
    override suspend fun saveAppEntry() {
        context.dataStore.edit {settings ->
            settings[PreferencesKeys.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map{preferences ->
            preferences[PreferencesKeys.APP_ENTRY] ?: false
        }
    }

}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTTINGS)

private object PreferencesKeys {val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)}

