package com.example.walking;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public abstract class SensorProvider implements SensorEventListener {
    protected final Context context;
    protected final SensorManager manager;
    protected SensorDataListener listener;

    public SensorProvider(Context context) {
        this.context = context;
        this.manager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
    }
    public static SensorProvider get(Context context) {
        return new MockSensorProvider(context);
    }

    public void register(MainActivity listener, int sensorType, int delay) {
        this.listener = listener;
        manager.registerListener(this, manager.getDefaultSensor(sensorType), delay);
    }

    public void unregister() {
        manager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    public abstract boolean contains(int sensorType);
}