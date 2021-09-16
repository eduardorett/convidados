package com.devedu.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.devedu.convidados.databinding.FragmentPresentBinding

import com.devedu.convidados.viewmodel.PresentsViewModel

class PresentsFragment : Fragment() {

    private lateinit var presentsViewModel: PresentsViewModel
    private var _binding: FragmentPresentBinding?=null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    /////////////////////////////////////

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ////////////////////////////////////////
        // INFLATERS
        presentsViewModel =
            ViewModelProvider(this).get(PresentsViewModel::class.java)

        _binding = FragmentPresentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        ////////////////////////////////////////////////////
        // PROCESSOS

        val textView: TextView = binding.textGallery // recebe o text da lista com os id dos presentes
        presentsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
    ///////////////////
    // destroi a viu quando muda de inflate(tela)

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}