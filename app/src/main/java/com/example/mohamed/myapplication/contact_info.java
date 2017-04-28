package com.example.mohamed.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class contact_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_contact_info);
    }

    private static Button buttonsbm2 ;
    public void facebook(View view) {
        // Do something in response to button

        buttonsbm2=(Button)findViewById(R.id.button5);
        buttonsbm2.setOnClickListener(new View.OnClickListener(){
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

}
