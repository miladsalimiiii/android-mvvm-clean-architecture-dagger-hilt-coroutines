package com.milad.diver.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

//@Entity(tableName = "information")
data class Information(
    @SerializedName("_id")  var mId:String?,
    @SerializedName("product")  var mProduct: String?,
    @SerializedName("manufacturer")  var mManufacturer: String?,
    @SerializedName("category") var mCategory: String?,
    @SerializedName("videoTitle")  var mVideoTitle: String?,
    @SerializedName("videoCode") var mVideoCode: String?,
    @SerializedName("dateReleased") var mDateReleased: String?,
    @SerializedName("rating") var mRating: Float?,
    @SerializedName("__v") var mV: Int?
)
