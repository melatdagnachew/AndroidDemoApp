package com.gebeya.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteHistoryActivity extends AppCompatActivity {

    List<Route> routeList;
    Route route;
    RecyclerView recyclerView ;
    RouterAdapter routerAdapter;
    ImageView icBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_history);

        routeList = new ArrayList<>();
        routeList.add(new Route("RouteName1", "07:32-08:36", 4));
        routeList.add(new Route("RouteName2","07:32-08:36",5));
        routeList.add(new Route("RouteName3","07:32-08:36",6));

        recyclerView = findViewById(R.id.recyclerview);
        icBack = findViewById(R.id.ic_back);

        icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        routerAdapter = new RouterAdapter(routeList,this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(routerAdapter);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}