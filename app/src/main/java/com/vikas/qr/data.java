package com.vikas.qr;

public class data {
    static String Password ="admin";
    static String Username ="admin";

    public static String  getPassword(){
        return Password;
    }
    public static String  getUsername(){
        return Username;
    }
    public static void setPassword(String password){
        Password=password;
    }
}
