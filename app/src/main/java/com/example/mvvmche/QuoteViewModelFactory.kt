package com.example.mvvmche

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class QuoteViewModelFactory(private val quoteRepository: QuoteRepository): ViewModelProvider.Factory {

    @Override
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuoteViewModel(quoteRepository) as T
    }

}