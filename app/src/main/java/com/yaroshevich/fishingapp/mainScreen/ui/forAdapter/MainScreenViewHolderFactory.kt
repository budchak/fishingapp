package com.yaroshevich.fishingapp.mainScreen.ui.forAdapter

import android.content.Context
import android.view.View
import androidx.databinding.DataBindingUtil
import com.yaroshevich.fishingapp.databinding.ItemMainPageBinding
import com.yaroshevich.fishingapp.recycler.GenericViewHolder
import com.yaroshevich.fishingapp.recycler.ViewHolderFactory
import javax.inject.Inject

class MainScreenViewHolderFactory @Inject constructor(private val context: Context) :
    ViewHolderFactory {

    override fun create(view: View, viewType: Int): GenericViewHolder {

        val binding: ItemMainPageBinding? = DataBindingUtil.bind(view)

        return AppFunctionViewHolder(binding!!, context)
    }
}