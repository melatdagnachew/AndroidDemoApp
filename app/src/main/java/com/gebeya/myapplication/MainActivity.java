package com.gebeya.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout historicaRouteLayout,permissionLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        historicaRouteLayout = findViewById(R.id.historical_route_layout);
        permissionLayout = findViewById(R.id.permission_layout);

        historicaRouteLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RouteHistoryActivity.class);
                startActivity(intent);
            }
        });
        permissionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PermissionActivity.class);
                startActivity(intent);
            }
        });
    }
}