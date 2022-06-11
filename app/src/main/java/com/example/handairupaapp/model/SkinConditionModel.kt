package com.example.handairupaapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.File

@Parcelize
data class SkinConditionModel (
    val skin_condition_name: String,
    val skin_condition_image: Int
/*    val user_email: String,
    val skin_condition_id: Int,

    val skin_condition_probability: String,
    val skin_condition_notes: String,*/
) : Parcelable