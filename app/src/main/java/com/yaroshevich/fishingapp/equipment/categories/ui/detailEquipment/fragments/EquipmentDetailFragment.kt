package com.yaroshevich.fishingapp.equipment.categories.ui.detailEquipment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.fishingapp.R
import com.yaroshevich.fishingapp.databinding.FragmentEquipmentDetailBinding
import com.yaroshevich.fishingapp.databinding.ItemNameValueBinding
import com.yaroshevich.fishingapp.equipment.categories.ui.detailEquipment.NameValueViewHolder
import com.yaroshevich.fishingapp.equipment.categories.ui.detailEquipment.viewModel.EquipmentDetailViewModel
import com.yaroshevich.fishingapp.model.NameValue
import com.yaroshevich.fishingapp.recycler.BindingRecyclerViewAdapter
import com.yaroshevich.fishingapp.recycler.DefaultViewHolderFactory
import javax.inject.Inject


const val EQUIPMENT_ID = "EQUIPMENT_ID"

abstract class EquipmentDetailFragment : Fragment() {


    lateinit var equipmentDescriptionRecyclerView: RecyclerView

    var arg = -1


    lateinit var equipmentDetailViewModel: EquipmentDetailViewModel

    @Inject
    lateinit var adapter: BindingRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arg = arguments?.getInt(EQUIPMENT_ID) ?: -2

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<FragmentEquipmentDetailBinding>(
            inflater,
            R.layout.fragment_equipment_detail,
            container,
            false
        )

        equipmentDescriptionRecyclerView = binding.recyclerViewDetail

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter(adapter)

        equipmentDescriptionRecyclerView.layoutManager = LinearLayoutManager(context)

        equipmentDescriptionRecyclerView.adapter = adapter

        equipmentDescriptionRecyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                RecyclerView.VERTICAL
            )
        )
    }

    fun <T : Any> convert(item: T, converter: (T) -> List<NameValue>): List<NameValue> {
        return converter(item)
    }

    fun initAdapter(adapter: BindingRecyclerViewAdapter) {

        adapter.holderProperty[NameValue::class] = R.layout.item_name_value

        adapter.factory = DefaultViewHolderFactory { itemView, _ ->

            val binding: ItemNameValueBinding? = DataBindingUtil.bind(itemView)

            NameValueViewHolder(binding!!)

        }
    }

    companion object {

        fun newInstance(
            id: Int,
            fragmentCreator: () -> EquipmentDetailFragment
        ): EquipmentDetailFragment {

            val args = Bundle()

            args.putInt(EQUIPMENT_ID, id)
            val fragment = fragmentCreator()
            fragment.arguments = args


            return fragment
        }
    }

}
