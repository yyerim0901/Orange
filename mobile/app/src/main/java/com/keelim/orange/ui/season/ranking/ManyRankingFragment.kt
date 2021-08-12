package com.keelim.orange.ui.season.ranking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.keelim.orange.data.model.Ranking
import com.keelim.orange.databinding.FragmentManyRankingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ManyRankingFragment(
    private val title: String,
    private val data: List<Ranking>,
) : Fragment() {
    private var _binding: FragmentManyRankingBinding? = null
    private val binding get() = _binding!!
    private val manyRankingAdapter = ManyRankingAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentManyRankingBinding.inflate(inflater, container, false)
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
        titleRanking.text = title
        rankingRecycler.setHasFixedSize(true)
        rankingRecycler.adapter = manyRankingAdapter.apply {
            submitList(data)
        }
    }
}