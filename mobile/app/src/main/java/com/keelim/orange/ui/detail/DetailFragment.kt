package com.keelim.orange.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import com.keelim.orange.common.toast
import com.keelim.orange.data.response.DetailResponse
import com.keelim.orange.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

  companion object {
    fun newInstance() = DetailFragment()
  }
  private val viewModel by viewModels<DetailViewModel>()
  private var _binding: FragmentDetailBinding? = null
  private val binding get() = _binding!!
  private val args by navArgs<DetailFragmentArgs>()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentDetailBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initViews()
    observeData()
    viewModel.fetchData(args.uid)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  private fun observeData() = viewModel.state.observe(viewLifecycleOwner) {
    when (it) {
      is DetailState.UnInitialized -> handleUnInitialized()
      is DetailState.Loading -> handleLoading()
      is DetailState.Success -> handleSuccess(it.data)
      is DetailState.Error -> handleError()
    }
  }

  private fun handleUnInitialized() {
    requireActivity().toast("데이터 초기화 중입니다.")
  }

  private fun handleLoading() {
    requireActivity().toast("데이터 초기화 중입니다.")
  }

  private fun handleSuccess(data: DetailResponse) {
    with(binding){
      mainImg.load(data.img_url)
      detailTitle.text = data.title
      detailDesc.text = data.description

      btnJoin.setOnClickListener {

      }
    }
  }

  private fun handleError() {
    requireActivity().toast("에러가 발생했습니다. 다시 한번 로드해주세요")
  }

  private fun initViews() = with(binding){
    root.background = args.color.toDrawable()
  }
}
