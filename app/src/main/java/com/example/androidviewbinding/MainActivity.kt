package com.example.androidviewbinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.androidviewbinding.databinding.ActivityMainBinding
import com.example.androidviewbinding.fragments.MainMenuFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer, MainMenuFragment())
            .commit()
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }

//    override fun onData(person: Person?, fragment: Fragment) {
//        val bundle = Bundle()
////        if (person!=null) {
//        bundle.putSerializable(Person::class.java.simpleName, person)
////        }
//        val transaction = this.supportFragmentManager.beginTransaction()
//        fragment.arguments = bundle
//        transaction.add(R.id.fragmentContainer, fragment)
//        transaction.addToBackStack("")
//        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//        transaction.commit()
//    }
//
//    override fun onNone(fragment: Fragment) {
//        val transaction = this.supportFragmentManager.beginTransaction()
//        transaction.add(R.id.fragmentContainer, fragment)
//        transaction.addToBackStack("")
//        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//        transaction.commit()
//    }

}