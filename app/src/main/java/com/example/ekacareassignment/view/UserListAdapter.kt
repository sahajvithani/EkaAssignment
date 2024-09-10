package com.example.ekacareassignment.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ekacareassignment.R
import com.example.ekacareassignment.model.User

class UserListAdapter :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    //on below line we are creating a variable for our all notes list.
    private val allUsers = ArrayList<User>()

    //on below line we are creating a view holder class.
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //on below line we are creating an initializing all our variables which we have added in layout file.
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvAge: TextView = itemView.findViewById(R.id.tv_age)
        val tvDob: TextView = itemView.findViewById(R.id.tv_dob)
        val tvAddress: TextView = itemView.findViewById(R.id.tv_address)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflating our layout file for each item of recycler view.
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.user_list_item,
            parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //on below line we are setting data to item of recycler view.
        holder.tvName.text = allUsers[position].name
        holder.tvAge.text = allUsers[position].age.toString()
        holder.tvDob.text = allUsers[position].date
        holder.tvAddress.text = allUsers[position].address
    }

    override fun getItemCount(): Int {
        //on below line we are returning our list size.
        return allUsers.size
    }

    //below method is use to update our list of user.
    fun updateList(newList: List<User>) {
        //on below line we are clearing our users array list/
        allUsers.clear()
        //on below line we are adding a new list to our all users list.
        allUsers.addAll(newList)
        //on below line we are calling notify data change method to notify our adapter.
        notifyDataSetChanged()
    }

}