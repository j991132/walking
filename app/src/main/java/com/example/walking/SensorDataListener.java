package com.example.walking;

import android.hardware.Sensor;

public interface SensorDataListener {
    void onSensorChanged(SensorData data);

    void onAccuracyChanged(Sensor sensor, int accuracy);
}
