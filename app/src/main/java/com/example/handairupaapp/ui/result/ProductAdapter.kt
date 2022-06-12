package com.example.handairupaapp.ui.result

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.handairupaapp.databinding.ItemRowProductBinding
import com.example.handairupaapp.model.ProductModel

class ProductAdapter (private val listProduct: ArrayList<ProductModel>) : RecyclerView.Adapter<ProductAdapter.JournalViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class JournalViewHolder(private val binding: ItemRowProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductModel){
            with(binding){
                Glide.with(itemView.context)
                    .load(product.product_image)
                    .apply(RequestOptions().override(100, 100))
                    .into(ivProduct)

                tvProductName.text = product.product_name
                tvProductDescription.text = product.product_description
                tvProductInstruction.text = product.product_instruction
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): JournalViewHolder {
        val binding = ItemRowProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JournalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JournalViewHolder, position: Int) {
        holder.apply {
            bind(listProduct[position])
            itemView.setOnClickListener{
                onItemClickCallback.onItemClicked(listProduct[holder.adapterPosition])
            }
        }
    }

    override fun getItemCount(): Int = listProduct.size

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(product: ProductModel)
    }

}