package com.ghao.apps.poe_economy.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ghao.lib.core.data.Item
import com.ghao.lib.core.repository.PoeEconomyRepository
import com.ghao.lib.core.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PoeEconomyViewModel @Inject constructor(
    private val repository: PoeEconomyRepository
) : ViewModel() {

    var currency: Result<List<Item>> by mutableStateOf(Result.Loading)

    private var _items = MutableStateFlow<Result<List<Item>>>(Result.Loading)
    var items: StateFlow<Result<List<Item>>> = _items

    fun getCurrency() {
        viewModelScope.launch {
            repository.getCurrency()
                .collect { currency = it }
        }
    }

    fun getItems() {
        viewModelScope.launch {
            repository.getItems(this)
                .collect { _items.value = it }
        }
    }

    fun getItemsSingle(): Single<Result<List<Item>>> {
        return repository.getItemsSingle()
    }
}
