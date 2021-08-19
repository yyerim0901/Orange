package com.keelim.orange.ui.season.season

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.keelim.orange.common.toast
import com.keelim.orange.data.model.Article
import com.keelim.orange.databinding.FragmentSeasonBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeasonFragment : Fragment() {

  private val viewModel by viewModels<SeasonViewModel>()
  private var _binding: FragmentSeasonBinding? = null
  private val binding get() = _binding!!
  private val args by navArgs<SeasonFragmentArgs>()


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?,
  ): View {
    _binding = FragmentSeasonBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initViews()
    observeData()
    viewModel.fetchData(args.challengeId)
  }

  private fun initViews() = with(binding) {
  }

  override fun onDestroyView() {
    super.onDestroyView()

    _binding = null
  }

  private fun observeData() = viewModel.state.observe(viewLifecycleOwner) {
    when (it) {
      is SeasonState.UnInitialized -> handleUnInitialized()
      is SeasonState.Loading -> handleLoading()
      is SeasonState.Success -> handleSuccess(it.data)
      is SeasonState.Error -> handleError()
    }
  }

  private fun handleUnInitialized() {
    requireActivity().toast("데이터 초기화 중입니다.")
  }

  private fun handleLoading() {
    requireActivity().toast("데이터 초기화 중입니다.")
  }

  private fun handleSuccess(data: List<Article>) {
    requireContext().toast(data.toString())
  }

  private fun handleError() {
    requireActivity().toast("에러가 발생했습니다. 다시 한번 로드해주세요")
  }
}
