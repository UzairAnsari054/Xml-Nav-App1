package com.example.xmlnavapp1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.xmlnavapp1.databinding.FragmentABinding
import com.example.xmlnavapp1.databinding.FragmentCBinding


class FragmentC : Fragment() {

    private var _binding: FragmentCBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SaveStateHandleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.counter.observe(this.requireActivity()){
            binding.tvCounter.text = "$it"
        }

        binding.btnCounter.setOnClickListener {
            viewModel.updateCounter()
        }
    }

}