package com.vikas.qr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import java.util.List;


public class F_contactUs extends Fragment {
    Button Btn_instagram ,btnLinkedIn , Btn_Gmail;
    public F_contactUs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_f_contact_us, container, false);
        // Inflate the layout for this fragment
        // Open only in the Instagram
        Btn_instagram=view.findViewById(R.id.btn_Instagram);
        Btn_instagram.setOnClickListener(v -> {
            String username = "amitpandey751";
            Uri uri = Uri.parse("http://instagram.com/_u/" + username);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.instagram.android");
            // ...
            PackageManager packageManager = requireActivity().getPackageManager();
            @SuppressLint("QueryPermissionsNeeded") List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
            boolean isIntentSafe = activities.size() > 0;

            if (!isIntentSafe) {
                Uri webUri = Uri.parse("http://instagram.com/" + username);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webUri);
                startActivity(webIntent);
            } else {
                startActivity(intent);
            }

// Linkedin  contact
        });
        btnLinkedIn = view.findViewById(R.id.btn_LinkedIn);
        btnLinkedIn.setOnClickListener(v -> {
            String linkedInProfileUrl = "https://www.linkedin.com/in/amit-pandey-2a0293246";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedInProfileUrl));
            startActivity(intent);
        });
        Btn_Gmail = view.findViewById(R.id.btn_gmail);
        Btn_Gmail.setOnClickListener(v -> {
            String recipientEmail = "amitp152002@gmail.com";
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + recipientEmail));
            startActivity(intent);
        });

        return view;
    }
}