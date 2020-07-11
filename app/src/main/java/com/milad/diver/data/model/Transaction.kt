package com.milad.diver.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "transaction")
data class Transaction(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) var id :Int,
    @SerializedName("about_me") @ColumnInfo(name = "about_me") var mAboutMe: String,
    @SerializedName("amount") @ColumnInfo(name = "amount")var mAmount: Double,
    @SerializedName("avatar") @ColumnInfo(name = "avatar")var mAvatar: String,
    @SerializedName("first_chat") @ColumnInfo(name = "first_chat")var mFirstChat: String,
    @SerializedName("first_name") @ColumnInfo(name = "first_name")var mFirstName: String,
    @SerializedName("status") @ColumnInfo(name = "status")var mStatus: Int,
    @SerializedName("tran_id") @ColumnInfo(name = "tran_id")var mTranId: Int,
    @SerializedName("unread_chat_count") @ColumnInfo(name = "unread_chat_count")var mUnreadChatCount: Int,
    @SerializedName("update_time") @ColumnInfo(name = "update_time")var mUpdateTime: Long,
    @SerializedName("user_id") @ColumnInfo(name = "user_id")var mUserId: Int,
    @SerializedName("view_type") @ColumnInfo(name = "view_type")var mViewType: Int,
    @SerializedName("last_name") @ColumnInfo(name = "last_name")var mLastName: String
)