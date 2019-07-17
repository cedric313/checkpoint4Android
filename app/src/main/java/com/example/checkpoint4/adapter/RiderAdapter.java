package com.example.checkpoint4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.checkpoint4.R;
import com.example.checkpoint4.model.Rider;

import java.util.List;

public class RiderAdapter extends ArrayAdapter<Rider> {

    public RiderAdapter(Context context, List<Rider> doIt) {
        super(context, 0, doIt);
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

        riderName.setText(item.getName());
        riderFirstName.setText(item.getFirstName());
        riderAge.setText(Integer.toString(item.getAge()) + " ans");
        riderNationality.setText("Nationalité : " + item.getNationality());
        btAddFavorite.setFocusable(true);
        btAddFavorite.setClickable(true);
        Glide.with(getContext()).load(item.getUrlPicRider()).into(riderImage);

        return convertView;
    }
}
