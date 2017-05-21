package com.example.mohamed.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Mohamed on 5/1/2017.
 */

public class datamodel {

    static private Uri selectedIamge;
    static private Drawable pic;
    ArrayList<String> _messages =null;

    static private String location="-Dokki : 1 Dokki Street";

    public  datamodel()
    {
       /* SharedPreferences sharedPref = getSharedPreferences("phone", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPref.edit();
        editor.putString("phone",cout);
        editor.apply();*/
        _messages=new ArrayList<String>();


       // serverPollTimer.schedule(new TimerTask() {
         //   @Override
           // public void run() {
             //   datamodel.this.add_mes("Message "+ Calendar.getInstance().get(Calendar.MINUTE));
          //  }
        //},0,5000);
    }
    public int getCount()
    {
        return count;
    }


    public String get_email()
    {

        return email;

    }
    public void set_email(String mess)
    {
        email=mess;


    }
    public String get_location()
    {

        return location;

    }
    public void set_location(String mess)
    {
        location=mess;


    }
    public void remove_mes(int mess_index)
    {

        _messages.remove(mess_index);

    }

    public void  set_Count (int mess)
    {
        count=mess;


    }

    public String get_phone()
    {

        return cout;

    }
    public void set_phone(String mess)
    {
        cout=mess;


    }
    static  public int z=0;
    static public String cout="19019";
    static public String opening="-10:00am to 11:30pm";
    static  public int count=10;
    static public String email="-booklet.dokki@gmail.com";
    static public String book="https://www.bookrix.com/book.html?bookID=melodymw_1370471902.7112340927#0,486,430272";
    static public String reserve="https://www.youtube.com";

}
