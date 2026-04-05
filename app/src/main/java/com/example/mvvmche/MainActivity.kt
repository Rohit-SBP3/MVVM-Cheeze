package com.example.mvvmche

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmche.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var quoteViewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val quoteDAO = QuoteDatabase.getDatabase(applicationContext).quoteDao()
        val quoteRepository = QuoteRepository(quoteDAO)

        quoteViewModel = ViewModelProvider.create(this, QuoteViewModelFactory(quoteRepository))[QuoteViewModel::class.java]

        quoteViewModel.getQuotes().observe(this, Observer{
            binding.quote = it.toString()
        })

        binding.btnQuote.setOnClickListener {
            val quote = Quote(0,"Life is a dream","Rohit Singh")
            quoteViewModel.insertQuote(quote)
        }

    }
}