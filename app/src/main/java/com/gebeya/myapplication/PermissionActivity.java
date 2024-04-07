package com.gebeya.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class PermissionActivity extends AppCompatActivity {
    ImageView locationPermissionSwitch,runBatteryInBackgroundSwitch,icBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        runBatteryInBackgroundSwitch = findViewById(R.id.run_background_battery_switch);
        locationPermissionSwitch = findViewById(R.id.location_permission_switch);
        icBack = findViewById(R.id.ic_back);

        icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        runBatteryInBackgroundSwitch.setOnClickListener(new View.OnClickListener() {
            int count = 2;
            @Override
            public void onClick(View view) {
                if (count % 2 == 0){
                    runBatteryInBackgroundSwitch.setImageResource(R.mipmap.open);
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        Intent intent = new Intent();
                        String packageName = getPackageName();
                        PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
                        if (!pm.isIgnoringBatteryOptimizations(packageName)) {
                            intent.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                            intent.setData(Uri.parse("package:" + packageName));
                            startActivity(intent);
                        }
                    }
                }
                else{
                    runBatteryInBackgroundSwitch.setImageResource(R.mipmap.closed);

                }
                count = count + 1;

            }
        });

    locationPermissionSwitch.setOnClickListener(new View.OnClickListener() {
                int count = 2;
                @Override
                public void onClick(View view) {
                    if (count % 2 == 0){
                        locationPermissionSwitch.setImageResource(R.mipmap.open);
                        if (ActivityCompat.checkSelfPermission(PermissionActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(PermissionActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(PermissionActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                            return;
                        }else{
                            Toast.makeText(PermissionActivity.this, "already got a persmission", Toast.LENGTH_SHORT).show();
                            // Write you code here if permission already given.
                        }
                    }
                    else{
                        locationPermissionSwitch.setImageResource(R.mipmap.closed);


                    }
                    count = count + 1;

                }
            });


    }
    @Override
    public void onBackPressed() {
        // Add your custom logic here
        // For example, navigate to a specific activity or show a confirmation dialog
        // Be sure to call super.onBackPressed() if you want to retain the default behavior
        super.onBackPressed();
    }
}