package com.example.mvvmche

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 1, exportSchema = false)
abstract class QuoteDatabase: RoomDatabase() {

    abstract fun quoteDao(): QuoteDAO

    companion object {
        private var Instance: QuoteDatabase? = null
        fun getDatabase(context: Context): QuoteDatabase{
            if(Instance == null){
                synchronized(lock = this) {
                    Instance = Room.databaseBuilder(context,
                        QuoteDatabase::class.java,
                        "quote_database"
                        )
                        .createFromAsset("quote.db")
                        .build()
                }
            }
            return Instance!!
        }
    }

}