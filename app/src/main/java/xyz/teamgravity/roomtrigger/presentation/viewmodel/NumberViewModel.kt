package xyz.teamgravity.roomtrigger.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import xyz.teamgravity.roomtrigger.data.model.NumberModel
import xyz.teamgravity.roomtrigger.data.repository.NumberRepository
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class NumberViewModel @Inject constructor(
    private val repository: NumberRepository,
) : ViewModel() {

    var count: Int by mutableStateOf(0)
        private set

    init {
        observe()
    }

    fun onAddRandomNumber() {
        viewModelScope.launch(NonCancellable) {
            repository.insertNumber(NumberModel(number = Random.nextInt()))
        }
    }

    private fun observe() {
        observeCount()
    }

    private fun observeCount() {
        viewModelScope.launch {
            repository.getCount().collectLatest { count ->
                this@NumberViewModel.count = count?.count ?: 0
            }
        }
    }
}