package com.example.apilearn.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    var scoreTeamA: Int = 0
    var scoreTeamB: Int = 0
    val currnetNumber: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val currnetBoolean: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun increas(): Int {
        scoreTeamA++
        return scoreTeamA
    }
}