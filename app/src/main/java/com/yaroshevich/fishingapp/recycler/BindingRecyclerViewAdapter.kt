package com.yaroshevich.fishingapp.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject
import kotlin.reflect.KClass

class BindingRecyclerViewAdapter @Inject constructor() : RecyclerView.Adapter<GenericViewHolder>() {


    var items = mutableListOf<Any>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    val holderProperty = mutableMapOf<KClass<out Any>, Int>()

    var factory: ViewHolderFactory = DefaultViewHolderFactory()

    var onItemClickListener: OnItemClickListener? = null

    fun setOnClickListener(onClick: (position: Int) -> Unit) {
        onItemClickListener = object : OnItemClickListener {
            override fun onClick(position: Int) {
                onClick(position)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        val view = inflater.inflate(viewType, parent, false)

        return factory.create(view, viewType)
    }

    override fun getItemViewType(position: Int): Int {

        return holderProperty[items[position]::class]
            ?: throw NotFoundIdException("can't found type ${items[position]::class} for item position $position")

    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {

        holder.bind(items[position])

        holder.itemView.setOnClickListener {
            onItemClickListener?.onClick(position) ?: return@setOnClickListener
        }


    }

    override fun getItemCount(): Int {

        return items.size

    }

}


class NotFoundIdException(message: String) : Exception(message)

interface OnItemClickListener {
    fun onClick(position: Int)


}


