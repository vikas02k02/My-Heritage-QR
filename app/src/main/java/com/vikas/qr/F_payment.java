package com.vikas.qr;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class F_payment extends Fragment {
    Button btn;
    TextView BookMessage,TiketPrice;
    ImageView img ;



    public F_payment() {
        // Required empty public constructor
    }




    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_f_payment, container, false);


        btn =view.findViewById(R.id.btn_pay);
        img = view.findViewById(R.id.iv_ticket);
        TiketPrice=view.findViewById(R.id.totalCost);
        BookMessage=view.findViewById(R.id.tv_bookMessege);

        assert getArguments() != null;
        String str =getArguments().getString("new");
        String total="\u20B9 " + ((Integer.parseInt(str)*40) +5);
        TiketPrice.setText(total);
        btn.setOnClickListener(v -> {
            String myText=qrdata(str,total);
            MultiFormatWriter mWriter=new MultiFormatWriter();
            try {
                BitMatrix mMatrix = mWriter.encode(myText, BarcodeFormat.QR_CODE, 600, 600);
                BarcodeEncoder mEncoder = new BarcodeEncoder();
                Bitmap mBitmap = mEncoder.createBitmap(mMatrix);
                img.setImageBitmap(mBitmap);
                data.setBitmap(mBitmap);
                BookMessage.setText("Congratulations Your ticket to Culture has been booked Scroll Down");

            }catch (WriterException e){
                e.printStackTrace();
            }

        });


        return view;
    }
    private String  qrdata(String str,String total){
        String myText=str + data.getUsername().substring(1,3)+total+data.getUsername().substring(3,5);
        return myText+myText.charAt(0)+Math.sqrt(12);
    }
}