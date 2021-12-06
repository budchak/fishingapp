package com.yaroshevich.fishingapp.cars_search

import com.yaroshevich.fishingapp.databinding.ItemSearchResultBinding
import com.yaroshevich.fishingapp.recycler.GenericViewHolder

class SearchViewHolder(val binding: ItemSearchResultBinding) : GenericViewHolder(binding.root) {

    override fun bind(any: Any) {
        super.bind(any)

        binding.text = any as String
        binding.executePendingBindings()

    }


}