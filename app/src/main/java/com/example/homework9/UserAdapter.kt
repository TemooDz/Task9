package com.example.homework9

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework9.db.UserEntity

class UserAdapter(private val items: Array<UserEntity>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.firstName)
        val lastName = view.findViewById<TextView>(R.id.lastName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = items[position].firstName
        holder.lastName.text = items[position].lastName
    }

    override fun getItemCount() = items.size
}