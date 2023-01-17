package com.ghao.apps.poe_economy.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ghao.lib.core.data.Item
import com.ghao.lib.core.data.ItemCategory
import com.ghao.lib.core.data.json.CurrencyDetails
import com.ghao.lib.core.data.json.JsonCurrency
import com.ghao.lib.core.repository.PoeEconomyRepository
import com.ghao.lib.core.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PoeEconomyViewModel @Inject constructor(
    private val repository: PoeEconomyRepository
) : ViewModel() {

    private var _currency = MutableStateFlow<Result<List<Pair<JsonCurrency, CurrencyDetails>>>>(Result.Loading)
    var currency: StateFlow<Result<List<Pair<JsonCurrency, CurrencyDetails>>>> = _currency

    private var _items = MutableStateFlow<Result<List<Item>>>(Result.Loading)
    var items: StateFlow<Result<List<Item>>> = _items

    fun getCurrency(
        league: String,
        type: ItemCategory,
    ) {
        viewModelScope.launch {
            repository.getCurrency(league, type, this)
                .collect { _currency.value = it }
        }
    }

    fun getItems(
        league: String,
        type: ItemCategory,
    ) {
        viewModelScope.launch {
            repository.getItems(league, type, this)
                .collect { _items.value = it }
        }
    }

    fun getCurrencySingle(
        league: String,
        type: ItemCategory,
    ): Single<Result<List<Pair<JsonCurrency, CurrencyDetails>>>> {
        return repository.getCurrencySingle(league, type)
    }
}
