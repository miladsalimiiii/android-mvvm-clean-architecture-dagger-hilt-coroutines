package com.milad.diver.data.db

import androidx.room.Dao

@Dao
interface InformationDao {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertInfoIntoDB(information:Information):Completable
//
//    @Query("SELECT * FROM information ORDER BY id ASC LIMIT 1")
//    fun getInfoFromDB():Single<Information>
}