package com.abdallah_abdelazim.shoestoreapp.shoelist

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.abdallah_abdelazim.shoestoreapp.R
import com.abdallah_abdelazim.shoestoreapp.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {

    private var _binding: FragmentShoeListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachUiListeners()
    }

    private fun attachUiListeners() {
        binding.fabAddShoe.setOnClickListener {
            navigateToShoeDetailsFragment()
        }
    }

    private fun navigateToShoeDetailsFragment() {
        findNavController().navigate(
            ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment()
        )
    }

    private fun logout() {
        findNavController().navigate(
            ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment()
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_shoe_list, menu);
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_logout -> {
            logout()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}