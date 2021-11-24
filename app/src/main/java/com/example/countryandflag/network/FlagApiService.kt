package com.example.countryandflag.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()



private const val Base_URL=
    " https://countriesnow.space/api/v0.1/countries/flag/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(Base_URL)
    .build()

interface FlagApiService {
    @GET("images")
    suspend fun getPhotos():Arraydata
}
object FlagApi {
    val retrofitService :FlagApiService by lazy {
        retrofit.create(FlagApiService::class.java)
    }

}