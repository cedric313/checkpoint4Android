package com.example.checkpoint4.activitity;

import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.checkpoint4.R;
import com.example.checkpoint4.model.Circus;
import com.example.checkpoint4.model.VolleySingleton;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        VolleySingleton.getInstance(EventActivity.this).getCircus(new Consumer<List<Circus>>() {
            @Override
            public void accept(List<Circus> circuses) {
                List<Circus> circusPublished = new ArrayList<>();
                for (Circus circus : circuses) {
                    circusPublished.add(circus);

                }
            }
        });
    }
}
