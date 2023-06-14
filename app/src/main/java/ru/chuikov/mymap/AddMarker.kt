package ru.chuikov.mymap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraListener
import com.yandex.mapkit.map.InputListener
import com.yandex.mapkit.map.Map
import com.yandex.mapkit.map.MapObjectTapListener
import com.yandex.mapkit.mapview.MapView
import ru.chuikov.mymap.repository.ItemStorageRepository

//Список дел
//1 подключить карту
//2 добавление маркера на карту
class AddMarker : AppCompatActivity() {

    private val MAPKIT_API_KEY = "c9c3ae05-bc11-4cf9-a42d-8466cf91b3b8"
    private lateinit var storage:ItemStorageRepository

    private lateinit var mapView: MapView

    val inputListener:InputListener = object:InputListener{
        override fun onMapTap(p0: Map, p1: Point) {
            //Код для обработчика нажатия на карту
        }
        override fun onMapLongTap(p0: Map, p1: Point) {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey(MAPKIT_API_KEY)
        setContentView(R.layout.activity_add_marker)
        storage = ItemStorageRepository(this)
        //Код кодить тут


    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
    }
}