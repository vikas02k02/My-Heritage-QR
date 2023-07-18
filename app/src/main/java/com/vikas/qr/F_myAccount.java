package com.vikas.qr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class F_myAccount extends Fragment {
    EditText Et_name , Et_email,Et_phone ;
    Button Btn_update;
    RadioButton rb_male ,rb_female;


    public F_myAccount() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_f_my_account, container, false);
        rb_male=view.findViewById(R.id.rb_male);
        rb_female=view.findViewById(R.id.rb_female);
        rb_male.setChecked(data.getMaleStatus());
        rb_female.setChecked(data.getFemaleStatus());
        TextView Tv_name =view.findViewById(R.id.tv_name);
        Tv_name.setText(data.getname());
        Et_name=view.findViewById(R.id.et_name);
        Et_name.setText(data.getname());
        Et_email=view.findViewById(R.id.et_email);
        Et_email.setText(data.getEmail());
        Et_phone=view.findViewById(R.id.et_phone);
        Et_phone.setText(data.getPhone());
        Btn_update=view.findViewById(R.id.btn_updateProfile);


        Btn_update.setOnClickListener(v -> {
            data.setName(Et_name.getText().toString());
            data.setEmail(Et_email.getText().toString());
            data.setPhone(Et_phone.getText().toString());
            data.setMaleStatus(rb_male.isChecked());
            data.setFemaleStatus(rb_female.isChecked());
            Tv_name.setText(data.getname());
            Et_name.setText(data.getname());
            Et_email.setText(data.getEmail());
            Et_phone.setText(data.getPhone());
            rb_male.setChecked(data.getMaleStatus());
            rb_female.setChecked(data.getFemaleStatus());
            Toast.makeText(getActivity(), "Account Details Updated", Toast.LENGTH_SHORT).show();

        });



        // Inflate the layout for this fragment
        return view;
    }
}