package com.vikas.qr;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class F_changePassword extends Fragment {
    EditText Et_currentPassword ,Et_newPassword ,Et_confirmPassword;
    Button Btn_enter;

    public F_changePassword() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_f_changepassword, container, false);
        Et_currentPassword=view.findViewById(R.id.et_currentPass);
        Et_newPassword=view.findViewById(R.id.et_newPass);
        Et_confirmPassword=view.findViewById(R.id.et_confirmPass);
        Btn_enter =view.findViewById(R.id.btn_changePass);
        Btn_enter.setOnClickListener(v -> {
            String currentP =Et_currentPassword.getText().toString();
            String newP =Et_newPassword.getText().toString();
            String confirmP =Et_confirmPassword.getText().toString();
            if(newP.length()<5 ) {
                Et_newPassword.setError("Too Small ,must be > 5");
            } else if (!Objects.equals(currentP, data.getPassword())) {
                Et_currentPassword.setError("Enter Correct Password");

            } else if (!newP.equals(confirmP)) {
                Et_confirmPassword.setError("Should be same as New Password");
            } else if (currentP.equals(newP)) {
                Et_newPassword.setError("Same as current Password");
            } else {
                data.setPassword(newP);
                Et_currentPassword.setText("");
                Et_newPassword.setText("");
                Et_confirmPassword.setText("");
                Toast.makeText(getActivity(),"Password Changed Successfully",Toast.LENGTH_LONG).show();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}