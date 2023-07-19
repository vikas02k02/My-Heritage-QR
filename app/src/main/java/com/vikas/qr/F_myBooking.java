package com.vikas.qr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class F_myBooking extends Fragment {
    ListView bookedTickets;

    ArrayList<String> TravelDATE = new ArrayList<>();
    ArrayList<String> TravelPLACE = new ArrayList<>();
    ArrayList<String> TOURIST = new ArrayList<>();
    public F_myBooking() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_f_my_booking, container, false);
        bookedTickets=view.findViewById(R.id.lv_bookings);
        TravelDATE.add("02/10/2023");
        TravelDATE.add(data.getTdate());
        TravelPLACE.add("TajMahal");
        TravelPLACE.add(data.getPlace());
        TOURIST.add("2");
        TOURIST.add(data.gettTicket());
        bookingAdapter adap=new bookingAdapter(getActivity(),TravelDATE ,TOURIST,TravelPLACE);

        bookedTickets.setAdapter(adap);
        bookedTickets.setOnItemClickListener((parent, view1, position, id) -> {
            F_displayQR dis =new F_displayQR();
            Bundle bundle=new Bundle();
            bundle.putString("position",String.valueOf(position));
            dis.setArguments(bundle);
            getChildFragmentManager().beginTransaction().replace(R.id.fl_qrdisplay,dis).commit();
        });
        // Inflate the layout for this fragment
        return view;
    }
}