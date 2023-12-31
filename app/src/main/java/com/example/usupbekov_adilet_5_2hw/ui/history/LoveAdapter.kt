package com.example.usupbekov_adilet_5_2hw.ui.history

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usupbekov_adilet_5_2hw.databinding.ItemHistoryBinding
import com.example.usupbekov_adilet_5_2hw.simpleModels.Love

class LoveAdapter: RecyclerView.Adapter<LoveAdapter.LoveViewHolder>() {

    private val data: ArrayList<Love> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun addList(love: List<Love>) {
        data.clear()
        data.addAll(love)
        notifyDataSetChanged()
    }


    inner class LoveViewHolder(private val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(data: Love) {
            binding.apply {
                tvFirstName.text = data.firstName
                tvSecondName.text = data.secondName
                tvPercentage.text = data.percentage + "%"
            }

        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoveViewHolder {
        return LoveViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: LoveViewHolder, position: Int) {
        holder.bind(data[position])
    }
}
