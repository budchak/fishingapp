package com.yaroshevich.fishingapp.di.modules

import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.yaroshevich.fishingapp.R
import com.yaroshevich.fishingapp.databinding.ItemEquipmentBinding
import com.yaroshevich.fishingapp.equipment.categories.ui.listEquipment.viewHolders.DefaultEquipmentListViewHolder
import com.yaroshevich.fishingapp.equipment.categories.ui.listEquipment.viewModel.EquipmentListViewModel
import com.yaroshevich.fishingapp.equipment.categories.ui.listEquipment.viewModel.ReelViewModel
import com.yaroshevich.fishingapp.equipment.categories.ui.listEquipment.viewModel.RodViewModel
import com.yaroshevich.fishingapp.model.equipment.Reel
import com.yaroshevich.fishingapp.recycler.BindingRecyclerViewAdapter
import com.yaroshevich.fishingapp.recycler.DefaultViewHolderFactory
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
class EquipmentModule(val fragment: Fragment) {


    @Provides
    fun provideFragment(): Fragment {
        return fragment
    }


    @Provides
    @IntoMap
    @StringKey("Rod")
    fun provideRodViewModel(viewModel: RodViewModel): EquipmentListViewModel {
        return viewModel
    }

    @Provides
    @IntoMap
    @StringKey("Reel")
    fun provideReelViewModel(viewModel: ReelViewModel): EquipmentListViewModel {
        return viewModel
    }


    @Provides
    @IntoMap
    @StringKey("Reel")
    fun provideReelAdapter(fragment: Fragment): BindingRecyclerViewAdapter {
        val adapter = BindingRecyclerViewAdapter()

        adapter.holderProperty[Reel::class] = R.layout.item_equipment

        adapter.setOnClickListener { position ->
            Toast.makeText(fragment.context, "item $position click", Toast.LENGTH_SHORT).show()

            findNavController(fragment).navigate(R.id.reelDetailFragment)
        }

        adapter.factory = DefaultViewHolderFactory { itemView, _ ->

            val binding: ItemEquipmentBinding? = DataBindingUtil.bind(itemView)

            DefaultEquipmentListViewHolder(binding!!)

        }
        return adapter
    }


}