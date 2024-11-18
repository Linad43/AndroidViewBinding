package com.example.androidviewbinding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidviewbinding.modal.Person
import com.example.androidviewbinding.databinding.FragmentChatsBinding

class ChatsFragment : Fragment() {
    private var _binding: FragmentChatsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentChatsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val person = arguments?.getSerializable(Person::class.java.simpleName) as Person
        binding.toolbar.title = "Чаты ${person.login}"
        binding.sendBTN.setOnClickListener {
            if(binding.textET.text.isNotEmpty()){
                binding.chatTV.append("${binding.textET.text}\n")
                binding.textET.text.clear()
            }
        }
    }
}