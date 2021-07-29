package com.keelim.features.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.keelim.features.ui.feed.databinding.FragmentFeedBinding
import com.keelim.orange.common.toast
import com.keelim.orange.data.model.Fight
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment : Fragment() {
  private var _binding: FragmentFeedBinding? = null
  private val binding get() = _binding!!
  private val viewModel by viewModels<FeedViewModel>()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentFeedBinding.inflate(inflater, container, false)
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

  private fun initViews() = with(binding) {
  }

  private fun observeData() = viewModel.state.observe(viewLifecycleOwner) {
    when (it) {
      is FeedState.UnInitialized -> handleUnInitialized()
      is FeedState.Loading -> handleLoading()
      is FeedState.Success -> handleSuccess(it.data)
      is FeedState.Error -> handleError()
    }
  }

  private fun handleUnInitialized() {
    requireActivity().toast("데이터 초기화 중입니다.")
  }

  private fun handleLoading() {
    requireActivity().toast("데이터 초기화 중입니다.")
  }

  private fun handleSuccess(data: List<Fight>) {
  }

  private fun handleError() {
    requireActivity().toast("에러가 발생했습니다. 다시 한번 로드해주세요")
  }

  companion object {
    fun newInstance() = FeedFragment()
  }
}
