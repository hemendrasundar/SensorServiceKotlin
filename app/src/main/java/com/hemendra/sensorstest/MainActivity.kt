package com.hemendra.sensorstest

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sManager:SensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        var sensor:Sensor= sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        var listner=object :SensorEventListener{
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

            }

            override fun onSensorChanged(event: SensorEvent?) {

             var svalue:FloatArray? = event?.values

                tv.text =" X-axis: ${svalue?.get(0).toString() }  Y-axis:${svalue?.get(1).toString() }"

            }


        }


        sManager.registerListener(listner,sensor,SensorManager.SENSOR_DELAY_NORMAL)


    }
}