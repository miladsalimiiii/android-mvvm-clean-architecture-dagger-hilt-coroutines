package com.milad.diver.data.model

import com.google.gson.annotations.SerializedName

data class BadgeCounts(@SerializedName("bronze")var mBronze:Int,
                       @SerializedName("silver")var mSilver:Int,
                       @SerializedName("gold")var mGold:Int)