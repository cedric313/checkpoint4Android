package com.example.checkpoint4.activitity;

import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.checkpoint4.R;
import com.example.checkpoint4.adapter.RiderAdapter;
import com.example.checkpoint4.adapter.RiderFavoriteAdapter;
import com.example.checkpoint4.model.Rider;
import com.example.checkpoint4.model.User;
import com.example.checkpoint4.model.UserSingleton;
import com.example.checkpoint4.model.VolleySingleton;

import java.util.ArrayList;
import java.util.List;

public class FavorisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoris);
        UserSingleton user = UserSingleton.getInstance();
        Long idUser = user.getUser().getIdUser();

        VolleySingleton.getInstance(getApplicationContext()).getUserById(idUser, new Consumer<User>() {
            @Override
            public void accept(User user) {
                List<Rider> riders = user.getRiders();
                ListView listRider = findViewById(R.id.lvListRidersFavorite);
                RiderFavoriteAdapter adapter = new RiderFavoriteAdapter(getApplicationContext(), riders);
                listRider.setAdapter(adapter);
            }
        });
    }
}
