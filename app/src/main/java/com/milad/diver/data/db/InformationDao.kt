package com.milad.diver.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.milad.diver.data.model.Information
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface InformationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertInfoIntoDB(information:Information):Completable

    @Query("SELECT * FROM information")
    fun getInfoFromDB():Single<List<Information>>
}