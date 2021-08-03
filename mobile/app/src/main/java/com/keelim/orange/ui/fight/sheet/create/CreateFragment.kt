package com.keelim.orange.ui.fight.sheet.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.keelim.orange.databinding.FragmentCreateBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateFragment:BottomSheetDialogFragment() {
    private var _binding:FragmentCreateBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CreateViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateBinding.inflate(inflater, container, false)
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

    private fun initViews() = with(binding) {
        btnUpload.setOnClickListener {
            val title = title.text.toString()
            val description = description.text.toString()

            if (title.isEmpty() or description.isEmpty()) return@setOnClickListener

            viewModel.upload(title, description)
        }
    }
}