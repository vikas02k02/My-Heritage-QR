package com.vikas.qr;

public class data {
    static String Password ="admin";
    static String Username ="admin";
    static String Name ="Vikas Kumar";
    static String Email ="vikas.02k02@gmail.com";
    static String Phone="6203124802";
    static boolean maleRB =true;
    static boolean femaleRB =false;

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

}
