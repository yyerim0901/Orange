package com.keelim.orange.ui.profile.badge.all

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnNextLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.keelim.orange.common.toast
import com.keelim.orange.data.model.Badge
import com.keelim.orange.databinding.FragmentAllBadgeBinding
import com.keelim.orange.utils.SpringAddItemAnimator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllBadgeFragment:Fragment() {
    private var _binding: FragmentAllBadgeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AllBadgeViewModel by viewModels()
    private val badgeAdapter = BadgeAdapter {
        requireActivity().toast("뱃지 입니다")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentAllBadgeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeData()
        viewModel.fetchData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeData() = viewModel.state.observe(viewLifecycleOwner) {
        when (it) {
            is BadgeState.UnInitialized -> handleUnInitialized()
            is BadgeState.Loading -> handleLoading()
            is BadgeState.Success -> handleSuccess(it.data)
            is BadgeState.Error -> handleError()
        }
    }

    private fun handleUnInitialized() = with(binding) {

    }

    private fun handleLoading() {
        requireActivity().toast("데이터 초기화 중입니다.")
    }

    private fun handleSuccess(data: List<Badge>) {
        requireContext().toast(data.toString())
        badgeAdapter.submitList(data)
    }

    private fun handleError() {
        requireActivity().toast("에러가 발생했습니다. 다시 한번 로드해주세요")
    }

    private fun initViews() = with(binding){
        badgeRecycler.adapter = badgeAdapter
        badgeRecycler.layoutManager = LinearLayoutManager(requireContext())
        badgeRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            itemAnimator = SpringAddItemAnimator()
            adapter = badgeAdapter.apply {
                doOnNextLayout {
                    submitList(emptyList())
                }
            }
        }
    }
}