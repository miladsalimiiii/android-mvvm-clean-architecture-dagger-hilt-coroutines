package com.milad.diver.ui.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.milad.diver.R

class ContactsFragment : Fragment() {

    private lateinit var contactsViewModel: ContactsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        contactsViewModel =
                ViewModelProviders.of(this).get(ContactsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_contacts, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        return root
    }
}