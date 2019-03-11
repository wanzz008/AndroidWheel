package com.lkyj.androidwheel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.NumericWheelAdapter;

public class MainActivity extends AppCompatActivity {

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //
        final WheelView v1 = (WheelView) findViewById(R.id.wv_hour);
        WheelView v2 = (WheelView) findViewById(R.id.wv_minute);

        v1.setViewAdapter(new NumericWheelAdapter(this, 0, 40));
        v2.setViewAdapter(new NumericWheelAdapter(this, 0, 9));

        v1.setCurrentItem(6);


        findViewById(R.id.time).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("wzz---- " , v1.getCurrentItem() + "" );
            }
        });

        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TemperatureActivity.class));
            }
        });
        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WheelDemo.class));
            }
        });
    }
}
