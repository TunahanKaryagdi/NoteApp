package com.tunahankaryagdi.noteapp.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.tunahankaryagdi.noteapp.R
import com.tunahankaryagdi.noteapp.databinding.FragmentFavoriteBinding
import com.tunahankaryagdi.noteapp.databinding.FragmentHomeBinding
import com.tunahankaryagdi.noteapp.ui.favorite.adapter.FavoriteListAdapter
import com.tunahankaryagdi.noteapp.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private val viewModel: FavoriteViewModel by activityViewModels()
    private lateinit var adapter: FavoriteListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(layoutInflater)
        initViews()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getFavoriteData()
        observeData()

    }

    private fun observeData() {
        viewModel.favoriteNotes.observe(viewLifecycleOwner, Observer {
            adapter.setList(it)
        })
    }

    private fun initViews() {
        adapter = FavoriteListAdapter()
        binding.rvFavoriteList.adapter = adapter
    }


    private fun getFavoriteData(){
        viewModel.getFavoriteNotes()
    }
}