package com.yaroshevich.fishingapp.equipment.ui.viewModel

import com.yaroshevich.fishingapp.equipment.model.CategoryEnum
import javax.inject.Inject

class EquipmentCategoriesViewModel @Inject constructor() {

    private val categories = mutableListOf(
        EquipmentCategory(CategoryEnum.ALL, "Комплекты"),
        EquipmentCategory(CategoryEnum.ROD, "Удилища"),
        EquipmentCategory(CategoryEnum.REEL, "Катушки"),
        EquipmentCategory(CategoryEnum.BAIT, "Приманки"),
        EquipmentCategory(CategoryEnum.OTHER, "Оснастка")
    )

    fun getTitle(position: Int): String {
        return categories[position].categoryTitle
    }

    fun getCategory(position: Int): CategoryEnum {
        return categories[position].category
    }

    fun getCategoriesCount() = categories.size
}

class EquipmentCategory(
    val category: CategoryEnum,
    val categoryTitle: String,
    val iconSrc: String = ""
)