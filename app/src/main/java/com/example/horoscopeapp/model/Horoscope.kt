package com.example.horoscopeapp.model

import com.google.gson.annotations.SerializedName

data class Horoscope(
    @SerializedName("ascendant")
    val ascendant:String?,
    @SerializedName("Varna")
    val varna:String?,
    @SerializedName("Vashya")
    val vashya:String?,
    @SerializedName("Yoni")
    val yoni:String?,
    @SerializedName("Gan")
    val gan:String?,
    @SerializedName("Nadi")
    val nadi:String?,
    @SerializedName("SignLord")
    val signLord:String?,
    @SerializedName("sign")
    val sign:String?,
    @SerializedName("Naksahtra")
    val naksahtra:String?,
    @SerializedName("NaksahtraLord")
    val naksahtraLord:String?,
    @SerializedName("Charan")
    val charan:Int?,
    @SerializedName("Yog")
    val yog:String?,
    @SerializedName("Karan")
    val karan:String?,
    @SerializedName("Tithi")
    val tithi:String?,
    @SerializedName("yunja")
    val yunja:String?,
    @SerializedName("tatva")
    val tatva:String?,
    @SerializedName("name_alphabet")
    val name_alphabet:String?,
    @SerializedName("paya")
    val paya:String?)