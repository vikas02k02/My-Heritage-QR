package com.vikas.qr;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class bookingAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> dateJourney;
    ArrayList<String> totalTourist;
    ArrayList<String> touristPlace;
    LayoutInflater inflater;

    public bookingAdapter(Context ctx, ArrayList<String> journeyDate , ArrayList<String> Tourist , ArrayList<String> place){
        this.context=ctx;
        this.dateJourney=journeyDate;
        this.totalTourist=Tourist;
        this.touristPlace=place;
        inflater=LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return touristPlace.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint({"SetTextI18n", "InflateParams", "ViewHolder"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView =inflater.inflate(R.layout.fragment_custom_list,null);
        TextView tv_tourist =convertView.findViewById(R.id.li_tourist);
        TextView tv_place =convertView.findViewById(R.id.li_place);
        TextView tv_date =convertView.findViewById(R.id.li_journeyDate);
        tv_tourist.setText("No. of Tourist : "+ totalTourist.get(position));
        tv_place.setText("Visiting Place : "+ touristPlace.get(position));
        tv_date.setText("Visting Date : "+ dateJourney.get(position));

        return convertView;
    }
}
