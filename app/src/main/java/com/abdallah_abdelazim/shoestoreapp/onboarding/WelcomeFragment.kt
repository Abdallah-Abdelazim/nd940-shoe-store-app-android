package com.abdallah_abdelazim.shoestoreapp.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.abdallah_abdelazim.shoestoreapp.R
import com.abdallah_abdelazim.shoestoreapp.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding: FragmentWelcomeBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_welcome, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachUiListeners()
    }

    private fun attachUiListeners() {
        binding.btnContinue.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = WelcomeFragment()
    }
}