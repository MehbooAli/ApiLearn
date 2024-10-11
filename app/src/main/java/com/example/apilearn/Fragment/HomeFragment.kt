package com.example.apilearn.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apilearn.ViewModel.ScoreViewModel
import com.example.apilearn.databinding.HomeScreenBinding


class HomeFragment : Fragment() {
    private lateinit var homeScreenBinding: HomeScreenBinding
    private lateinit var viewModel: ScoreViewModel
    var teamC: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeScreenBinding = HomeScreenBinding.inflate(inflater, container, false)
        homeScreenBinding.btnTeamA.setOnClickListener {
            homeScreenBinding.tvTeamA.text = viewModel.increas().toString()
            Log.d("homeFragment", "get data: ${viewModel.increas()}")
        }

        viewModel = ViewModelProvider(this)[ScoreViewModel::class.java]
        IncrementTeamB()

        viewModel.currnetNumber.observe(viewLifecycleOwner, Observer {
            homeScreenBinding.tvTeamB.text = it.toString()
        })

        // Team C
        homeScreenBinding.btnTeamC.setOnClickListener {
            homeScreenBinding.tvTeamC.text = IncrementTeamC().toString()
        }

        return homeScreenBinding.root
    }

//    override fun onResume() {
//        super.onResume()
//        homeScreenBinding.tvTeamA.text = viewModel.increas().toString()
//
//
//    }

    private fun IncrementTeamC(): Int {
        teamC++
        return teamC
    }

    private fun IncrementTeamB() {
        homeScreenBinding.btnTeamB.setOnClickListener {
            viewModel.currnetNumber.value = ++viewModel.scoreTeamB
            Log.d("homeFragment", "Team b Data: ${viewModel.scoreTeamB}")
        }
    }
}

