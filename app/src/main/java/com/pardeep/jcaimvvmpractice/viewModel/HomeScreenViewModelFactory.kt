package com.pardeep.jcaimvvmpractice.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pardeep.jcaimvvmpractice.data.dataRepository.AllObjectRepoImpl

class HomeScreenViewModelFactory(
    val allObjectRepoImpl: AllObjectRepoImpl
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeScreenViewModel::class.java)) {
            HomeScreenViewModel(allObjectRepoImpl) as T
        } else {
            throw IllegalArgumentException("Unknown viewModel class")

        }
    }
}