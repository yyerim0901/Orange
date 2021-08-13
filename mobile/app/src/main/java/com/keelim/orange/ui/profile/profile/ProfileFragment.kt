package com.keelim.orange.ui.profile.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.keelim.orange.R
import com.keelim.orange.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment: Fragment() {
    private var _binding:FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initViews() = with(binding){
        btnHome.setOnClickListener {
            findNavController().navigateUp()
        }

        btnBadge.setOnClickListener {
            findNavController().navigate(R.id.allBadgeFragment)
        }
        
        btnNoti.setOnClickListener { 
            findNavController().navigate(R.id.notificationFragment)
        }

        btnHeart.setOnClickListener {
            findNavController().navigate(R.id.favoriteFragment)
        }
    }
}