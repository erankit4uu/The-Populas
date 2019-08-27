package com.ankit.thepopulas.utils

import androidx.room.TypeConverter
import com.ankit.thepopulas.model.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class DBConvertors {


    @TypeConverter
    fun fromString(value: String): List<Result> {
        val listType = object : TypeToken<List<Result>>() {

        }.type
        return Gson().fromJson<List<Result>>(value, listType)
    }

    @TypeConverter
    fun fromList(movieEntities: List<Result>): String {
        return Gson().toJson(movieEntities)
    }

    @TypeConverter
    fun fromStringToInt(value: String): List<Int> {
        val listType = object : TypeToken<List<Int>>() {

        }.type
        return Gson().fromJson<List<Int>>(value, listType)
    }

    @TypeConverter
    fun fromListToInt(movieEntities: List<Int>): String {
        return Gson().toJson(movieEntities)
    }
    @TypeConverter
    fun fromIntToString(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {

        }.type
        return Gson().fromJson<List<String>>(value, listType)
    }

    @TypeConverter
    fun fromListToSting(movieEntities: List<String>): String {
        return Gson().toJson(movieEntities)
    }
}