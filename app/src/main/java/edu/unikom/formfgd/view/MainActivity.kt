package edu.unikom.formfgd.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import edu.unikom.formfgd.R
import edu.unikom.formfgd.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.Fragment_container, InputFragment())
            .commit()
        }
    }