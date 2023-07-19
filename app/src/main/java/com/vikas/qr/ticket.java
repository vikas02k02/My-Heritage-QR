package com.vikas.qr;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class ticket extends AppCompatActivity {
    DrawerLayout Lt_drawer;
    NavigationView Nv_drawer;
    Toolbar Lt_toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        Lt_drawer=findViewById(R.id.lt_drawer);
        Nv_drawer=findViewById(R.id.nv_drawer);
        Lt_toolBar=findViewById(R.id.lt_toolBar);
        setSupportActionBar(Lt_toolBar);

        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,Lt_drawer,Lt_toolBar,R.string.OpenDrawer,R.string.CloseDrawer);
        Lt_drawer.addDrawerListener(toggle);
        toggle.syncState();
        FragmentManager fm=getSupportFragmentManager();
        fm.beginTransaction().add(R.id.lt_frame,new F_home()).commit();
        Nv_drawer.setNavigationItemSelectedListener(item -> {
            int id=item.getItemId();
            if(id==R.id.home){
                loadFragment(new F_home());
                Toast.makeText(ticket.this, "Home Fragment invoked", Toast.LENGTH_SHORT).show();
            } else if (id==R.id.myAccount) {
                    loadFragment(new F_myAccount());
                Toast.makeText(ticket.this, "My Account Fragment invoked", Toast.LENGTH_SHORT).show();
            }else if (id==R.id.notification_setting) {
                loadFragment(new F_notification());
                Toast.makeText(ticket.this, "Notification Fragment invoked", Toast.LENGTH_SHORT).show();
            }else if (id==R.id.myBookings) {
                loadFragment(new F_myBooking());
                Toast.makeText(ticket.this, "My Bookings Fragment invoked", Toast.LENGTH_SHORT).show();
            }else if (id==R.id.change_password) {
                loadFragment(new F_changePassword());
                Toast.makeText(ticket.this, "Password Fragment invoked", Toast.LENGTH_SHORT).show();
            }else if (id==R.id.about_us) {
                loadFragment(new F_aboutUs());
                Toast.makeText(ticket.this, "About us Fragment invoked", Toast.LENGTH_SHORT).show();
            }else if (id==R.id.feedback) {
                loadFragment(new F_feedback());
                Toast.makeText(ticket.this, "Feedback Fragment invoked", Toast.LENGTH_SHORT).show();
            }else if (id==R.id.contact_us) {
                loadFragment(new F_contactUs());
                Toast.makeText(ticket.this, "Contact Us Fragment invoked", Toast.LENGTH_SHORT).show();
            }else if (id==R.id.log_out) {
                Toast.makeText(ticket.this, "Log out Successful", Toast.LENGTH_SHORT).show();
                    finish();
            }
            Lt_drawer.closeDrawer(GravityCompat.START);
            return true;
        });

    }

    @Override
    public void onBackPressed() {
        if(Lt_drawer.isDrawerOpen(GravityCompat.START)){
            Lt_drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }

    private void loadFragment(Fragment fragment){
        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft =fm.beginTransaction();
        ft.replace(R.id.lt_frame,fragment);
        ft.commit();
    }

}