package com.example.xmlnavapp1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlnavapp1.databinding.UserViewBinding

class Adapter(private val users: List<User>) : RecyclerView.Adapter<Adapter.UserViewHolder>() {

    class UserViewHolder(private val binding: UserViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.name.text = user.name
            binding.age.text = user.age.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding: UserViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.user_view,
            parent,
            false
        )
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }
}