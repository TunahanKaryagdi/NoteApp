package com.tunahankaryagdi.noteapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.tunahankaryagdi.noteapp.R
import com.tunahankaryagdi.noteapp.data.model.Note
import com.tunahankaryagdi.noteapp.databinding.FragmentHomeBinding
import com.tunahankaryagdi.noteapp.ui.add.AddFragment
import com.tunahankaryagdi.noteapp.ui.home.adapter.HomeListAdapter
import com.tunahankaryagdi.noteapp.ui.home.adapter.HomeListClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {


    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by activityViewModels()
    private lateinit var adapter : HomeListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener {
            var action = HomeFragmentDirections.actionHomeFragmentToAddFragment()
            findNavController().navigate(action)


        }
        initViews()
        getData()
        observe()

    }

    override fun onResume() {
        super.onResume()
        getData()
        observe()

    }
    private fun initViews() {
        adapter = HomeListAdapter(object : HomeListClickListener{
            override fun onItemFavoriteClick(note: Note) {
                viewModel.update(note)
                adapter.notifyDataSetChanged()
            }


        })
        binding.rvList.adapter = adapter
    }

    private fun observe() {

        viewModel.notes.observe(viewLifecycleOwner, Observer {
            adapter.setList(it)
        })

    }


    fun getData() {
        viewModel.getData()
    }

}