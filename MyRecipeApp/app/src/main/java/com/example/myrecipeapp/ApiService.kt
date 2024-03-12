package com.example.myrecipeapp
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{
    @GET
    suspend fun getCategories():CategoriesResponse
    }
}