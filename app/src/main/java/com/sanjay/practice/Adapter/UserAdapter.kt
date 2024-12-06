package com.sanjay.practice.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanjay.practice.Models.User
import com.sanjay.practice.Utils.GlideImageLoader
import com.sanjay.practice.databinding.ItemUserBinding

class UserAdapter(
    val users: MutableList<User>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user, position)
    }

    override fun getItemCount(): Int = users.size

    fun updateData(newUsers: List<User>) {
        users.clear()
        users.addAll(newUsers)
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: ItemUserBinding,
        private val listener: OnItemClickListener
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User, position: Int) {
            binding.tvName.text = "${user.first_name} ${user.last_name}"
            GlideImageLoader.loadCircularImage(
                itemView.context,
                user.avatar,
                binding.ivAvatar
            )

            binding.root.setOnClickListener {
                listener.onItemClick(position)
            }
        }
    }
}

interface OnItemClickListener {
    fun onItemClick(position: Int)
}
