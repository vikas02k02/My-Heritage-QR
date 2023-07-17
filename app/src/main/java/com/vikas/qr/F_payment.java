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
    TextView BookMessege,data;
    ImageView img ,Iv_ticket;



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
        data=view.findViewById(R.id.totalCost);
        BookMessege=view.findViewById(R.id.tv_bookMessege);

        assert getArguments() != null;
        String str =getArguments().getString("new");
        String total="\u20B9 " + ((Integer.parseInt(str)*40) +5);
        data.setText(total);

        String myText="HELLO";
        btn.setOnClickListener(v -> {
            MultiFormatWriter mWriter=new MultiFormatWriter();
            try {
                BitMatrix mMatrix = mWriter.encode(myText, BarcodeFormat.QR_CODE, 600, 600);
                BarcodeEncoder mEncoder = new BarcodeEncoder();
                Bitmap mBitmap = mEncoder.createBitmap(mMatrix);
                img.setImageBitmap(mBitmap);
                BookMessege.setText("Congratulations Your ticket to Culture has been booked Scroll Down");
//                animateScrollDown();

            }catch (WriterException e){
                e.printStackTrace();
            }

        });


        return view;
    }
//    upward scroll animation
//    public void animateScrollDown() {
//        ObjectAnimator animator = ObjectAnimator.ofFloat(BookMessege, "translationY", -1000f);
//        animator.setDuration(1000); // Adjust the duration as needed
//        animator.start();
//    }
}