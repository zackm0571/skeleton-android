package com.zackmatthews.skeletonproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val repository = MainRepository()

    private val _data = MutableStateFlow<List<CatModel>>(emptyList())
    val data = _data.asStateFlow()

    init {
        fetchCats()
    }

    private fun fetchCats() {
        viewModelScope.launch {
            repository.getCats(10).collect { response ->
                _data.update { existing ->
                    existing.plus(response)
                }
            }
        }
    }
}