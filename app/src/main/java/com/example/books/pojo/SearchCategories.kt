package com.example.books.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchCategories {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null
}