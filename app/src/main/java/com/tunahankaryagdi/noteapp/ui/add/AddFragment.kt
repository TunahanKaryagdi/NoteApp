package com.tunahankaryagdi.noteapp.ui.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.tunahankaryagdi.noteapp.data.model.Note
import com.tunahankaryagdi.noteapp.databinding.FragmentAddBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFragment  : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private val viewModel : AddViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       binding.btnAdd.setOnClickListener {
            if (binding.title.text!!.isBlank() || binding.content.text!!.isBlank() ){

                Toast.makeText(it.context,"Invalid Input",Toast.LENGTH_SHORT).show()
            }
            else{
                var note = Note(binding.title.text.toString(),binding.content.text.toString())
                viewModel.addNote(note)
                findNavController().navigate(AddFragmentDirections.actionAddFragmentToHomeFragment())

            }
        }


        binding.btnCancel.setOnClickListener {
            findNavController().navigate(AddFragmentDirections.actionAddFragmentToHomeFragment())
        }

    }



}