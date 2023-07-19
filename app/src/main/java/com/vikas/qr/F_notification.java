package com.vikas.qr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class F_notification extends Fragment {



    public F_notification() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_f_notification, container, false);
        Button btn_email = view.findViewById(R.id.btn_email);
        Button btn_phone=view.findViewById(R.id.btn_phone);
        btn_email.setOnClickListener(v -> Toast.makeText(getActivity(),"No emails notification exists now in this version",Toast.LENGTH_LONG).show());
        btn_phone.setOnClickListener(v -> Toast.makeText(getActivity(),"No phone notification exists now in this version",Toast.LENGTH_LONG).show());

        // Inflate the layout for this fragment
        return view;
    }
}