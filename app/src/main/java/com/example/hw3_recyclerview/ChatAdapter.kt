package com.example.hw3_recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw3_recyclerview.databinding.HeaderBinding
import com.example.hw3_recyclerview.databinding.LeftMessageBinding
import com.example.hw3_recyclerview.databinding.RightMessageBinding

class ChatAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
    }




    class ViewHolderLeftMessage(private val binding: LeftMessageBinding):
        RecyclerView.ViewHolder(binding.root) {
    }

    class ViewHolderRightMessage(private val binding: RightMessageBinding):
        RecyclerView.ViewHolder(binding.root) {
    }

    class ViewHolderHeader(private val binding: HeaderBinding):
        RecyclerView.ViewHolder(binding.root) {
    }
}