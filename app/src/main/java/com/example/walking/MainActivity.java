package com.example.walking;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorDataListener {
    private SensorProvider provider;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tvResult);
        provider = SensorProvider.get(this);
        if (provider.contains(Sensor.TYPE_ACCELEROMETER)) {
            provider.register(this, Sensor.TYPE_ACCELEROMETER, 2099999900);
        }
        if (provider.contains(Sensor.TYPE_GYROSCOPE)) {
            provider.register(this, Sensor.TYPE_GYROSCOPE, 2000000000);
        }
        if (provider.contains(Sensor.TYPE_STEP_COUNTER)) {
            provider.register(this, Sensor.TYPE_STEP_COUNTER, 2000000000);
        }
    }

    @Override
    public void onDestroy() {
        provider.unregister();
        super.onDestroy();
    }

    @Override
    public void onSensorChanged(SensorData data) {
//        Log.e("%d %.2f %.2f %.2f".format(data.timestamp, data.x, data.y, data.z));
        Log.e("결과","x : " + data.x + "    y : " + data.y + "    z : " + data.z);
        textView.setText("x : " + data.x + "    y : " + data.y + "    z : " + data.z+"   스텝");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
}



