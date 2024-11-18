package com.example.androidviewbinding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import com.example.androidviewbinding.service.GridViewAdapter
import com.example.androidviewbinding.modal.GridViewModel
import com.example.androidviewbinding.modal.Person
import com.example.androidviewbinding.R
import com.example.androidviewbinding.databinding.FragmentMainMenuBinding

class MainMenuFragment : Fragment(R.layout.fragment_main_menu), FragmentResultListener {
    private var person: Person? = null
    private var _binding: FragmentMainMenuBinding? = null
    private val binding get() = _binding!!
    private val items = listOf(
        GridViewModel("Home", R.drawable.image_home),
        GridViewModel("LogIn", R.drawable.image_login),
        GridViewModel("Profile", R.drawable.image_person),
        GridViewModel("Chats", R.drawable.image_chat),
        GridViewModel("Settings", R.drawable.image_settings),
        GridViewModel("LogOut", R.drawable.image_logout)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = GridViewAdapter(items, requireContext())
        person = arguments?.getSerializable(Person::class.java.simpleName) as Person?
        binding.gridViewGV.adapter = adapter
        binding.gridViewGV.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                when (items[position].name) {
                    "Home" -> fragmentManager
                        ?.beginTransaction()
                        ?.add(R.id.fragmentContainer, HomeFragment())
                        ?.addToBackStack("")
                        ?.commit()

                    "LogIn" -> {
                        val fragment = LogInFragment()
                        fragmentManager?.setFragmentResultListener(
                            Person::class.java.simpleName,
                            fragment,
                            this
                        )
                        fragmentManager
                            ?.beginTransaction()
                            ?.add(R.id.fragmentContainer, fragment)
                            ?.addToBackStack("")
                            ?.commit()
                    }

                    "Profile" -> {
                        if (person != null) {
                            val fragment = ProfileFragment()
                            val bundle = Bundle()
                            bundle.putSerializable(Person::class.java.simpleName, person)
                            fragment.arguments = bundle
                            fragmentManager
                                ?.setFragmentResultListener(
                                    Person::class.java.simpleName,
                                    fragment,
                                    this
                                )
                            fragmentManager
                                ?.beginTransaction()
                                ?.add(R.id.fragmentContainer, fragment)
                                ?.addToBackStack("")
                                ?.commit()
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "Вы не зарегистрировались!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    "Chats" -> {
                        if (person != null) {
                            val fragment = ChatsFragment()
                            val bundle = Bundle()
                            bundle.putSerializable(Person::class.java.simpleName, person)
                            fragment.arguments = bundle
                            fragmentManager
                                ?.beginTransaction()
                                ?.add(R.id.fragmentContainer, fragment)
                                ?.addToBackStack("")
                                ?.commit()
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "Вы не зарегистрировались!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    "Settings" -> fragmentManager
                        ?.beginTransaction()
                        ?.add(R.id.fragmentContainer, SettingsFragment())
                        ?.addToBackStack("")
                        ?.commit()

                    "LogOut" -> {
                        if (person != null) {
                            Toast.makeText(
                                requireContext(),
                                "Вы вышли",
                                Toast.LENGTH_SHORT
                            ).show()
                            person = null
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "Вы не зарегистрировались!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onFragmentResult(requestKey: String, result: Bundle) {
        person = result.getSerializable(Person::class.java.simpleName) as Person
        Toast.makeText(requireContext(), person!!.login, Toast.LENGTH_SHORT).show()
    }
}