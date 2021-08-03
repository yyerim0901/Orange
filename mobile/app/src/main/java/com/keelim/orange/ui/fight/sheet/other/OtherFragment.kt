package com.keelim.orange.ui.fight.sheet.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.keelim.orange.databinding.FragmentOtherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OtherFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentOtherBinding? = null
    private val binding get() = _binding!!
    private val viewModel:OtherViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}