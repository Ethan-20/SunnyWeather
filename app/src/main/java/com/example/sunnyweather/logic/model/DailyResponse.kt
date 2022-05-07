package com.example.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by Ethan On 2022/5/7 16:31
 * God bless my code!
 */
data class DailyResponse(
    val result: Result,
    val status: String
) {
    data class Result(
        val daily: Daily
    )

    data class Daily(val temperature: List<Temperature>,
         val skycon: List<Skycon>,
         @SerializedName("life_index")
         val life_index: LifeIndex
    )

   data class Skycon(val value:String,val date:Date)

    data class Temperature (val max:Float,val min:Float)

    data class LifeIndex(
        val coldRisk: List<LifeDescription>,
        val carWashing: List<LifeDescription>,
        val ultraviolet: List<LifeDescription>,
        val dressing: List<LifeDescription>

    )
    data class LifeDescription(val desc:String)
}

