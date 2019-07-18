package com.example.checkpoint4.activitity;

import android.os.Bundle;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.checkpoint4.R;
import com.example.checkpoint4.adapter.RiderAdapter;
import com.example.checkpoint4.model.Rider;
import com.example.checkpoint4.model.VolleySingleton;

import java.util.ArrayList;
import java.util.List;

public class RiderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider2);

        VolleySingleton.getInstance(getApplicationContext()).getRiders(new Consumer<List<Rider>>() {
            @Override
            public void accept(List<Rider> riders) {

                ListView listRider = findViewById(R.id.lvListRiders);
                RiderAdapter adapter = new RiderAdapter(RiderActivity.this, riders);
                listRider.setAdapter(adapter);
            }
        });
    }
}
