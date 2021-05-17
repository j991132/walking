package com.example.walking;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;

import java.util.Random;

public class MockSensorProvider extends SensorProvider {
    public MockSensorProvider(Context context) {
        super(context);
    }

    @Override
    public boolean contains(int sensorType) {
        return sensorType == Sensor.TYPE_ACCELEROMETER ||
                sensorType == Sensor.TYPE_GYROSCOPE;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        final SensorDataListener listener = this.listener;
        if (listener == null) return;

        final float[] values = event.values;


        final SensorData accData = new SensorData(
                event.timestamp,
                Sensor.TYPE_ACCELEROMETER,
               

                (values[0]+2) * (int)(Math.random()*10),
                (values[1]+2) * (int)(Math.random()*10),
                (values[2]+2) * (int)(Math.random()*10)


        );
        listener.onSensorChanged(accData);

        final SensorData gyrData = new SensorData(
                event.timestamp + 10,
                Sensor.TYPE_GYROSCOPE,
                values[0] * values[0],
                values[1] * values[1],
                values[2] * values[2]
        );
        listener.onSensorChanged(gyrData);

        final SensorData couintData = new SensorData(
                event.timestamp + 10,
                Sensor.TYPE_STEP_COUNTER,
                (values[0]+2) * (int)(Math.random()*10),
                (values[1]+2) * (int)(Math.random()*10),
                (values[2]+2) * (int)(Math.random()*10)
        );
        listener.onSensorChanged(couintData);


    }
}
