package com.yaroshevich.fishingapp.mainScreen.ui.forAdapter

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yaroshevich.fishingapp.databinding.ItemMainPageBinding
import com.yaroshevich.fishingapp.mainScreen.model.AppFunction
import com.yaroshevich.fishingapp.recycler.GenericViewHolder

class AppFunctionViewHolder(val binding: ItemMainPageBinding, val context: Context) :
    GenericViewHolder(binding.root) {

    override fun bind(any: Any) {
        super.bind(any)
        val appFunc = any as AppFunction

        Glide.with(context)
            .load(getImage(appFunc.getIconPath()))
            .apply(RequestOptions().override(300, 300))
            .into(binding.imageView)

        binding.appFunctionTitleTv.text = appFunc.getTitleString()

    }

    private fun getImage(imageName: String?): Int {
        return context.resources.getIdentifier(imageName, "drawable", context.packageName)
    }
}