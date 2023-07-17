package com.vikas.qr;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class F_feedback extends Fragment {
    RatingBar ratingBar;
    TextView Tv_rateCount;
    EditText Et_review;
    Button Btn_rate;
    Float rateValue;

    public F_feedback() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_f_feedback, container, false);
        ratingBar=view.findViewById(R.id.ratingBar);
        Tv_rateCount=view.findViewById(R.id.tv_rateCount);
        Et_review=view.findViewById(R.id.et_review);
        Btn_rate=view.findViewById(R.id.btn_rateSubmit);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rateValue=ratingBar.getRating();
                Tv_rateCount.setText(rateValue+"/5");
            }
        });
        Btn_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ratingBar.getRating()==0.0){
                    Toast.makeText(getActivity(), "Please Rate Us to submit", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getActivity(), "Thanks For Your Feedback", Toast.LENGTH_LONG).show();
                    ratingBar.setRating(0);
                    Tv_rateCount.setText("");
                    Et_review.setText("");
                }
            }
        });
        return view;
    }
}