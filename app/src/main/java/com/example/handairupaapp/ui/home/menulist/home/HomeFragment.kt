package com.example.handairupaapp.ui.home.menulist.home

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.handairupaapp.databinding.FragmentHomeBinding
import com.example.handairupaapp.ui.camera.CameraActivity
import com.example.handairupaapp.ui.result.ResultActivity
import com.example.handairupaapp.utils.rotateBitmap
import java.io.File

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            cameraXButton.setOnClickListener { startCameraX() }
            uploadButton.setOnClickListener { startUpload() }
            }
        }

    private fun startCameraX() {
        val intent = Intent(activity, CameraActivity::class.java)
            launcherIntentCameraX.launch(intent)
    }

    private val launcherIntentCameraX = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == ResultActivity.CAMERA_X_RESULT) {
            val myFile = it.data?.getSerializableExtra("picture") as File
            val isBackCamera = it.data?.getBooleanExtra("isBackCamera", true) as Boolean

            val getFile = myFile
            val result = rotateBitmap(
                BitmapFactory.decodeFile(getFile.path),
                isBackCamera
            )
            binding.ivPreviewImage.setImageBitmap(result)
        }
    }

    private fun startUpload() {
        val intent = Intent(activity, ResultActivity::class.java)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val CAMERA_X_RESULT = 200
    }
}