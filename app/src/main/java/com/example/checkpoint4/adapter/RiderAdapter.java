package com.example.checkpoint4.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.Consumer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.checkpoint4.R;
import com.example.checkpoint4.activitity.FavorisActivity;
import com.example.checkpoint4.model.Rider;
import com.example.checkpoint4.model.User;
import com.example.checkpoint4.model.UserSingleton;
import com.example.checkpoint4.model.VolleySingleton;

import java.util.List;

public class RiderAdapter extends ArrayAdapter<Rider> {

    public RiderAdapter(Context context, List<Rider> riders) {
        super(context, 0, riders);
    }

    @Override

    public View getView(int position, View convertView, final ViewGroup parent) {
        final Rider item = getItem(position);

        if (null == convertView) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_riders, parent, false);
        }
        TextView riderName = convertView.findViewById(R.id.tvRiderName);
        TextView riderFirstName = convertView.findViewById(R.id.tvRiderFirstName);
        TextView riderAge = convertView.findViewById(R.id.tvRiderAge);
        TextView riderNationality = convertView.findViewById(R.id.tvRiderNationality);
        ImageView riderImage = convertView.findViewById(R.id.ivRider);
        Button btAddFavorite = convertView.findViewById(R.id.btAddFavoriteRider);
        Button btShowFavorites = convertView.findViewById(R.id.btShowFavorites);

        final Long idRider = item.getIdRider();
        riderName.setText(item.getName());
        riderFirstName.setText(item.getFirstName());
        riderAge.setText(Integer.toString(item.getAge()) + " ans");
        riderNationality.setText("Nationalité : " + item.getNationality());
        btAddFavorite.setFocusable(true);
        btAddFavorite.setClickable(true);
        Glide.with(getContext()).load(item.getUrlPicRider()).into(riderImage);
        btShowFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent zoom = new Intent(parent.getContext(), FavorisActivity.class);
                parent.getContext().startActivity(zoom);

            }
        });
        btAddFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserSingleton user = UserSingleton.getInstance();
                Long idUser = user.getUser().getIdUser();
                VolleySingleton.getInstance(getContext()).addRiderToFavorite(idUser, idRider, new Consumer<User>() {
                    @Override
                    public void accept(User user) {
                        Toast.makeText(getContext(), "ajouté au favoris", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return convertView;
    }
}
