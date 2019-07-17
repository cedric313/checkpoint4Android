package com.example.checkpoint4.activitity;

import android.os.Bundle;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.checkpoint4.R;
import com.example.checkpoint4.adapter.CircusAdapter;
import com.example.checkpoint4.model.Circus;
import com.example.checkpoint4.model.UserSingleton;
import com.example.checkpoint4.model.VolleySingleton;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        UserSingleton user = UserSingleton.getInstance();

        VolleySingleton.getInstance(EventActivity.this).getCircus(new Consumer<List<Circus>>() {
            @Override
            public void accept(List<Circus> circuses) {
                ArrayList<Circus> circusList = new ArrayList<>();
                for (Circus circus : circuses) {
                    circusList.add(circus);

                }
                ListView listCircus = findViewById(R.id.lvListCircus);
                CircusAdapter adapter = new CircusAdapter(EventActivity.this, circusList);
                listCircus.setAdapter(adapter);

            }
        });
    }
}
