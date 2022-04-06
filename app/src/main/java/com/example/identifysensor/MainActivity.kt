package com.example.identifysensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var txt: TextView
    private lateinit var mSensorManager:SensorManager
    private lateinit var deviceSensor:List<Sensor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt = findViewById(R.id.tv_identify)

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        deviceSensor = mSensorManager.getSensorList(Sensor.TYPE_ALL)

//        txt.text = deviceSensor.toString()
        printSensorList()
    }

    fun printSensorList(){

        for( sensor in  deviceSensor){

            txt.text = "${txt.text}\n"+ sensor.name
        }
    }
}