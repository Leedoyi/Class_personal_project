package com.example.class_mobile;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductActivity extends Activity {
    private final long finishtimeed = 500;
    private long presstime = 0;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 빈 데이터 리스트 생성.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        listView = findViewById(R.id.listView);

        ArrayList <SubProduct> arrayList = new ArrayList<>();

        arrayList.add(new SubProduct(R.drawable.outer_best1, "outer_best1"));
        arrayList.add(new SubProduct(R.drawable.outer_best2, "outer_best2"));
        arrayList.add(new SubProduct(R.drawable.outer_best3, "outer_best3"));
        arrayList.add(new SubProduct(R.drawable.outer_best4, "outer_best4"));
        arrayList.add(new SubProduct(R.drawable.outer_best5, "outer_best5"));

        ProductAdapter productAdapter = new ProductAdapter(this,R.layout.activity_subproduct,arrayList);

        listView.setAdapter(productAdapter);


//
    }

//    뒤로가기 버튼

        @Override
        public void onBackPressed () {
            long tempTime = System.currentTimeMillis();
            long intervalTime = tempTime - presstime;

            if (0 <= intervalTime && finishtimeed >= intervalTime) {
                finish();
            } else {
                presstime = tempTime;
                Toast.makeText(getApplicationContext(), "더블클릭시 이전 창으로 이동", Toast.LENGTH_SHORT).show();
            }
        }
    }






