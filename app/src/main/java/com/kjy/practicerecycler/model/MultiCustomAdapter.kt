package com.kjy.practicerecycler.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.practicerecycler.databinding.AnimalItem1Binding
import com.kjy.practicerecycler.databinding.AnimalItem2Binding
import com.kjy.practicerecycler.databinding.AnimalItem3Binding

class MultiCustomAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var datas = mutableListOf<MultiData>()

    // viewType = viewType에 의해 구분되어 들어오는 값
    // 각 viewType에 조건문을 주어서 ViewHolder 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            multi_type1 -> {
                val binding =
                    AnimalItem1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return MultiHolder1(binding)

            }
            multi_type2 -> {
                val binding =
                    AnimalItem2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return MultiHolder2(binding)
            }
            else -> {
                val binding = AnimalItem3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return MultiHolder3(binding)
            }
        }
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (datas[position].type) {
            multi_type1 -> {
                val animalData = datas[position]
                (holder as MultiHolder1).bind(animalData)
            }

            multi_type2 -> {
                val animalData = datas[position]
                (holder as MultiHolder2).bind(animalData)

            }

            multi_type3 -> {
                val animalData = datas[position]
                (holder as MultiHolder3).bind(animalData)

            }
        }

    }

    // onCreateViewHolder() 호출 전 getItemViewType을 먼저 호출하며 리턴 값이 넘겨짐
    override fun getItemViewType(position: Int): Int {
        return datas[position].type
    }

    override fun getItemCount(): Int {
        return datas.size
    }
}

class MultiHolder1(val binding : AnimalItem1Binding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MultiData) {
        Glide.with(itemView)
            .load(item.imageView)
            .into(binding.ivItem1)
        binding.tvItem1.text = item.animalName
    }

}

class MultiHolder2(val binding : AnimalItem2Binding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MultiData) {
        Glide.with(itemView)
            .load(item.imageView)
            .into(binding.ivItem2)
        binding.tvItem2.text = item.animalName
    }

}

class MultiHolder3(val binding: AnimalItem3Binding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MultiData) {
        Glide.with(itemView)
            .load(item.imageView)
            .into(binding.ivItem3)
        binding.tvItem3.text = item.animalName
    }

}