package com.example.cryptotracker2;

import java.util.ArrayList;
import java.util.List;

public class DATABASE {
    public static List<String> crypto_name= new ArrayList<>();
    public static List<String> crypto_name_nick= new ArrayList<>();
    public static List<String> crypto_name_price= new ArrayList<>();
    public static List<String> aa1= new ArrayList<>();
    public static List<String> aa2= new ArrayList<>();
    public static List<String> aa3= new ArrayList<>();
    public static List<String> aa4= new ArrayList<>();
    public static List<String> aa5= new ArrayList<>();
    public static List<String> aa6= new ArrayList<>();
    public static List<String> aa7= new ArrayList<>();
    public static List<String> aa8= new ArrayList<>();
    public static List<String> aa9= new ArrayList<>();

DATABASE(){

}
DATABASE (String name,String nick,String price , String a1,String a2,String a3 ,String a4,String a5 ,String a6,String a7 ,String a8,String a9  ){
    crypto_name.add(name);
    crypto_name_nick.add(nick);
    crypto_name_price.add(price);

    aa1.add(a1);
    aa2.add(a2);
    aa3.add(a3);
    aa4.add(a4);
    aa5.add(a5);
    aa6.add(a6);
    aa7.add(a7);
    aa8.add(a8);
    aa9.add(a9);

}
}
