package com.example.handairupaapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductModel (
    val skin_condition_id: Int,
    val product_id: Int,
    val product_name: String,
    val product_image: String,
    val product_description: String,
    val product_instruction: String,
    val product_purchase_link: String,
): Parcelable