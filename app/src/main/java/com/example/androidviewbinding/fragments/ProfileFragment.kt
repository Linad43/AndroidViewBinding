package com.example.androidviewbinding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.androidviewbinding.modal.Person
import com.example.androidviewbinding.databinding.FragmentProfileBinding
import com.example.androidviewbinding.common.CommonFun

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val person = arguments?.getSerializable(Person::class.java.simpleName) as Person
        val listET = arrayListOf(
            binding.loginET,
//            binding.newPasswordET,
            binding.oldPasswordET
        )
        binding.loginET.setText(person.login)
        binding.oldPasswordET.text.clear()
        binding.newPasswordET.text.clear()
        binding.applyBTN.setOnClickListener {
            if (CommonFun.allETIsNotEmpty(listET)) {
                if (person.password == binding.oldPasswordET.text.toString()) {
                    val newPerson = Person(
                        binding.loginET.text.toString(),
                        binding.newPasswordET.text.toString()
                    )
                    val bundle = Bundle()
                    bundle.putSerializable(Person::class.java.simpleName, newPerson)
                    fragmentManager
                        ?.setFragmentResult(
                            Person::class.java.simpleName,
                            bundle
                        )
                    fragmentManager?.popBackStack()
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Неверный пароль",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}