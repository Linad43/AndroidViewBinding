package com.example.androidviewbinding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidviewbinding.modal.Person
import com.example.androidviewbinding.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val person = arguments?.getSerializable(Person::class.java.simpleName) as Person?
        if (person != null) {
            binding.textTV.text = "Приветствуем ${person.login}"
        } else {
            binding.textTV.text = "Вы не зарегистрировались"
        }
    }

}