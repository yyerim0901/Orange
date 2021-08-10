package com.keelim.orange.ui.profile.badge.all

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.keelim.orange.common.toast
import com.keelim.orange.data.model.Badge
import com.keelim.orange.databinding.FragmentAllBadgeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllBadgeFragment:Fragment() {
    private var _binding :FragmentAllBadgeBinding? = null
    private val binding get() = _binding!!
    private val viewModel:AllBadgeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllBadgeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

      private fun handleUnInitialized() {
        requireActivity().toast("데이터 초기화 중입니다.")
      }
      private fun handleLoading() {
        requireActivity().toast("데이터 초기화 중입니다.")
      }
      private fun handleSuccess(data:List<Badge>) {
        requireContext().toast(data.toString())
      }
      private fun handleError() {
        requireActivity().toast("에러가 발생했습니다. 다시 한번 로드해주세요")
      }
}