package com.keelim.orange.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnNextLayout
import androidx.fragment.app.Fragment
import com.keelim.orange.data.model.samples
import com.keelim.orange.databinding.FragmentSearchDetailBinding
import com.keelim.orange.utils.SpringAddItemAnimator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchDetailFragment: Fragment() {
    private var _binding: FragmentSearchDetailBinding? = null
    private val binding get() = _binding!!
    private val searchAdapter = SearchAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchDetailBinding.inflate(inflater, container, false)
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
        searchResults.adapter = searchAdapter.apply {
        }
        searchResults.apply {
            setHasFixedSize(true)
            itemAnimator = SpringAddItemAnimator()
            adapter = searchAdapter.apply {
                doOnNextLayout {
                    submitList(samples)
                }
            }
        }
    }
}