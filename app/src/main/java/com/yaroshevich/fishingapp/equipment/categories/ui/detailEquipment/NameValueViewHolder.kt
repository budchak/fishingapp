package com.yaroshevich.fishingapp.equipment.categories.ui.detailEquipment


import com.yaroshevich.fishingapp.databinding.ItemNameValueBinding
import com.yaroshevich.fishingapp.model.NameValue
import com.yaroshevich.fishingapp.recycler.GenericViewHolder

class NameValueViewHolder(val binding: ItemNameValueBinding) : GenericViewHolder(binding.root) {

    override fun bind(any: Any) {
        super.bind(any)
        binding.nameValue = any as NameValue
        binding.executePendingBindings()
    }
}