package com.keelim.orange.ui.profile.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.keelim.orange.common.toast
import com.keelim.orange.data.model.Favorite
import com.keelim.orange.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {
  private var _binding: FragmentFavoriteBinding? = null
  private val binding get() = _binding!!
  private val favoriteAdapter = FavoriteAdapter(
    clickListener = {
      requireActivity().toast("hello")
    }
  )
  private val viewModel by viewModels<FavoriteViewModel>()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initViews()
    observeData()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  private fun observeData() = viewModel.state.observe(viewLifecycleOwner) {
    when (it) {
      is FavoriteState.UnInitialized -> handleUnInitialized()
      is FavoriteState.Loading -> handleLoading()
      is FavoriteState.Success -> handleSuccess(favorites)
      is FavoriteState.Error -> handleError()
    }
  }

  private fun handleUnInitialized() = with(binding) {

  }

  private fun handleLoading() {
    requireActivity().toast("데이터 초기화 중입니다.")
  }

  private fun handleSuccess(data: List<Favorite>) {
    if (data.isEmpty()) {
      binding.tvNoData.visibility = View.VISIBLE
    } else {
      binding.tvNoData.visibility = View.INVISIBLE
    }
    favoriteAdapter.submitList(data)
  }

  private fun handleError() {
    requireActivity().toast("에러가 발생했습니다. 다시 한번 로드해주세요")
  }

  private fun initViews() = with(binding){
    favoriteRecycler.adapter = favoriteAdapter
    favoriteRecycler.layoutManager = LinearLayoutManager(requireContext())
    handleSuccess(favorites)
  }

  companion object {
    val favorites = listOf(
      Favorite(
        "",
        "23232323232",
        "adkmadkmaksdmaskmdksm",
        23,
        4.5F,
        false,
      ),

      Favorite(
        "",
        "23232323232",
        "adkmadkmaksdmaskmdksm",
        23,
        4.5F,
        false,
      ),

      Favorite(
        "",
        "23232323232",
        "adkmadkmaksdmaskmdksm",
        23,
        4.5F,
        false,
      ),

      Favorite(
        "",
        "23232323232",
        "adkmadkmaksdmaskmdksm",
        23,
        4.5F,
        false,
      ),

      Favorite(
        "",
        "23232323232",
        "adkmadkmaksdmaskmdksm",
        23,
        4.5F,
        false,
      ),

      Favorite(
        "",
        "23232323232",
        "adkmadkmaksdmaskmdksm",
        23,
        4.5F,
        false,
      ),
    )
  }
}
