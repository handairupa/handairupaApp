package com.example.handairupaapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.File

@Parcelize
data class SkinConditionModel (
    val skin_condition_name: String,
    val skin_condition_image: Int
) : Parcelable