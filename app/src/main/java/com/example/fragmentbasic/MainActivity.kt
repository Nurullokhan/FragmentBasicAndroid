package com.example.fragmentbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentbasic.databinding.ActivityMainBinding
import com.example.fragmentbasic.fragments.FirstFragment
import com.example.fragmentbasic.interfacec.MyInterfaces

class MainActivity : AppCompatActivity(), MyInterfaces {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = FirstFragment()
        supportFragmentManager.beginTransaction().add(R.id.container, firstFragment, "first").commit()

//        binding.send.setOnClickListener {
//            firstFragment.showData("Nurullo")
//        }

        binding.send.setOnClickListener {
            setResult("Nurik")
        }
    }

    override fun setResult(string: String) {
        val firstFragment = supportFragmentManager.findFragmentByTag("first") as FirstFragment
        firstFragment.setResult(string)
    }
}