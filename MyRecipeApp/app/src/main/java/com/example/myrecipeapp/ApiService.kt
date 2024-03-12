package com.example.myrecipeapp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

/** Build a connection to the base URL and in a format so that we can convert it to an object in Kotlin **/
private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

/** This service allows us to get the categories PHP-file, which will be converted to JSON object **/
val recipeService = retrofit.create(ApiService::class.java)

interface ApiService{
    @GET("categories.php")
    suspend fun getCategories():CategoriesResponse
    }
