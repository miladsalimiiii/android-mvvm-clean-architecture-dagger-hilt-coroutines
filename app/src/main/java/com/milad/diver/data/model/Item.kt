package com.milad.diver.data.model

import com.google.gson.annotations.SerializedName

data class Item(@SerializedName("account_id")var mAccount_id:Int,
                @SerializedName("is_employee")var mIsEmployee:Boolean,
                @SerializedName("last_modified_date")var mLastModifiedDate:Long,
                @SerializedName("last_access_date")var mLastAccessDate:Long,
                @SerializedName("reputation_change_year")var mReputationChangeYear:Int,
                @SerializedName("reputation_change_quarter")var mReputationChangeQuarter:Int,
                @SerializedName("reputation_change_month")var mReputationChangeMonth:Int,
                @SerializedName("reputation_change_week")var mReputationChangeWeek:Int,
                @SerializedName("reputation_change_day")var mReputationChangeDay:Int,
                @SerializedName("reputation")var mReputation:Int,
                @SerializedName("creation_date")var mCreationDate:Long,
                @SerializedName("user_type")var mUserType:String,
                @SerializedName("user_id")var mUserId:Int,
                @SerializedName("accept_rate")var mAcceptRate:Int,
                @SerializedName("location")var mLocation:String,
                @SerializedName("website_url")var mWebsiteUrl:String,
                @SerializedName("link")var mLink:String,
                @SerializedName("profile_image")var mProfileImage:String,
                @SerializedName("display_name")var mDisplayName:String
)