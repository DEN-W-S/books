package com.example.books.pojo

import android.icu.text.CaseMap
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchBook {

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
}