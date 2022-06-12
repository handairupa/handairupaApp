package com.example.handairupaapp.ui.result

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.handairupaapp.R
import com.example.handairupaapp.databinding.ActivityResultBinding
import com.example.handairupaapp.utils.rotateBitmap
import java.io.File

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    companion object {
        const val CAMERA_X_RESULT = 200
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)/*
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launcherIntentCameraX.launch(intent)*/
    }

/*    private val launcherIntentCameraX = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == CAMERA_X_RESULT) {
            val myFile = it.data?.getSerializableExtra("picture") as File
            val isBackCamera = it.data?.getBooleanExtra("isBackCamera", true) as Boolean

            val getFile = myFile
            val result = rotateBitmap(
                BitmapFactory.decodeFile(getFile.path),
                isBackCamera
            )
            binding.ivPreviewImage.setImageBitmap(result)
        }
    }*/
}