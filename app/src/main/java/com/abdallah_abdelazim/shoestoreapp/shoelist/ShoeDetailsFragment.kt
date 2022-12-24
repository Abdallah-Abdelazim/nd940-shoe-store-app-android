package com.abdallah_abdelazim.shoestoreapp.shoelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.abdallah_abdelazim.shoestoreapp.R
import com.abdallah_abdelazim.shoestoreapp.databinding.FragmentShoeDetailsBinding

class ShoeDetailsFragment : Fragment() {

    private var _binding: FragmentShoeDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ShoesViewModel by activityViewModels()

    private val nameField = MutableLiveData<String>()
    private val companyField = MutableLiveData<String>()
    private val sizeField = MutableLiveData<String>()
    private val descriptionField = MutableLiveData<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBindingVariables()
        attachUiListeners()
    }

    private fun setupBindingVariables() {
        binding.lifecycleOwner = this
        binding.nameField = nameField
        binding.companyField = companyField
        binding.sizeField = sizeField
        binding.descriptionField = descriptionField
    }

    private fun attachUiListeners() {
        binding.btnSave.setOnClickListener {
            saveShoeDetails()
        }
        binding.btnCancel.setOnClickListener {
            navigateToShoeListFragment()
        }
    }

    private fun saveShoeDetails() {
        viewModel.addShoe(
            ShoeUiModel(
                nameField.value ?: "",
                companyField.value ?: "",
                sizeField.value?.toInt() ?: 0,
                descriptionField.value ?: ""
            )
        )
        navigateToShoeListFragment()
    }

    private fun navigateToShoeListFragment() {
        findNavController().navigate(
            ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment()
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}