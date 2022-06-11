package com.example.handairupaapp.ui.home.menulist.journal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.handairupaapp.databinding.CardSkinConditionBinding
import com.example.handairupaapp.model.SkinConditionModel

class JournalAdapter(private val listJournal: ArrayList<SkinConditionModel>) : RecyclerView.Adapter<JournalAdapter.JournalViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class JournalViewHolder(private val binding: CardSkinConditionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(journal: SkinConditionModel){
            with(binding){
                Glide.with(itemView.context)
                    .load(journal.skin_condition_image)
                    .apply(RequestOptions().override(100, 100))
                    .into(ivSkinCondition)

                tvName.text = journal.skin_condition_name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): JournalViewHolder {
        val binding = CardSkinConditionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JournalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JournalViewHolder, position: Int) {
        holder.apply {
            bind(listJournal[position])
            itemView.setOnClickListener{
                onItemClickCallback.onItemClicked(listJournal[holder.adapterPosition])
            }
        }
    }

    override fun getItemCount(): Int = listJournal.size

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(journal: SkinConditionModel)
    }

}
