package com.milad.diver.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.milad.diver.data.model.Transaction
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTransactionIntoDB(transactionList: List<Transaction>): Completable

    @Query("SELECT * FROM `transaction`")
    fun getTransactionFromDB(): Single<List<Transaction>>

}