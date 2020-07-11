package com.milad.diver.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.milad.diver.data.model.Information
import com.milad.diver.data.model.Transaction

@Database(entities = [Information::class,Transaction::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun informationDao(): InformationDao
    abstract fun transactionDao():TransactionDao

    companion object {

        private var instance:AppDatabase?=null

        fun getInstance(context: Context):AppDatabase = (instance?: kotlin.synchronized(this){

            buildDatabase(context)}) as AppDatabase

        private fun buildDatabase(context: Context): RoomDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "diver.db").build()
        }
    }
}