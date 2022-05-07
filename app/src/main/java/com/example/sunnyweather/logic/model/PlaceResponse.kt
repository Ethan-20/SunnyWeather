package com.example.sunnyweather.logic.model


import com.google.gson.annotations.SerializedName

/**
 * Created by Ethan On 2022/5/6 19:06
 * God bless my code!
 * 这个类就是JSON字段和Kotlin之间的映射
 */
data class PlaceResponse(val status: String, val places: List<Place>)

data class Place(
    val name: String,
    val location: Location,
    @SerializedName("formatted_address") val address: String
)

data class Location(val lng: String, val lat: String)