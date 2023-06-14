package ru.chuikov.mymap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.ui_view.ViewProvider
import ru.chuikov.mymap.repository.ItemStorageRepository


//Список дел
//1 подключить карту
//2 Вывести маркеры на карту
class ListOfMarkers : AppCompatActivity() {

    private val MAPKIT_API_KEY = "c9c3ae05-bc11-4cf9-a42d-8466cf91b3b8"
    private lateinit var storage: ItemStorageRepository
    private lateinit var inflater: LayoutInflater
    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey(MAPKIT_API_KEY)
        setContentView(R.layout.activity_list_of_markers)
        inflater = LayoutInflater.from(this)
        storage = ItemStorageRepository(this)


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
//Код для добавления метки
//val marker = inflater.inflate(R.layout.marker,null)
//marker.findViewById<TextView>(R.id.marker_label).text = it.name
//mapView.map.mapObjects.addPlacemark(
//    Point(it.lat,it.lon),
//    ViewProvider(marker,
//    true
//    )
//)