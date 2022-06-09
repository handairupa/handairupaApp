package com.example.handairupaapp.ui.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.handairupaapp.R
import com.example.handairupaapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    companion object {
        const val CAMERA_X_RESULT = 200
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
    }
}