package com.dji.uxsdkdemo;

import android.Manifest;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.lang.reflect.Constructor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button liveBtn;
    private static final String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // When the compile and target version is higher than 22, please request the
        // following permissions at runtime to ensure the
        // SDK work well.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.VIBRATE,
                            Manifest.permission.INTERNET, Manifest.permission.ACCESS_WIFI_STATE,
                            Manifest.permission.WAKE_LOCK, Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_NETWORK_STATE, Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.CHANGE_WIFI_STATE, Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS,
                            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SYSTEM_ALERT_WINDOW,
                            Manifest.permission.READ_PHONE_STATE,
                    }
                    , 1);
        }

        setContentView(R.layout.activity_main);
        liveBtn = (Button) findViewById(R.id.Live);
    }

    private void transition() {
        try {
            LiveStream live = new LiveStream(getApplicationContext());
        } catch (Exception e){
            throw new RuntimeException("Context is borked");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Live:
                ToastUtils.setResultToToast("button was clicked");
                transition();
                LiveStream live = new LiveStream(getApplicationContext());
                break;
            default:
                break;
        }
    }
}

