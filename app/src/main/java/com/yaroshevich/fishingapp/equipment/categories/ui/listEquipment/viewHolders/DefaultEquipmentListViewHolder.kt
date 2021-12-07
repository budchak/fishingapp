package com.yaroshevich.fishingapp.equipment.categories.ui.listEquipment.viewHolders

import com.yaroshevich.fishingapp.databinding.ItemEquipmentBinding
import com.yaroshevich.fishingapp.equipment.categories.ui.listEquipment.viewModel.EquipmentPreview
import com.yaroshevich.fishingapp.model.equipment.Equipment
import com.yaroshevich.fishingapp.recycler.GenericViewHolder

class DefaultEquipmentListViewHolder(val binding: ItemEquipmentBinding) :
    GenericViewHolder(binding.root) {

    override fun bind(any: Any) {
        super.bind(any)

        binding.equipment = any as EquipmentPreview
        binding.executePendingBindings()

    }


}