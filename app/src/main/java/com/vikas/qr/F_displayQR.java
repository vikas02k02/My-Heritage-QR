package com.vikas.qr;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Objects;

public class F_displayQR extends Fragment {



    public F_displayQR() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview =inflater.inflate(R.layout.fragment_display_qr, container, false);
        ImageView img =rootview.findViewById(R.id.qrimage);
        assert getArguments() != null;
        String str =getArguments().getString("position");
        if(Objects.equals(str, "0")){
            img.setImageResource(R.drawable.textqr);
        }
        else {
            img.setImageBitmap(data.getBitmap());
        }

        // Inflate the layout for this fragment
        return rootview;
    }
}