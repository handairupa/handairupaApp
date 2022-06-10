package com.example.handairupaapp.ui.home.menulist.journal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.handairupaapp.R
import com.example.handairupaapp.model.SkinConditionModel

class JournalAdapter(private val listUser: ArrayList<SkinConditionModel>) : RecyclerView.Adapter<JournalAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgItemAvatar: ImageView = itemView.findViewById(R.id.skin_condition_img)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: SkinConditionModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_skin_condition, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listUser[position]
        // TODO: BUAT HOLDER
        /*holder.apply {
            imgItemAvatar.setImageResource(data.skin_condition_image)
            itemView.setOnClickListener {
                onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])
            }
        }*/
    }

    override fun getItemCount(): Int = listUser.size

}
