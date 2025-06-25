package com.pardeep.jcaimvvmpractice.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pardeep.jcaimvvmpractice.UiState
import com.pardeep.jcaimvvmpractice.data.apiDataModels.ApiDataModelItem
import com.pardeep.jcaimvvmpractice.data.dataRepository.AllObjectRepoImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    val allObjectRepoImpl: AllObjectRepoImpl
) : ViewModel() {

    private var _textFieldData = MutableStateFlow("")
    val textFieldData: StateFlow<String> = _textFieldData


    private var _uiState = MutableStateFlow<UiState<List<ApiDataModelItem>>>(UiState.onLoading)
    val uiState: StateFlow<UiState<List<ApiDataModelItem>>> = _uiState

    init {
        fetchData()
    }

    fun fetchData(newValue: String? = null) {
        viewModelScope.launch {
            _textFieldData.debounce(300).collect { query ->
                _uiState.value = UiState.onLoading
                try {
                    val result = if (query.isEmpty()) {
                        allObjectRepoImpl.getAllListObject()
                    } else {
                        listOf(allObjectRepoImpl.getListOfDataByID(query.toInt()))
                    }
                    _uiState.value = UiState.onSuccess(result)
                } catch (e: Exception) {
                    Log.e("HomeScreenViewModel", "fetchData: error occured :${e.message}")
                    _uiState.value = UiState.onError("Error: ${e.localizedMessage}")
                }
            }

        }
    }

    fun updateTextField(newValue: String) {
        _textFieldData.value = newValue
        fetchData(newValue)
    }


}