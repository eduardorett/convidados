package com.devedu.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.devedu.convidados.databinding.FragmentAbsentBinding

import com.devedu.convidados.viewmodel.AbsentViewModel

class AbsentFragment : Fragment() {

    private lateinit var absentViewModel: AbsentViewModel
    private var _binding: FragmentAbsentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ///////////////////////////////////////
        absentViewModel =
            ViewModelProvider(this).get(AbsentViewModel::class.java) //ARMAZENA E CONECTA A VIEWMODEL COM A VIEW

        _binding = FragmentAbsentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSlideshow
        absentViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}