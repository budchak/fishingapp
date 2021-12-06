package com.yaroshevich.fishingapp.cars_search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yaroshevich.fishingapp.R
import com.yaroshevich.fishingapp.databinding.FragmentSearchBinding
import com.yaroshevich.fishingapp.databinding.ItemSearchResultBinding
import com.yaroshevich.fishingapp.recycler.BindingRecyclerViewAdapter
import com.yaroshevich.fishingapp.recycler.DefaultViewHolderFactory
import com.yaroshevich.fishingapp.utils.hideKeyboard

class SearchCarsFragment : Fragment() {

    val s1004 = listOf("1004", "5811", "2822", "ШВ24", "240", "0024")

    val s1003 = listOf("1003", "ШВ29", "5810", "184", "2823", "7003", "7184", "7103", "290", "0029")

    val s2808 = listOf("2808")

    val s2835 = listOf("2835")

    val s1702 = listOf("1702", "4008")

    val s1703 = listOf("1703", "4009", "4099")

    val s1707 = listOf("1707", "4010")

    val s1716 = listOf("1716", "4011", "2826")

    val s1709 = listOf("1709", "4012", "2819", "6019", "6020", "4013", "1841", "ШК032", "ШК033")

    val s1717 = listOf("1717", "6021", "6022", "5010", "5011", "1847", "1842", "4021")

    val s1704 =
        listOf("1704", "6024", "6023", "5012", "5013", "6001", "1844", "1848", "4023", "4024")

    val s1705 =
        listOf("1705", "6025", "6026", "5014", "5015", "1845", "1843", "6002", "4025", "4026")

    val s4214 = listOf("4214", "4007", "4014", "4307")

    val s4210 = listOf("4210")

    val s4209 = listOf("4209")

    val s4208 = listOf("4208")


    val s1000 = listOf("1000", "ШВУ", "413")
    val s1002 = listOf("1002", "ШВ04", "400")
    val s1001 = listOf("1001", "ШВ44", "440")
    val s1006 = listOf("1006")
    val s7201 = listOf("7201")
    val s7203 = listOf("7203")
    val s6119 = listOf("6119", "7204", "6120", "4112", "4113", "3102", "6219")
    val s6121 = listOf("6121", "4421", "6121", "6122")
    val s6124 = listOf("6124", "4424", "6016", "6124", "6123", "5124", "4423")
    val s6125 = listOf("6125", "4425", "6126", "4426")
    val s6221 = listOf("6221", "4521")
    val s6224 = listOf("6224")
    val s6319 = listOf("6319", "4712")
    val s6321 = listOf("6321", "4721")
    val s6323 = listOf("6323", "4723")
    val s6324 = listOf("6324", "4724")
    val s6325 = listOf("6325", "4725")
    val s6326 = listOf("6326", "4726")
    val s4708 = listOf("4708")
    val s4709 = listOf("4709")
    val s4710 = listOf("4710")
    val s4711 = listOf("4711")
    val s4713 = listOf("4713")
    val s4621 = listOf("4621", "7606")
    val s4624 = listOf("4624", "4623")
    val s4625 = listOf("4625", "4626")
    val s7601 = listOf("7601")
    val s7603 = listOf("7603")
    val s7604 = listOf("7604")
    val s7605 = listOf("7605")


    val listOfList = listOf<List<String>>(
        s1000,
        s1001,
        s1002,
        s1004,
        s7605,
        s7604,
        s7603,
        s7601,
        s4625,
        s4624,
        s4621,
        s4713,
        s4711,
        s4710,
        s4709,
        s4708,
        s6326,
        s6325,
        s6324,
        s6323,
        s6321,
        s6319,
        s6224,
        s6221,
        s6125,
        s6124,
        s6121,
        s6119,
        s7203,
        s7201,
        s1006,
        s4208,
        s4209,
        s4210,
        s4214,
        s1705,
        s1704,
        s1717,
        s1709,
        s1716,
        s1707,
        s1703,
        s1702,
        s2835,
        s2808,
        s1003
    )


    val resultList = MutableLiveData<List<String>>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSearchBinding>(
            inflater,
            R.layout.fragment_search,
            container,
            false
        )


        binding.searchButton.setOnClickListener {
            hideKeyboard()
            val text = binding.editTextTextPersonName.text
            if (text != null) {
                listOfList.forEach { list ->

                    val isContain = list.contains(text.toString())

                    if (isContain) {
                        resultList.value = list
                        return@setOnClickListener
                    }
                }
                Toast.makeText(context, "нету $text ", Toast.LENGTH_SHORT).show()
                resultList.value = mutableListOf()
            }
        }


        val adapter = BindingRecyclerViewAdapter()
        adapter.holderProperty[String::class] = R.layout.item_search_result
        adapter.factory = DefaultViewHolderFactory { itemView, _ ->
            val binding: ItemSearchResultBinding? = DataBindingUtil.bind(itemView)
            SearchViewHolder(binding!!)
        }
        resultList.observe(viewLifecycleOwner) {
            adapter.items = it.toMutableList()
        }

        binding.searchResultRv.layoutManager = LinearLayoutManager(context)
        binding.searchResultRv.adapter = adapter
        binding.searchResultRv.addItemDecoration(
            DividerItemDecoration(
                context,
                RecyclerView.VERTICAL
            )
        )


        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}