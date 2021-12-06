package com.yaroshevich.fishingapp.recycler

import android.view.View

interface ViewHolderFactory {

    fun create(view: View, viewType: Int): GenericViewHolder

}