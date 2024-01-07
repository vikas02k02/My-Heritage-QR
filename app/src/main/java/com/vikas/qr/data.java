package com.vikas.qr;

import android.graphics.Bitmap;

public class data {
    static String Password ="admin";
    static String Username ="admin";
    static String Name ="My_Heritage-QR";
    static String Email ="my_heritage_qr@gmail.com";
    static String Phone="6203124802";
    static boolean maleRB =true;
    static boolean femaleRB =false;
    static String place="";
    static String tdate="";
    static String tTicket="";
    static Bitmap bitmap;
    public static String  getPassword(){
        return Password;
    }
    public static boolean  getMaleStatus(){
        return maleRB;
    }
    public static boolean  getFemaleStatus(){
        return femaleRB;
    }
    public static String  getUsername(){
        return Username;
    }
    public static String  getname(){return Name;}
    public static String  getEmail(){
        return Email;
    }
    public static String  getPhone(){
        return Phone;
    }
    public static String getPlace(){return  place;}
    public static String getTdate(){return  tdate;}
    public static String gettTicket(){return tTicket;}
    public static Bitmap getBitmap(){return bitmap;}

    public static void setPassword(String password){
        Password=password;
    }
    public static void setUsername(String username){
        Username=username;
    }
    public static void setName(String name){
        Name=name;
    }
    public static void setEmail(String email){
        Email=email;
    }
    public static void setPhone(String phone){Phone=phone;}
    public static void  setMaleStatus(boolean male ){
        maleRB= male;
    }
    public static void  setFemaleStatus(boolean female){
        femaleRB= female;
    }
    public static void setPlace(String pla){place=pla;}
    public static void setDate(String da){tdate =da;}
    public static void settTicket(String ti){tTicket=ti;}
    public static void setBitmap(Bitmap bt){bitmap=bt;}

}
