package com.example.ekacareassignment.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ekacareassignment.viewmodel.UserViewModal
import com.example.ekacareassignment.databinding.ActivityUserListBinding

class UserListActivity : AppCompatActivity() {
    private lateinit var viewModal: UserViewModal
    private lateinit var binding: ActivityUserListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bind()
        adListener()
    }

    private fun bind() {
        //on below line we are setting layout manager to our recycler view.
        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        //on below line we are initializing our adapter class.
        val noteRVAdapter = UserListAdapter()
        //on below line we are setting adapter to our recycler view.
        binding.rvUsers.adapter = noteRVAdapter
        //on below line we are initializing our view modal.
        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(UserViewModal::class.java)

        //on below line we are calling all notes methof from our view modal class to observer the changes on list.
        viewModal.allUsers.observe(this, Observer { list ->
            list?.let {
                //on below line we are updating our list.
                noteRVAdapter.updateList(it)
            }
        })
    }

    private fun adListener() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }
}