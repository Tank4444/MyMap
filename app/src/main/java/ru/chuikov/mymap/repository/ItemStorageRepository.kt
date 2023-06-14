package ru.chuikov.mymap.repository

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class ItemStorageRepository(ctx:Context) {
    private val APP_PREF = "fordata"
    private val APP_PREF_LIST = "listofMarkers"
    private val gson: Gson = Gson()
    var ListType = object : TypeToken<ArrayList<Marker>>(){}.type

    private lateinit var share:SharedPreferences

    init {
        share = ctx.getSharedPreferences(APP_PREF,Context.MODE_PRIVATE)
    }

    data class Marker(
        val name:String,
        val lat:Double,
        val lon:Double
    )

    fun getListOfMarkers():List<Marker>{
        return gson.fromJson(share.getString(APP_PREF_LIST,"[]"), ListType)
    }

    fun addMarkerToList(m:Marker){
        val l = getListOfMarkers().toMutableList()
        l.add(m)
        setListOfMarkers(l)
    }

    fun removeMarkerFromList(m:Marker){
        val l = getListOfMarkers().toMutableList()
        l.filter {
            !(it.name == m.name && it.lat == m.lat && it.lon == m.lon)
        }
        setListOfMarkers(l)
    }

    private fun setListOfMarkers(list:List<Marker>){
        val editor = share.edit()
        editor.putString(APP_PREF_LIST, gson.toJson(list,ListType))
        editor.apply()
        editor.commit()
    }
}