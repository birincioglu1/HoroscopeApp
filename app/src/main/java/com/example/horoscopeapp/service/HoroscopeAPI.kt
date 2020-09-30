package com.example.horoscopeapp.service

import com.example.horoscopeapp.model.Horoscope
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.Call
import retrofit2.Callback

interface HoroscopeAPI {

    @FormUrlEncoded
    @POST("v1/astro_details")
    fun getHoroscope(
        @Field("day") day: String?,
        @Field("month") month: String?,
        @Field("year") year: String?,
        @Field("hour") hour: String?,
        @Field("min") password: String?,
        @Field("lat") lat: String?,
        @Field("lon") lon: String?,
        @Field("tzone") tzone: String?

    ): Single<Horoscope>
}