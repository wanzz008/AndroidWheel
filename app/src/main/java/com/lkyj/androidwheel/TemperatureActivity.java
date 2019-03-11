package com.lkyj.androidwheel;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.AbstractWheelTextAdapter;

public class TemperatureActivity extends Activity {
    // Scrolling flag
    private boolean scrolling = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_temperature);
                
        WheelView country =  findViewById(R.id.temperature);
        country.setVisibleItems(1);
        country.setViewAdapter(new CountryAdapter(this));


        country.setCurrentItem(10);

    }
    
    /**
     * Adapter for countries
     */
    private class CountryAdapter extends AbstractWheelTextAdapter {
        // Countries names
        private String[] countries = new String[41];
        /**
         * Constructor
         */
        protected CountryAdapter(Context context) {

            super(context, R.layout.temperature_layout, NO_RESOURCE);

            // 0-9   36.0-36.9
            // 10-19 37.0-37.9
            // 20-29 38.0-38.9
            // 30-39 39.0-39.9
            // 40    40.0

            for ( int i = 0 ; i < 41 ; i ++ ){
                int ge = i / 10  + 36 ;
                int dian = i % 10 ;
                countries[i] = ge + "." +  dian ;
            }

            setItemTextResource(R.id.country_name);
        }

        @Override
        public View getItem(int index, View cachedView, ViewGroup parent) {
            View view = super.getItem(index, cachedView, parent);
            return view;
        }
        
        @Override
        public int getItemsCount() {
            return countries.length;
        }
        
        @Override
        protected CharSequence getItemText(int index) {
            return countries[index];
        }
    }
}
