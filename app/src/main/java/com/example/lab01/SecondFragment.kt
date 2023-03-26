package com.example.lab01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lab01.databinding.FragmentSecondBinding
import com.example.lab01.model.MyData

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val manager = MyData()

    private fun init() {
        if (arguments != null) {
            val id = this.arguments?.getString("item_id")
            val product = id?.let { manager.getItem(it) }

            if (product != null) {
                binding.itemIdBtn.text = id
                binding.image.setImageResource(product.image)
                binding.productToolbar.title = product.title
            }
        }
        binding.productToolbar.setNavigationOnClickListener { findNavController().popBackStack() }
        binding.switchColor.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.changeColorText.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.black
                    )
                )
            } else {
                binding.changeColorText.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.white
                    )
                )
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this._binding = null
    }
}