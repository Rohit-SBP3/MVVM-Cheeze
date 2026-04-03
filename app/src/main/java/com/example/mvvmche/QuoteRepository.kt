package com.example.mvvmche

import androidx.lifecycle.LiveData

class QuoteRepository(private val quoteDAO: QuoteDAO){

    fun getQuotes(): LiveData<List<Quote>>{
        return quoteDAO.getQuotes()
    }

    suspend fun insertQuote(quote: Quote){
        quoteDAO.insertQuote(quote)
    }

    suspend fun deleteQuote(quote: Quote){
        quoteDAO.deleteQuote(quote)
    }

    suspend fun updateQuote(quote: Quote){
        quoteDAO.updateQuote(quote)
    }

}