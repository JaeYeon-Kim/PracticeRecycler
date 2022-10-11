package com.kjy.practicerecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kjy.practicerecycler.databinding.ActivityMainBinding
import com.kjy.practicerecycler.model.*

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val multiAdapter = MultiCustomAdapter()

    val datas = mutableListOf<MultiData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        multiRecycler()
    }

    private fun multiRecycler() {
        binding.animalRv.adapter = multiAdapter
        binding.animalRv.addItemDecoration(VerticalItemDecorator(10))
        binding.animalRv.addItemDecoration(HorizontalItemDecorator(10))

        datas.apply {
            add(MultiData(R.drawable.recycler_image_1, "미어캣", multi_type1))
            add(MultiData(R.drawable.recycler_image_2, "랫서판다", multi_type3))
            add(MultiData(R.drawable.recycler_image_3, "코끼리", multi_type2))
            add(MultiData(R.drawable.recycler_image_4, "아기돼지", multi_type3))
            add(MultiData(R.drawable.recycler_image_5, "코뿔소", multi_type2))
            add(MultiData(R.drawable.recycler_image_6, "아기고양이", multi_type1))
        }
        multiAdapter.datas = datas
        val layoutManager = LinearLayoutManager(this)
        binding.animalRv.layoutManager = layoutManager
        multiAdapter.notifyDataSetChanged()
    }
}