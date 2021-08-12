package com.keelim.orange.ui.season.ranking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.keelim.orange.common.toast
import com.keelim.orange.data.model.Ranking
import com.keelim.orange.databinding.FragmentRankingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RankingFragment : Fragment() {
  private var _binding: FragmentRankingBinding? = null
  private val binding get() = _binding!!

  private val viewModel by viewModels<RankingViewModel>()
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentRankingBinding.inflate(inflater, container, false)
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
      is RankingState.UnInitialized -> handleUnInitialized()
      is RankingState.Loading -> handleLoading()
      is RankingState.Success -> handleSuccess(
        it.data,
      )
      is RankingState.Error -> handleError()
    }
  }

  private fun handleUnInitialized() {
    requireActivity().toast("데이터 초기화 중입니다.")
  }

  private fun handleLoading() {
    requireActivity().toast("데이터 초기화 중입니다.")
  }

  private fun handleSuccess(
    data1: List<Ranking>
  ) {
    initViews(
      data1
    )
  }

  private fun handleError() {
    requireActivity().toast("에러가 발생했습니다. 다시 한번 로드해주세요")
  }

  inner class ViewPager2Adapter(
    data1:List<Ranking>,
    data2:List<Ranking>,
 ) : FragmentStateAdapter(this) {
    private val fragments = listOf<Fragment>(
      ManyRankingFragment(
        "포인트 랭킹",
        data1
      ),
      ManyRankingFragment(
        "기간 랭킹",
        data2
      ),
    )

    override fun getItemCount(): Int {
      return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
      return fragments[position]
    }
  }

  private fun initViews(
    data1:List<Ranking>
  ) = with(binding) {
    viewpager.adapter = ViewPager2Adapter(
      data1, data1
    )
    btnNext.setOnClickListener {
      TabLayoutMediator(tabIndicator, viewpager) { tab, position ->
      }.attach()
    }
  }
}