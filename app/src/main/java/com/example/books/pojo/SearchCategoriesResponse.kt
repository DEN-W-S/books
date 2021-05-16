package com.example.books.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchCategoriesResponse {
    @SerializedName("data")
    @Expose
    private var dataCategory: List<SearchCategories?>? = null

    fun getDataCategory(): List<SearchCategories?>? {
        return dataCategory
    }
}