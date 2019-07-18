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
import com.example.checkpoint4.activitity.RiderActivity;
import com.example.checkpoint4.model.Circus;

import java.util.List;


public class CircusAdapter extends ArrayAdapter<Circus> {

    public CircusAdapter(Context context, List<Circus> doIt) {
        super(context, 0, doIt);
    }

    @Override

    public View getView(int position, View convertView, final ViewGroup parent) {
        final Circus item = getItem(position);

        if (null == convertView) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_circus, parent, false);
        }
        final TextView circusName = convertView.findViewById(R.id.tvNameCircus);
        TextView circusDate = convertView.findViewById(R.id.tvDateCircus);
        TextView circusLocation = convertView.findViewById(R.id.tvCircusLocation);
        Button btLookRiders = convertView.findViewById(R.id.btLookRider);
        ImageView circusImage = convertView.findViewById(R.id.ivCircus);

        circusName.setText(item.getName());
        final Long circusId = item.getIdCircus();
        circusDate.setText(item.getDate());
        circusLocation.setText(item.getLocation());
        btLookRiders.setFocusable(true);
        btLookRiders.setClickable(true);
        Glide.with(getContext()).load(item.getUrlPhoto()).into(circusImage);
        btLookRiders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent zoom = new Intent(parent.getContext(), RiderActivity.class);
                parent.getContext().startActivity(zoom);
                zoom.putExtra("ID_CIRCUS", circusId);
            }
        });

        return convertView;
    }
}
