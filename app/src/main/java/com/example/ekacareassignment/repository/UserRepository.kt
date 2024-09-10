package com.example.ekacareassignment.repository

import androidx.lifecycle.LiveData
import com.example.ekacareassignment.model.User
import com.example.ekacareassignment.model.UserDao

class UserRepository(private val usersDao: UserDao) {

    val allUsers: LiveData<List<User>> = usersDao.getAllUsers()

    suspend fun insert(user: User) {
        usersDao.insert(user)
    }

    suspend fun delete(user: User) {
        usersDao.delete(user)
    }

    suspend fun update(user: User) {
        usersDao.update(user)
    }
}