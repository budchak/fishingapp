package com.yaroshevich.fishingapp.equipment.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.yaroshevich.fishingapp.App
import com.yaroshevich.fishingapp.R
import com.yaroshevich.fishingapp.databinding.FragmentEquipmentCategoriesBinding
import com.yaroshevich.fishingapp.di.modules.EquipmentModule
import com.yaroshevich.fishingapp.equipment.ui.EquipmentCategoriesStateAdapter

import com.yaroshevich.fishingapp.equipment.ui.viewModel.EquipmentCategoriesViewModel
import com.yaroshevich.fishingapp.utils.hideKeyboard
import javax.inject.Inject

class EquipmentCategoriesFragment : Fragment() {

    lateinit var binding: FragmentEquipmentCategoriesBinding

    private lateinit var categoriesTabLayout: TabLayout

    private lateinit var equipmentListViewPager: ViewPager2

    @Inject
    lateinit var categoriesStateAdapter: EquipmentCategoriesStateAdapter

    @Inject
    lateinit var equipmentCategoriesViewModel: EquipmentCategoriesViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        inject(this)

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_equipment_categories,
            container,
            false
        )

        initView(binding)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        equipmentListViewPager.adapter = categoriesStateAdapter

        TabLayoutMediator(categoriesTabLayout, equipmentListViewPager) { tab, position ->

            tab.text = equipmentCategoriesViewModel.getTitle(position)

        }.attach()

    }

    private fun inject(fragment: EquipmentCategoriesFragment) {
        App.getInstance().appComponent
            .equipmentComponentBuilder()
            .equipmentCategoryModule(EquipmentModule(fragment))
            .build()
            .inject(fragment)
    }

    private fun initView(binding: FragmentEquipmentCategoriesBinding) {

        categoriesTabLayout = binding.tabLayout

        equipmentListViewPager = binding.viewPager

        val startSearchMenuItemVisibility = true

        var searchMenuItemVisibility = startSearchMenuItemVisibility


        binding.toolbarSearch.setOnMenuItemClickListener {
            return@setOnMenuItemClickListener when (it.itemId) {
                R.id.search -> {
                    searchMenuItemVisibility = changeSearchViewVisibilityWithAnimation(searchMenuItemVisibility)
                    true
                }
                R.id.add -> {

                    true
                }
                else -> false
            }
        }


        binding.root.setOnClickListener {
            binding.editTextTextPersonName.clearFocus()
            hideKeyboard()
        }

    }

    private fun changeSearchViewVisibilityWithAnimation(click: Boolean): Boolean {

        return if (click) {

            binding.sceneShowSearchViewRoot.transitionToEnd()

            false

        } else {

            binding.sceneShowSearchViewRoot.transitionToStart()

            true

        }
    }

}