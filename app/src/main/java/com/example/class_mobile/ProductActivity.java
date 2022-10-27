package com.example.class_mobile;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class ProductActivity extends Activity {
    private final long finishtimeed = 1000;
    private long presstime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);



    }


    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - presstime;

        if (0 <= intervalTime && finishtimeed >= intervalTime)
        {
            finish();
        }
        else
        {
            presstime = tempTime;
            Toast.makeText(getApplicationContext(), "뒤로가기", Toast.LENGTH_SHORT).show();
        }
    }


}
