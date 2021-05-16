package com.example.books.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchBookResponse {

    @SerializedName("data")
    @Expose
    private var data: List<SearchBook?>? = null

    fun getData(): List<SearchBook?>? {
        return data
    }
}