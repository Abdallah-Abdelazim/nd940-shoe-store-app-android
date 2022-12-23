package com.abdallah_abdelazim.shoestoreapp.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.abdallah_abdelazim.shoestoreapp.R
import com.abdallah_abdelazim.shoestoreapp.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    private var _binding: FragmentInstructionsBinding? = null
    private val binding: FragmentInstructionsBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instructions, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachUiListeners()
    }

    private fun attachUiListeners() {
        binding.btnContinue.setOnClickListener {
            findNavController().navigate(
                InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment()
            )
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) = InstructionsFragment()
    }
}