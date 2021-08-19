package com.keelim.orange.ui.season.sheet.create

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import coil.load
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.keelim.orange.common.toast
import com.keelim.orange.databinding.FragmentCreateBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateFragment:BottomSheetDialogFragment() {
    private var _binding: FragmentCreateBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CreateViewModel by viewModels()
    private lateinit var bitMap: Bitmap
    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val resultCode = result.resultCode
            val data = result.data

            when (resultCode) {
                Activity.RESULT_OK -> {
                    //Image Uri will not be null for RESULT_OK
                    val fileUri = data?.data!!
//                    mProfileUri = fileUri
//                    imgProfile.setImageURI(fileUri)
                    //TODO
                    binding.camera.load(fileUri)


                    bitMap = if (Build.VERSION.SDK_INT < 28) {
                        MediaStore.Images.Media.getBitmap(
                            requireContext().contentResolver,
                            fileUri
                        )
                    } else {
                        ImageDecoder.decodeBitmap(ImageDecoder.createSource(requireContext().contentResolver,
                            fileUri))
                    }
                }

                ImagePicker.RESULT_ERROR -> {
                    requireActivity().toast(ImagePicker.getError(data))
                }
                else -> {
                    requireActivity().toast("Task Cancelled")
                }
            }
        }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCreateBinding.inflate(inflater, container, false)
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
        btnUpload.setOnClickListener {
            val title = title.text.toString()
            val description = description.text.toString()

            if (title.isEmpty() or description.isEmpty()) return@setOnClickListener

            viewModel.upload(title, description, bitMap)
        }

        camera.setOnClickListener {
            cameraChoose()
        }
    }

    private fun cameraChoose() {
        ImagePicker.with(this)
            .compress(1024)         //Final image size will be less than 1 MB(Optional)
            .maxResultSize(1080,
                1080)  //Final image resolution will be less than 1080 x 1080(Optional)
            .createIntent { intent ->
                startForProfileImageResult.launch(intent)
            }
    }
}