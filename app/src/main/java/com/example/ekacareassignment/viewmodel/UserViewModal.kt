package com.example.ekacareassignment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.ekacareassignment.model.User
import com.example.ekacareassignment.model.UserDatabase
import com.example.ekacareassignment.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModal(application: Application) : AndroidViewModel(application) {
    val allUsers: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val dao = UserDatabase.getDatabase(application).getUsersDao()
        repository = UserRepository(dao)
        allUsers = repository.allUsers
    }

    fun addUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(user)
    }

    fun validateForm(user: User): Boolean {
        return user.name.isNotEmpty() || user.age >= 0 || user.date.isNotEmpty() || user.address.isNotEmpty()
    }
}