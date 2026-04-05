package com.example.mvvmche

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// we are passing repository instance in the ViewModel Constructor
// So whenever we have to pass any argument in viewmodel constructor we have to create a factory.
class QuoteViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    fun getQuotes(): LiveData<List<Quote>> {
        return quoteRepository.getQuotes()
    }

    fun insertQuote(quote: Quote){
        viewModelScope.launch {
            quoteRepository.insertQuote(quote)
        }
    }

    fun updateQuote(quote: Quote){
        viewModelScope.launch {
            quoteRepository.updateQuote(quote)
        }
    }

    fun deleteQuote(quote: Quote){
        viewModelScope.launch {
            quoteRepository.deleteQuote(quote)
        }
    }

}