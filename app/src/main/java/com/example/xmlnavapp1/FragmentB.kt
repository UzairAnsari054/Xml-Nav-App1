package com.example.xmlnavapp1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.xmlnavapp1.databinding.FragmentBBinding

class FragmentB : Fragment(), MenuProvider {

    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner)

        val safeArgs: FragmentBArgs by navArgs()
        binding.tvFragB.text = safeArgs.msg

        binding.btnFragB.setOnClickListener {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.option_menu, menu)

        val optionMenuFragmentB = menu.findItem(R.id.option_menu_action_fragmentB)
        if (optionMenuFragmentB != null) {
            optionMenuFragmentB.isVisible = false
        }
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.option_menu_action_fragmentB -> {
                findNavController().navigate(R.id.action_fragmentA_to_fragmentB)
                true
            }

            R.id.option_menu_action_fragmentC -> {
                findNavController().navigate(R.id.fragmentC)
                true
            }

            R.id.option_menu_action_fragmentD -> {
                findNavController().navigate(R.id.fragmentD)
                true
            }

            else -> false
        }
    }
}