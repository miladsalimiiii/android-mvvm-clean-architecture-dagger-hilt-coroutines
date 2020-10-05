package com.milad.diver.data.model

import com.google.gson.annotations.SerializedName

//@Entity(tableName = "information")
data class User(@SerializedName("items")var mItems:List<Item>)
