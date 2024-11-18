package com.example.androidviewbinding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidviewbinding.modal.Person
import com.example.androidviewbinding.databinding.FragmentLogInBinding
import com.example.androidviewbinding.common.CommonFun

class LogInFragment : Fragment() {

    private var _binding: FragmentLogInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listET = arrayListOf(
            binding.loginET,
            binding.passwordET
        )
        var person: Person? = null
        binding.loginBTN.setOnClickListener {
            if (CommonFun.allETIsNotEmpty(listET)) {
                person = Person(
                    binding.loginET.text.toString(),
                    binding.passwordET.text.toString()
                )
                val bundle = Bundle()
                bundle.putSerializable(Person::class.java.simpleName, person)
                fragmentManager
                    ?.setFragmentResult(Person::class.java.simpleName, bundle)
                fragmentManager?.popBackStack()
            }
        }
    }
}