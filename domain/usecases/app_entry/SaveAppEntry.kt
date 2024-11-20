package com.example.myapplication.domain.usecases.app_entry
import com.example.myapplication.domain.manager.LocalUserManager;

class SaveAppEntry(
    private val localUserManager:LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}
