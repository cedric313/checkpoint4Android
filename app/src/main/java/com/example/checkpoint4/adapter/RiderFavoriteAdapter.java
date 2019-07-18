package com.example.checkpoint4.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.checkpoint4.R;
import com.example.checkpoint4.activitity.EventActivity;
import com.example.checkpoint4.model.Rider;

import java.util.List;

public class RiderFavoriteAdapter extends ArrayAdapter<Rider> {

    public RiderFavoriteAdapter(Context context, List<Rider> riders) {
        super(context, 0, riders);
    }

    @Override

    public View getView(int position, View convertView, final ViewGroup parent) {
        final Rider item = getItem(position);

        if (null == convertView) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_rider_favorite, parent, false);
        }
        TextView riderName = convertView.findViewById(R.id.tvRiderNameFavorite);
        TextView riderFirstName = convertView.findViewById(R.id.tvFirstnameFavorit);
        ImageView riderImage = convertView.findViewById(R.id.ivRiderFavorite);
        Button btEventBack = convertView.findViewById(R.id.btBackEvent);

        riderName.setText(item.getName());
        riderFirstName.setText(item.getFirstName());
        Glide.with(getContext()).load(item.getUrlPicRider()).into(riderImage);

        btEventBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent zoom = new Intent(parent.getContext(), EventActivity.class);
                parent.getContext().startActivity(zoom);
            }
        });


        return convertView;
    }
}
