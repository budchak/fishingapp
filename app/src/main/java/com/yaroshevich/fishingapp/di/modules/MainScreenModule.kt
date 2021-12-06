package com.yaroshevich.fishingapp.di.modules

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yaroshevich.fishingapp.R
import com.yaroshevich.fishingapp.mainScreen.model.AppFunctionTest
import com.yaroshevich.fishingapp.mainScreen.ui.forAdapter.MainScreenViewHolderFactory
import com.yaroshevich.fishingapp.recycler.BindingRecyclerViewAdapter
import com.yaroshevich.fishingapp.recycler.GridSpacingItemDecorator
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [BindsMainScreenModule::class])
class MainScreenModule(val fragment: Fragment) {

    @Provides
    fun provideContext(): Context {
        return fragment.requireContext()
    }

    @Named("appFunctionAdapter")
    @Provides
    fun provideAppFunctionAdapter(
        viewHolderFactory: MainScreenViewHolderFactory
    ): BindingRecyclerViewAdapter {

        val adapter = BindingRecyclerViewAdapter()

        adapter.holderProperty[AppFunctionTest::class] = R.layout.item_main_page

        adapter.setOnClickListener { position ->

            Toast.makeText(fragment.context, "item $position click", Toast.LENGTH_SHORT).show()
            when (position) {
                0 -> fragment.findNavController().navigate(R.id.equipmentCategoriesFragment)
                1 -> fragment.findNavController().navigate(R.id.createFishingFragment)
                else -> {
                }
            }

        }

        adapter.factory = viewHolderFactory
        return adapter
    }

    @Provides
    fun provideItemDecorator(): GridSpacingItemDecorator {
        return GridSpacingItemDecorator(8, 8)
    }


}
