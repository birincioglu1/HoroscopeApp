package com.example.horoscopeapp.service

import com.example.horoscopeapp.model.Horoscope
import com.google.gson.GsonBuilder
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class HoroscopeAPIService {
    private val BASE_URL = "https://api.vedicrishiastro.com/"

    //add BasicAuthInterceptor to OkHttp client
    val client = OkHttpClient.Builder()
        .addInterceptor(BasicAuthInterceptor("614350", "639d1164171f84226fefdb4f981db562"))
        .build()
    val gson = GsonBuilder()
        .setLenient()
        .create();

    // add OkHttp client to Retrofit instance
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(HoroscopeAPI::class.java)

    fun getDetail(day: String, month: String,year: String,hour: String,min: String,lat: String,lon: String,tzone:String):  Single<Horoscope> {
        return api.getHoroscope(day,month,year,hour,min,lat,lon,tzone)
    }
}