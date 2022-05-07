package com.example.sunnyweather.logic.network

import com.example.sunnyweather.SunnyWeatherApplication
import com.example.sunnyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Ethan On 2022/5/6 19:10
 * God bless my code!
 */
interface PlaceService {

    //这里的value是相对路径，根路径在外面设置
    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
    //返回值是Call类型，通过泛型来指定服务器响应的数据类型应该转换成<PlaceResponse>类型
}