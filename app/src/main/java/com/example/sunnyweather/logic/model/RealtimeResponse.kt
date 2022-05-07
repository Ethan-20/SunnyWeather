package com.example.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Ethan On 2022/5/7 16:21
 * God bless my code!
 */
data class RealtimeResponse(
    val result: Result,
    val status: String
) {
    data class Result(
        val realtime: Realtime
    )

    data class Realtime(
        val temperature: Float,
        val skycon: String,
        @SerializedName("air_quality")
        val airQuality: AirQuality
    )

    data class AirQuality(
        val aqi: AQI
    )

    data class AQI(
        val chn: Float
    )
}