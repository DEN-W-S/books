package com.example.books.api

import com.example.books.pojo.SearchBookResponse
import com.example.books.pojo.SearchCategoriesResponse
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("api/request.php?cmd=getArticles")
    fun getSearchBook(): Observable<SearchBookResponse?>?

    @GET("api/request.php?cmd=getCategories")
    fun getSearchCategories(): Observable<SearchCategoriesResponse?>?
    

    companion object {


        private var BASE_URL = "https://www.ebooksbilliger.de/"

        fun getInstance() : ApiService? {

                val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                return retrofit.create(ApiService::class.java)


        }

    }

}