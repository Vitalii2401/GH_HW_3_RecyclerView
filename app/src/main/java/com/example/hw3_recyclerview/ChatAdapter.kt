package com.example.hw3_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw3_recyclerview.databinding.HeaderBinding
import com.example.hw3_recyclerview.databinding.LeftMessageBinding
import com.example.hw3_recyclerview.databinding.RightMessageBinding
import java.util.ArrayList

class ChatAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var messages: ArrayList<Messages> = arrayListOf(Messages(0, "0"))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            1 -> {
                val binding = LeftMessageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ViewHolderLeftMessage(binding)
            }
            2 -> {
                val binding = RightMessageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ViewHolderRightMessage(binding)
            }
            else -> {
                val binding = HeaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ViewHolderHeader(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ViewHolderLeftMessage -> holder.bind(messages[position])
            is ViewHolderRightMessage -> holder.bind(messages[position])
            is ViewHolderHeader -> holder.bind()
        }
    }

    override fun getItemCount() = messages.size

    override fun getItemViewType(position: Int): Int {
        return when (messages[position].userId) {
            1 -> VIEW_TYPE_MESSAGE_LEFT
            2 -> VIEW_TYPE_MESSAGE_RIGHT
            else -> {CHAT_HEADER}
        }
    }

    companion object {
        const val CHAT_HEADER = 0
        const val VIEW_TYPE_MESSAGE_LEFT = 1
        const val VIEW_TYPE_MESSAGE_RIGHT = 2
    }




    class ViewHolderLeftMessage(private val binding: LeftMessageBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: Messages){
            binding.leftMessageTextView.text = user.message
        }
    }

    class ViewHolderRightMessage(private val binding: RightMessageBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: Messages){
            binding.rightMessageTextView.text = user.message
        }
    }

    class ViewHolderHeader(private val binding: HeaderBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind() = with(binding) {
            userFirstButton.text = "User 1: " + countMessageFirstUser
            userSecondButton.text = "User 2: " + countMessageSecondUser

            userFirstButton.setOnClickListener {
                user = 1
                userFirstButton.setBackgroundResource(R.color.design_default_color_primary_variant)
                userSecondButton.setBackgroundResource(android.R.color.darker_gray)
            }

            userSecondButton.setOnClickListener {
                user = 2
                userFirstButton.setBackgroundResource(android.R.color.darker_gray)
                userSecondButton.setBackgroundResource(R.color.design_default_color_primary_variant)
            }
        }
    }

    fun addMessage(msg: Messages){
        messages.add(msg)
        notifyDataSetChanged()
    }
}