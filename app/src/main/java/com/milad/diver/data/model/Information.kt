package com.milad.diver.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "information")
data class Information(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) var mId:Int?,
    @SerializedName("balance")  var mBalance: Double?,
    @SerializedName("last_get_time") @ColumnInfo(name = "last_get_time") var mLastGetTime: Long?,
    @SerializedName("response_code") @ColumnInfo(name = "response_code") var mResponseCode: Int?,
    @SerializedName("response_message") @ColumnInfo(name = "response_message") var mResponseMessage: String?,
    @SerializedName("response_value") @ColumnInfo(name = "response_value") var mResponseValue: String?
){
    @SerializedName("transactions") @Ignore var mTransactions: List<Transaction>? = null
}
