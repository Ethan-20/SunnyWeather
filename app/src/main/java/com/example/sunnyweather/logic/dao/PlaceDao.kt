package com.example.sunnyweather.logic.dao

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.sunnyweather.SunnyWeatherApplication
import com.example.sunnyweather.logic.model.Place
import com.example.sunnyweather.logic.network.SunnyWeatherNetwork
import com.google.gson.Gson

/**
 * Created by Ethan On 2022/5/7 21:36
 * God bless my code!
 */
object PlaceDao {

    fun savePlace(place: Place){
        sharedPreferences().edit{
            putString("place",Gson().toJson(place))
        }
    }


    fun getSavedPlace():Place{
        val placeJson = sharedPreferences().getString("place","")
        return Gson().fromJson(placeJson,Place::class.java)
    }

    fun isPlaceSaced() = sharedPreferences().contains("place")

    private fun sharedPreferences() = SunnyWeatherApplication.context.
    getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)

}