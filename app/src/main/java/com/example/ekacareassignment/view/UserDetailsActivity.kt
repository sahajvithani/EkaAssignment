package com.example.ekacareassignment.view

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.ekacareassignment.viewmodel.UserViewModal
import com.example.ekacareassignment.databinding.ActivityUserDetailsBinding
import com.example.ekacareassignment.model.User
import java.util.Calendar

class UserDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailsBinding
    private lateinit var viewModal: UserViewModal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(UserViewModal::class.java)

        adListener()
    }

    private fun adListener() {
        //on below line we are adding click listner to our save button.
        binding.btnSave.setOnClickListener {
            //on below line we are getting title and desc from edit text.
            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString()
            val dob = binding.etDob.text.toString()
            val address = binding.etAddress.text.toString()

            if (name.isNotEmpty() && age.isNotEmpty()) {
                //if the string is not empty we are calling a add note method to add data to our room database.
                viewModal.addUser(User(0, name, age.toInt(), dob, address))
                Toast.makeText(this, "Successfully Added", Toast.LENGTH_LONG).show()

                binding.etName.setText("")
                binding.etAge.setText("")
                binding.etDob.setText("")
                binding.etAddress.setText("")
            } else {
                Toast.makeText(this, "Please add all data", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnList.setOnClickListener {
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
        }

        binding.etDob.setOnClickListener{
            showDatePickerDialog()
        }
    }

    private fun showDatePickerDialog() {
        // Get current date
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Create DatePickerDialog
        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                // The callback when the date is selected
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                binding.etDob.setText(selectedDate)
            },
            year,
            month,
            day
        )

        // Show the dialog
        datePickerDialog.show()
    }
}