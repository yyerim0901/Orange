package com.keelim.orange.ui.profile.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.keelim.orange.R
import com.keelim.orange.common.toast
import com.keelim.orange.data.model.Profile
import com.keelim.orange.data.model.Search
import com.keelim.orange.data.model.Search2
import com.keelim.orange.data.model.entity.Favorite
import com.keelim.orange.databinding.FragmentProfileBinding
import com.keelim.orange.ui.auth.AuthActivity
import com.keelim.orange.ui.feed.SearchRecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class ProfileFragment: Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProfileViewModel by viewModels()
    private val userId by lazy {
        val pref = requireActivity().getSharedPreferences("userId", AppCompatActivity.MODE_PRIVATE)
        return@lazy pref.getInt("userId", -1)
    }
    private val ingChallengeAdapter = SearchRecyclerAdapter(
        clickListener = { _, _ ->

        }
    )

    private val completedChallengeAdapter = SearchRecyclerAdapter(
        clickListener = { _, _ ->

        }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        if(userId==-1){
            startActivity(Intent(requireContext(), AuthActivity::class.java))
            requireActivity().finish()
        }

        viewModel.fetchData(userId)
        observeData()
    }

    private fun observeData() = viewModel.state.observe(viewLifecycleOwner) {
        when (it) {
            is ProfileState.Error -> handleError()
            is ProfileState.Loading -> handleLoading()
            is ProfileState.ProfileSuccess -> handleProfileSuccess(it.data)
            is ProfileState.Success -> handleSuccess(it.completed, it.ing)
            is ProfileState.UnInitialized -> handleUnInitialized()
        }
    }

    private fun handleUnInitialized() {
        requireContext().toast("프로필을 불러오는 중입니다")
    }

    private fun handleSuccess(completed: List<Search2>, ing: List<Search2>) {
        if (ing.isEmpty()) {
            binding.tvIng.visibility = View.VISIBLE
            binding.ingChallenge.visibility = View.INVISIBLE
        } else {
            binding.tvIng.visibility = View.INVISIBLE
            binding.ingChallenge.visibility = View.VISIBLE
            completedChallengeAdapter.submitList(completed.map {
                Search(
                    challengeId = it.challengeId,
                    title = it.challengeTitle,
                    description = it.challengeDescribe
                )
            })
        }

        if (completed.isEmpty()) {
            binding.tvCompleted.visibility = View.VISIBLE
            binding.completeChange.visibility = View.INVISIBLE
        } else {
            binding.tvCompleted.visibility = View.INVISIBLE
            binding.completeChange.visibility = View.VISIBLE
            ingChallengeAdapter.submitList(ing.map {
                Search(
                    challengeId = it.challengeId,
                    title = it.challengeTitle,
                    description = it.challengeDescribe
                )
            })
        }
    }

    private fun handleProfileSuccess(data: Profile) = with(binding) {
        val profile = Profile(
            id = data.id ?: "NaN",
            nickname = data.nickname ?: "NaN",
            email = data.email ?: "NaN",
            imagePath = data.imagePath ?: "",
        )
        profileId.text = "id: ${profile.id}"
        profileEmail.text = "email: ${profile.email}"
        profileNickname.text = "nickname: ${profile.nickname}"
        accountIvProfile.load(R.drawable.project_orange)
    }

    private fun handleLoading() {

    }

    private fun handleError() {
        requireContext().toast("다시 한번 로드 해주세요")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initViews() = with(binding) {
        ingChallenge.adapter = ingChallengeAdapter
        completeChange.adapter = completedChallengeAdapter
        btnHome.setOnClickListener {
            findNavController().navigateUp()
        }

        btnBadge.setOnClickListener {
            findNavController().navigate(R.id.allBadgeFragment)
        }

        btnNoti.setOnClickListener {
            findNavController().navigate(R.id.notificationFragment)
        }

        btnHeart.setOnClickListener {
            findNavController().navigate(R.id.favoriteFragment)
        }
    }
}