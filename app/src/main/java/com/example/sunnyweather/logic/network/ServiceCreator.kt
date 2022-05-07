package com.example.sunnyweather.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Ethan On 2022/5/6 19:20
 * God bless my code!
 */
object ServiceCreator {
    private const val BASE_URL = "https://api.caiyunapp.com/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //构建Retrofit对象后，要得到PlaceService的动态代理对象需要调用Retrofit对象的create()方法
    //接受的对象是Service接口
    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    //用泛型实化，使得一个方法可以接收各种不同的动态代理接口（Service接口）
    inline fun <reified T> create() : T = create(T::class.java)

}