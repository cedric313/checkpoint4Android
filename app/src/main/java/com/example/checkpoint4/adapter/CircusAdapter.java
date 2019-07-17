package com.example.checkpoint4.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.checkpoint4.R;
import com.example.checkpoint4.activitity.RiderActivity;
import com.example.checkpoint4.model.Circus;

import java.util.ArrayList;
import java.util.List;


public class CircusAdapter extends ArrayAdapter<Circus> {

    public CircusAdapter(Context context, List<Circus> doIt) {
        super(context, 0, doIt);
    }
    @Override

    public View getView(int position, View convertView, final ViewGroup parent) {
        // TODO 1 : Get the data item for this position
        Circus item = getItem(position);

        // TODO 2 : Check if an existing view is being reused, otherwise inflate the view
        if (null == convertView) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_circus, parent, false);
        }
        // TODO 3 : Lookup view for data population
        TextView circusName = convertView.findViewById(R.id.tvNameCircus);
        TextView circusDate = convertView.findViewById(R.id.tvDateCircus);
        TextView circusLocation = convertView.findViewById(R.id.tvCircusLocation);
        Button btLookRiders = convertView.findViewById(R.id.btLookRider);
        ImageView circusImage = convertView.findViewById(R.id.ivCircus);

        // TODO 4 : Populate the data into the template view using the data object
        circusName.setText(item.getName());
        circusDate.setText(item.getDate());
        circusLocation.setText(item.getLocation());
        btLookRiders.setFocusable(true);
        btLookRiders.setClickable(true);
        Glide.with(getContext()).load(item.getUrlPhoto()) .into(circusImage);
        btLookRiders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent zoom = new Intent(parent.getContext(), RiderActivity.class);
                parent.getContext().startActivity(zoom);
            }
        });

        // Return the completed view to render on screen
        return convertView;
    }
}
