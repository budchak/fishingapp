package com.yaroshevich.fishingapp.equipment.categories.ui.listEquipment.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.fishingapp.App
import com.yaroshevich.fishingapp.R
import com.yaroshevich.fishingapp.databinding.FragmentEquipmentListBinding
import com.yaroshevich.fishingapp.equipment.categories.ui.listEquipment.viewModel.EquipmentListViewModel
import com.yaroshevich.fishingapp.equipment.ui.fragments.EquipmentInjector
import com.yaroshevich.fishingapp.model.equipment.Equipment
import com.yaroshevich.fishingapp.recycler.BindingRecyclerViewAdapter
import javax.inject.Inject

const val EQUIPMENT_TYPE = "EQUIPMENT_TYPE"

class EquipmentListFragment : Fragment() {


    private lateinit var equipmentRecyclerView: RecyclerView

    lateinit var binding: FragmentEquipmentListBinding

    @Inject
    lateinit var injector: EquipmentInjector

    lateinit var equipmentViewModel: EquipmentListViewModel


    lateinit var adapter: BindingRecyclerViewAdapter


    val showEmptyViewIfListEmpty: (equipment: List<Equipment>) -> Unit = { equipment ->
        if (equipment.isEmpty()) showEmptyView(true) else showEmptyView(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.getInstance().getCategoryComponent(this).inject(this)

        initWithEquipmentType()
    }

    private fun initWithEquipmentType() {
        val equipmentType = getBundleString(arguments, EQUIPMENT_TYPE)
        Log.e("что в Bundle", "вот что: $equipmentType")

        equipmentViewModel = injector.getViewModel(equipmentType)
        adapter = injector.getAdapter(equipmentType)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_equipment_list, container, false)

        setBindingVariable()

        equipmentRecyclerView = binding.recyclerView


        equipmentViewModel.getEquipmentList().observe(viewLifecycleOwner, { list ->

            showEmptyViewIfListEmpty(list)

            Log.e("count", "${list.size}")

            adapter.items = list.toMutableList()

        })


        initRecyclerView(adapter)

        return binding.root

    }


    fun getBundleString(bundle: Bundle?, key: String): String {

        return if (bundle != null) {
            bundle.getString(key, "Где строка то? нет ее")
        } else "bundle вообще null"

    }

    fun initRecyclerView(adapter: BindingRecyclerViewAdapter) {

        equipmentRecyclerView.layoutManager = LinearLayoutManager(context)

        equipmentRecyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                RecyclerView.VERTICAL
            )
        )

        equipmentRecyclerView.adapter = adapter

    }

    fun setBindingVariable() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.isListEmpty = false

    }

    private fun showEmptyView(show: Boolean) {

        binding.isListEmpty = show
        Log.e("Show empty view: ", "$show")
        binding.invalidateAll()
    }

    companion object {

        fun newInstance(
            type: String,
            fragmentCreator: (() -> EquipmentListFragment)? = null
        ): EquipmentListFragment {

            val args = Bundle()

            args.putString(EQUIPMENT_TYPE, type)
            val fragment = if (fragmentCreator != null) fragmentCreator()
            else EquipmentListFragment()

            fragment.arguments = args

            return fragment
        }
    }

}