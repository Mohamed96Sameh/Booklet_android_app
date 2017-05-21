package com.example.mohamed.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int z;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int checkdis=0;
        SharedPreferences sharedPref = getSharedPreferences("discount", Context.MODE_PRIVATE);
        checkdis=sharedPref.getInt("discount",-1) ;
        Button checkdiscount;
        checkdiscount=(Button)findViewById(R.id.button5);
        if(checkdis==0){
            checkdiscount.setEnabled(false);
        }


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
    AlertDialog dialog;
    private static Button discount ;
    TextView att;
    datamodel countof_discount;
    public void getdiscount(View view) {
        // Do something in response to button
        dialog=new AlertDialog.Builder(this).create();
        att= new TextView(this);
        dialog.setTitle("Discount");

        discount=(Button)findViewById(R.id.button5);
        int y;
        discount.setOnClickListener(new View.OnClickListener(){
                                          @Override

                                          public void onClick(View V)
                                          {

                                              int checkdis=0;
                                              SharedPreferences sharedPref = getSharedPreferences("discount", Context.MODE_PRIVATE);
                                              checkdis=sharedPref.getInt("discount",-1) ;

                                              if(checkdis<=-1)
                                              {
                                                  checkdis=countof_discount.getCount();

                                                  sharedPref = getSharedPreferences("discount", Context.MODE_PRIVATE);
                                                  SharedPreferences.Editor editor=sharedPref.edit();
                                                  editor.putInt("discount",checkdis);
                                                  editor.apply();
                                              }

                                              att.setText(" Are you sure you want to take the discount now!!     you have "+ checkdis +" remaining. ");
                                              dialog.setView(att);

                                              dialog.show();
                                          }


                                      }
        );

        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"Yes",new DialogInterface
                .OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {


                int checkdis=0;
                SharedPreferences sharedPref = getSharedPreferences("discount", Context.MODE_PRIVATE);
                checkdis=sharedPref.getInt("discount",-1) ;

               // if(checkdis2==-1)
                //{
                  //  checkdis2=countof_discount.count;
                //}
                if(countof_discount.getCount()<=0){
                    discount.setEnabled(false);
                }
              else{  checkdis-=1;
                countof_discount.set_Count(checkdis);
                sharedPref = getSharedPreferences("discount", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPref.edit();
                editor.putInt("discount",countof_discount.getCount());
                editor.apply();}
                if(countof_discount.getCount()<=0){
                    discount.setEnabled(false);
                }

            }
        });
    }
}


