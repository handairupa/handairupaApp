package com.example.handairupaapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    val user_id: String,
    val skin_condition_id: String,
    val user_email: String,
    val user_name: String,
    val user_time: String,
) : Parcelable
