package com.example.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.sunnyweather.logic.Repository
import com.example.sunnyweather.logic.model.Place

/**
 * Created by Ethan On 2022/5/6 21:12
 * God bless my code!
 */
class PlaceViewModel:ViewModel() {
    private val searchLiveData = MutableLiveData<String>()

    //用于对界面上显示的城市数据进行缓存，因为原则上与界面相关的数据都应该放到ViewModel 中
    // 这样可以保证它们在手机屏幕发生旋转的时候不会丢失
    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData){
        query-> Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

    fun savePlace(place:Place) = Repository.savePlace(place)

    fun getSavedPlace() = Repository.getSacedPlace()

    fun isPlaceSaved() = Repository.isPlaceSaved()
}