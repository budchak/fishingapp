package com.yaroshevich.fishingapp.recycler

import android.view.View

open class DefaultViewHolderFactory(
    val viewHolderCreator: (View, Int) -> GenericViewHolder = { view: View, _: Int ->
        GenericViewHolder(view)
    }
) : ViewHolderFactory {

    override fun create(view: View, viewType: Int): GenericViewHolder {

        return viewHolderCreator(view, viewType)
    }
}