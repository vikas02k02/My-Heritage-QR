package com.vikas.qr;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class F_home extends Fragment {
    AutoCompleteTextView autoCompleteTextView;
    TextView Tv_date , Tv_tickets  ;
    EditText Et_passenger ;
    Button Btn_availability , Btn_date ,Btn_proceed;
    ArrayList<String> A_place=new ArrayList<>();
    public F_home() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f_home, container, false);

//Place name
        autoCompleteTextView = view.findViewById(R.id.ac_place);
        A_place.add("TajMahal");
        A_place.add("RedFort");
        A_place.add("RamMandir");
        A_place.add("LotusTemple");
        A_place.add("QutubMinar");
        ArrayAdapter<String> ac_place_adap = new ArrayAdapter<>(getActivity(), android.R.layout.preference_category, A_place);
        autoCompleteTextView.setAdapter(ac_place_adap);
        autoCompleteTextView.setThreshold(1);

//       date pickup

        Btn_date = view.findViewById(R.id.btn_date);
        Tv_date = view.findViewById(R.id.tv_date);


        Btn_date.setOnClickListener(v -> {
            final Calendar calendar = Calendar.getInstance();
            int mYear = calendar.get(Calendar.YEAR);
            int mMonth=calendar.get(Calendar.MONTH);
            int mDay=calendar.get(Calendar.DAY_OF_MONTH);
            String CurrentDate=mDay+"/"+(mMonth+1)+"/"+mYear;
            Tv_date.setText(CurrentDate);
            Date dateFormat1 ;
            String datetext;
            try {
                dateFormat1 = (new SimpleDateFormat("dd/MM/yyyy", Locale.UK)).parse(Tv_date.getText().toString());
                SimpleDateFormat dateFormat2=new SimpleDateFormat("dd-MM-yyyy",Locale.UK);
                assert dateFormat1 != null;
                datetext =dateFormat2.format(dateFormat1);

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            Tv_date.setText(datetext);
        });

//        check availability button
        Btn_availability=view.findViewById(R.id.btn_availability);
        Tv_tickets =view.findViewById(R.id.tv_tickets);
        Btn_availability.setOnClickListener(v -> {
            String place = autoCompleteTextView.getText().toString();
            String Nticket;
            if(!place.equals("TajMahal") && !place.equals("RedFort")&&!place.equals("RamMandir") &&!place.equals("LotusTemple") &&!place.equals("QutubMinar") &&!place.equals("")){
                autoCompleteTextView.setError("Sorry!We are not serving this place");
                Tv_tickets.setText("0");
            }
            else {
                switch (place) {
                    case "TajMahal":
                        Nticket = "300";
                        Tv_tickets.setText(Nticket);
                        break;
                    case "RedFort":
                        Nticket = "400";
                        Tv_tickets.setText(Nticket);
                        break;
                    case "RamMandir":
                        Nticket = "200";
                        Tv_tickets.setText(Nticket);
                        break;
                    case "LotusTemple":
                        Nticket = "500";
                        Tv_tickets.setText(Nticket);
                        break;
                    case "QutubMinar":
                        Nticket = "100";
                        Tv_tickets.setText(Nticket);
                        break;
                    case "":
                        autoCompleteTextView.setError("Place Can't be empty");
                        Tv_tickets.setText("0");
                        break;
                }
            }

//                format string date to date



        });


//       Create Tickets
        Btn_proceed =view.findViewById(R.id.btn_proceed);
        Et_passenger=view.findViewById(R.id.et_passenger);



        Btn_proceed.setOnClickListener(v -> {


            try {
                String place =autoCompleteTextView.getText().toString();
                String date =Tv_date.getText().toString();
                String ad =Et_passenger.getText().toString().trim();
                int check =Integer.parseInt(ad);
                if(place.length()==0 ){
                   autoCompleteTextView.setError("Select Place");
                   Toast.makeText(getActivity(),"Fill All Details" ,Toast.LENGTH_LONG).show();
                } else if (ad.length()==0 || check<1 ||check > 20) {
                    Et_passenger.setError("Enter between 1-20 only ");
                } else if (date.length()==0) {
                    Tv_date.setError("Select Date");
                } else {
                    data.setPlace(place);
                    data.setDate(date);
                    data.settTicket(ad);
                    F_payment pay = new F_payment();

                    Bundle bundle = new Bundle();
                    bundle.putString("new", ad);
                    pay.setArguments(bundle);
                    Toast.makeText(getActivity(), "QR generator", Toast.LENGTH_LONG).show();
                    getChildFragmentManager().beginTransaction().replace(R.id.lt_payment, pay).commit();
                }
            }catch (Exception e){
                Et_passenger.setError("Enter a value");
            }

        });

        return view;
    }

}


