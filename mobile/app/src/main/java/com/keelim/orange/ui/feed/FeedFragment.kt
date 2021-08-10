package com.keelim.orange.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.keelim.orange.R
import com.keelim.orange.common.toast
import com.keelim.orange.data.model.Fight
import com.keelim.orange.data.model.Filter
import com.keelim.orange.databinding.FragmentFeedBinding
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONArray
import org.json.JSONObject
import timber.log.Timber

@AndroidEntryPoint
class FeedFragment : Fragment() {
    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<FeedViewModel>()
    private val searchRecyclerAdapter = SearchRecyclerAdapter{ uid ->
        findNavController().navigate(
            FeedFragmentDirections.actionFeedFragmentToDetailFragment(uid)
        )
    }

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
        initData()
        observeData()
        viewModel.fetchData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initData() {
        val remoteConfig = Firebase.remoteConfig
        remoteConfig.setConfigSettingsAsync(
            remoteConfigSettings {
                minimumFetchIntervalInSeconds = 0
            }
        )
        remoteConfig.fetchAndActivate().addOnCompleteListener {
            if (it.isSuccessful) {
                val quotes = parseJson(remoteConfig.getString("recents"))
                Timber.d("$quotes")
                displayPager(quotes)
            }
        }
    }

    private fun parseJson(json: String): List<Filter> {
        val jsonArray = JSONArray(json)
        var jsonList = emptyList<JSONObject>()
        for (index in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(index)
            jsonObject?.let {
                jsonList = jsonList + it
            }
        }

        return jsonList.map {
            Filter(
                value = it.getString("value")
            )
        }
    }

    private fun displayPager(recents: List<Filter>) {
        with(binding.chips) {
            recents.forEach { element ->
                addView(
                    Chip(requireContext()).apply {
                        text = element.value + ">"
                    }
                )
            }
        }
    }

    private fun initViews() = with(binding) {
        searchRecycler.adapter = searchRecyclerAdapter
        searchBar.setOnClickListener {
            findNavController().navigate(R.id.searchDetailFragment)
        }

        btnNoti.setOnClickListener {
            findNavController().navigate(R.id.notificationFragment)
        }

        btnProfile.setOnClickListener {
            findNavController().navigate(R.id.profileFragment)
        }
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
