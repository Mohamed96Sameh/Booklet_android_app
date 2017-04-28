package com.example.mohamed.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private static Button buttonsbm ;
    public void sendMessage(View view) {
        // Do something in response to button

        buttonsbm=(Button)findViewById(R.id.button3);
        buttonsbm.setOnClickListener(

                new View.OnClickListener(){
                    @Override

                        public void onClick(View V)
                        {
                            Intent intent = new Intent (MainActivity.this,contact_info.class);
                            MainActivity.this.startActivity(intent);

                        }


                }
        );
    }
    private static ImageButton buttonsbm9 ;
    public void sendMessage3(View view) {
        // Do something in response to button

        buttonsbm9=(ImageButton)findViewById(R.id.imageButton2);
        buttonsbm9.setOnClickListener(

                new View.OnClickListener(){
                    @Override

                    public void onClick(View V)
                    {


                        Intent intent = new Intent (MainActivity.this,p4.class);
                        MainActivity.this.startActivity(intent);

                    }


                }
        );
    }

    private static Button buttonsbm2 ;
    public void sendMessage2(View view) {
        // Do something in response to button

        buttonsbm2=(Button)findViewById(R.id.button4);
        buttonsbm2.setOnClickListener(new View.OnClickListener(){
                                         @Override

                                         public void onClick(View V)
                                         {
                                             //  Intent intent = new Intent (MainActivity.this,contact_info.class);

                                             //MainActivity.this.startActivity(intent);
                                             Intent intent = new Intent();
                                             intent.setAction(Intent.ACTION_VIEW);
                                             intent.addCategory(Intent.CATEGORY_BROWSABLE);
                                             intent.setData(Uri.parse("http://www.youtube.com"));
                                             startActivity(intent);
                                         }


                                     }
        );
    }


}


