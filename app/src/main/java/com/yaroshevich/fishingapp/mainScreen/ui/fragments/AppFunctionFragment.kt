package com.yaroshevich.fishingapp.mainScreen.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.fishingapp.App
import com.yaroshevich.fishingapp.R
import com.yaroshevich.fishingapp.databinding.FragmentAppFunctionBinding
import com.yaroshevich.fishingapp.di.modules.MainScreenModule
import com.yaroshevich.fishingapp.mainScreen.ui.viewmodel.AppFunctionViewModel
import com.yaroshevich.fishingapp.recycler.BindingRecyclerViewAdapter
import com.yaroshevich.fishingapp.recycler.GridSpacingItemDecorator
import javax.inject.Inject
import javax.inject.Named

class AppFunctionFragment : Fragment() {

    @Inject
    @Named("appFunctionAdapter")
    lateinit var adapter: BindingRecyclerViewAdapter

    @Inject
    lateinit var viewModel: AppFunctionViewModel

    @Inject
    lateinit var itemDecorator: GridSpacingItemDecorator

    @Inject
    lateinit var edgeEffectFactory: RecyclerView.EdgeEffectFactory


    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.getInstance()
            .appComponent
            .plus(MainScreenModule(this))
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentAppFunctionBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_app_function, container, false)

        binding.lifecycleOwner = this

        initRecyclerView(binding.appFunctionRecyclerView)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAppFunction().observe(viewLifecycleOwner) {
            adapter.items = it.toMutableList()
        }

    }

    private fun initRecyclerView(recyclerView: RecyclerView) {

        recyclerView.adapter = adapter

        recyclerView.addItemDecoration(itemDecorator)

        recyclerView.edgeEffectFactory = edgeEffectFactory
    }

}

