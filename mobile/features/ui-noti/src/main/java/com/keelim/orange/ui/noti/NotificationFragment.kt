package com.keelim.orange.ui.noti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.keelim.orange.ui.noti.databinding.FragmentNotificationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment : Fragment() {
    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<NotificationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
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

    private fun observeData() = viewModel.state.observe(viewLifecycleOwner){
        when(it){
            is NotificationState.UnInitialized -> handleUnInitialized()
            is NotificationState.Loading -> handleLoading()
            is NotificationState.Success -> handleSuccess()
            is NotificationState.Error -> handleError()
        }
    }

    private fun initViews() = with(binding) {

    }

    private fun handleUnInitialized(){

    }

    private fun handleLoading(){

    }
    private fun handleSuccess(){

    }

    private fun handleError(){

    }
}