package com.example.sem4_act3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import Contact

class MainActivity : AppCompatActivity() {

    var contact = ArrayList<Contact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadContacts()
    }

    private fun loadContacts() {
        contact.add(Contact("Arnold","123456"))
    }
}