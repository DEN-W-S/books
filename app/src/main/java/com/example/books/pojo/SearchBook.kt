package com.example.books.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchBook {

    @SerializedName("id")
    @Expose
    var idBooks: Int? = null

    @SerializedName("image_url")
    @Expose
    var imageUrl: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("details_url")
    @Expose
    var dUrl: String? = null

    @SerializedName("new_price")
    @Expose
    var nPrice: String? = null

    @SerializedName("old_price")
    @Expose
    var oPrice: String? = null


    fun getImage(): String? {
        return "https://www.ebooksbilliger.de/$imageUrl"
    }

    fun getPrice(): String? {
        return nPrice
    }
}