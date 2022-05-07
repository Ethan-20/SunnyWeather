package com.example.sunnyweather.logic

import androidx.lifecycle.liveData
import com.example.sunnyweather.logic.model.Place
import com.example.sunnyweather.logic.model.PlaceResponse
import com.example.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.RuntimeException

/**
 * Created by Ethan On 2022/5/6 20:31
 * God bless my code!
 * 仓库层的主要工作就是判断调用方请求的数据应该是从本地数据源中获取还是从网络数据源中获
 * 取，并将获得的数据返回给调用方。因此，仓库层有点像是一个数据获取与缓存的中间层，在
 * 本地没有缓存数据的情况下就去网络层获取，如果本地已经有缓存了，就直接将缓存数据返回
 */
object Repository {
    //这里的liveData泛型不知道写什么,泛型写的是liveData携带的数据,在这里，返回的emit就是liveData携带的数据
    //这里返回的是结果，result
    //Dispatchers.IO参数 自动让代码块中的代码都在子线程中执行
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException("response status is${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}