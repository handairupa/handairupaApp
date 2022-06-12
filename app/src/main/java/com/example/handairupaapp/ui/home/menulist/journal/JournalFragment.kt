package com.example.handairupaapp.ui.home.menulist.journal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.handairupaapp.R
import com.example.handairupaapp.databinding.FragmentJournalBinding
import com.example.handairupaapp.model.SkinConditionModel
import java.util.*


class JournalFragment : Fragment() {
    private var _binding: FragmentJournalBinding? = null
    private val binding get() = _binding!!
    private val list = ArrayList<SkinConditionModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJournalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.addAll(listJournals())
        showCardSkinCondition()

    }

    private fun listJournals(): ArrayList<SkinConditionModel>{
        val dataName = resources.getStringArray(R.array.user_name_ph)
        val dataImage = resources.obtainTypedArray(R.array.user_journey_ph)

        val listJournal = ArrayList<SkinConditionModel>()
        listJournal.clear()

        for (i in dataName.indices) {
            val journal = SkinConditionModel(
                dataName[i],
                dataImage.getResourceId(i, -1))
            listJournal.add(journal)
        }
        dataImage.recycle()
        return listJournal
    }

    private fun showCardSkinCondition() {
        val journalAdapter = JournalAdapter(list)

        binding.rvSkinJournal.setHasFixedSize(true)
        binding.rvSkinJournal.layoutManager = GridLayoutManager(activity, 3)
        binding.rvSkinJournal.adapter = journalAdapter

        journalAdapter.setOnItemClickCallback(object : JournalAdapter.OnItemClickCallback {
            override fun onItemClicked(journal: SkinConditionModel) {
                showSelectedImage(journal)
            }
        })
    }

    private fun showSelectedImage(journal: SkinConditionModel){
        Toast.makeText(activity, "Clicked.", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}