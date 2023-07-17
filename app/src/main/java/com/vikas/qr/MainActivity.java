package com.vikas.qr;

import static com.vikas.qr.data.getPassword;
import static com.vikas.qr.data.getUsername;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Username ,Password;
    Button Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username=findViewById(R.id.et_username);
        Password=findViewById(R.id.et_password);
        Btn =findViewById(R.id.btn_login);
        Btn.setOnClickListener(V -> {
            try {
                String str =Username.getText().toString().trim();
                String str2=Password.getText().toString().trim();
                if(str.length()==0){
                    Username.setError("Only characters a-z,-,0-9 are allowed");
                }
                else{
                    if (str.equals(getUsername()) && str2.equals(getPassword())) {
                        Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
                        openNewActivity();
                        Username.setText(null);
                        Password.setText(null);
                    } else {
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
                    }
                }

            } catch (Exception e) {
                Toast.makeText(this, "Exception happened on server side", Toast.LENGTH_LONG).show();
            }

        });
    }
    public void openNewActivity(){
        Intent intent =new Intent(getApplicationContext(),ticket.class);
        startActivity(intent);
    }
}