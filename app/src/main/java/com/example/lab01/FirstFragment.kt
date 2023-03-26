package com.example.lab01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab01.databinding.FragmentFirstBinding
import com.example.lab01.model.Item
import com.example.lab01.model.ItemAdapter
import com.example.lab01.model.ItemManager
import com.example.lab01.model.MyData

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), ItemAdapter.ClickItemListener {

    private var _binding: FragmentFirstBinding? = null
    private val itemsAdapter = ItemAdapter(this)
    private val manager:ItemManager = MyData()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private fun init(){
        val products = manager.getItems()
        itemsAdapter.submitList(products)
        binding.items.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        binding.items.adapter = itemsAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onClick(item: Item) {
        val bundle = Bundle()
        bundle.apply {
            putString("item_id", item.id)
        }
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment2, bundle)
    }
}