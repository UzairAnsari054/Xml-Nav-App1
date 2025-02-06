package com.example.xmlnavapp1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlnavapp1.databinding.FragmentCBinding
import com.example.xmlnavapp1.databinding.FragmentDBinding

class FragmentD : Fragment() {

    private var _binding: FragmentDBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycleView.layoutManager = LinearLayoutManager(this.activity)

        val items = listOf(
            User("Uzair1", 1),
            User("Uzair2", 2),
            User("Uzair3", 3),
            User("Uzair4", 4),
            User("Uzair5", 5),
            User("Uzair6", 6),
            User("Uzair7", 7),
            User("Uzair8", 8),
            User("Uzair9", 9),
            User("Uzair10", 10),
            User("Uzair1", 1),
            User("Uzair2", 2),
            User("Uzair3", 3),
            User("Uzair4", 4),
            User("Uzair5", 5),
            User("Uzair6", 6),
            User("Uzair7", 7),
            User("Uzair8", 8),
            User("Uzair9", 9),
            User("Uzair10", 10),
        )

        val adapter = Adapter(items)
        binding.recycleView.adapter = adapter
    }

}