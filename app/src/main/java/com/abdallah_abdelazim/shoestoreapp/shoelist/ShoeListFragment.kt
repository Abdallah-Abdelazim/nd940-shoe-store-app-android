package com.abdallah_abdelazim.shoestoreapp.shoelist

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.abdallah_abdelazim.shoestoreapp.R
import com.abdallah_abdelazim.shoestoreapp.databinding.FragmentShoeListBinding
import com.abdallah_abdelazim.shoestoreapp.databinding.ItemShoeBinding


class ShoeListFragment : Fragment() {

    private var _binding: FragmentShoeListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ShoesViewModel by activityViewModels()

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
        listenOnViewModelData()
    }

    private fun listenOnViewModelData() {
        viewModel.shoesListLiveData.observe(viewLifecycleOwner) { shoesList ->
            if (binding.llShoeItems.childCount > 0) binding.llShoeItems.removeAllViews()
            val inflater = LayoutInflater.from(requireContext())
            shoesList.forEach { shoe ->
                val itemShoe: ItemShoeBinding = DataBindingUtil.inflate(
                    inflater,
                    R.layout.item_shoe,
                    binding.llShoeItems,
                    false
                )
                itemShoe.shoe = shoe
                binding.llShoeItems.addView(itemShoe.root)
            }
        }
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