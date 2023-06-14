package ru.chuikov.mymap

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import com.yandex.mapkit.geometry.Point;

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}
//Код для вызова другого окна
//val intent = Intent(this,AddMarker::class.java)
//startActivity(intent)

// User location info
// https://github.com/yandex/mapkit-android-demo/blob/master/mapkit-demo/src/main/java/com/yandex/mapkitdemo/UserLocationActivity.java

// User routing Info
// https://github.com/yandex/mapkit-android-demo/blob/master/mapkit-demo/src/full/java/com/yandex/mapkitdemo/DrivingActivity.java