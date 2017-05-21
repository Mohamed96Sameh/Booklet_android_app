package com.example.mohamed.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class contact_info extends AppCompatActivity {
       TextView homeph,email,open;
    datamodel info;
    String chec=null;
    String checemail=null;
    String checopen=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_contact_info);
        homeph=(TextView) findViewById(R.id.textView4);
        email=(TextView) findViewById(R.id.textView55);
        open=(TextView) findViewById(R.id.textView99);
        info =new datamodel();
        SharedPreferences sharedPref = getSharedPreferences("phone", Context.MODE_PRIVATE);
        chec=sharedPref.getString("phone", "");

        if(chec.equals(null))
        {
            chec=info.cout;
        }
        homeph.setText(chec);
        SharedPreferences sharedPref2 = getSharedPreferences("email", Context.MODE_PRIVATE);
        checemail=sharedPref2.getString("email", "");

        if(checemail.equals(""))
        {
            checemail=info.email;
        }

        info.email=checemail;
        email.setText(checemail);
        SharedPreferences sharedPref3 = getSharedPreferences("open", Context.MODE_PRIVATE);
        checopen=sharedPref3.getString("open", "");

        if(checopen.equals(""))
        {
            checopen=info.opening;
        }
        info.opening=checopen;
        open.setText(info.opening);
    }

    private static Button buttonsbm29 ;
    public void facebook(View view) {
        // Do something in response to button

        buttonsbm29=(Button)findViewById(R.id.button7);
        buttonsbm29.setOnClickListener(new View.OnClickListener(){
                                          @Override

                                          public void onClick(View V)
                                          {
                                              //  Intent intent = new Intent (MainActivity.this,contact_info.class);

                                              //MainActivity.this.startActivity(intent);
                                              Intent intent = new Intent();
                                              intent.setAction(Intent.ACTION_VIEW);
                                              intent.addCategory(Intent.CATEGORY_BROWSABLE);
                                              intent.setData(Uri.parse("https://www.facebook.com/BookletCoworkingspace/"));
                                              startActivity(intent);
                                          }


                                      }
        );
    }



    private static ImageButton buttonsbm ;
    public void instagram(View view) {
        // Do something in response to button

        buttonsbm=(ImageButton)findViewById(R.id.imageButton);
        buttonsbm.setOnClickListener(new View.OnClickListener(){
                                          @Override

                                          public void onClick(View V)
                                          {
                                              //  Intent intent = new Intent (MainActivity.this,contact_info.class);

                                              //MainActivity.this.startActivity(intent);
                                              Intent intent = new Intent();
                                              intent.setAction(Intent.ACTION_VIEW);
                                              intent.addCategory(Intent.CATEGORY_BROWSABLE);
                                              intent.setData(Uri.parse("https://www.instagram.com/booklet_bookstore/?hl=en"));
                                              startActivity(intent);
                                          }


                                      }
        );
    }

    private static ImageButton buttonsbm74 ;
    public void map(View view) {
        // Do something in response to button

        buttonsbm=(ImageButton)findViewById(R.id.imageButton5);
        buttonsbm.setOnClickListener(new View.OnClickListener(){
                                         @Override

                                         public void onClick(View V)
                                         {
                                             //  Intent intent = new Intent (MainActivity.this,contact_info.class);

                                             //MainActivity.this.startActivity(intent);
                                             Intent intent = new Intent();
                                             intent.setAction(Intent.ACTION_VIEW);
                                             intent.addCategory(Intent.CATEGORY_BROWSABLE);
                                             intent.setData(Uri.parse("https://www.google.com.eg/maps/place/Booklet+Book+Store/@30.0307377,31.2114307,16.35z/data=!4m5!3m4!1s0x145846d717882639:0xeeffbb209b4ecb3c!8m2!3d30.030936!4d31.212679"));
                                             startActivity(intent);
                                         }


                                     }
        );
    }

}
