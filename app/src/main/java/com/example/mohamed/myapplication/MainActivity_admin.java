package com.example.mohamed.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.apache.http.params.HttpParams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static android.R.attr.bitmap;


public class MainActivity_admin extends AppCompatActivity {
    ImageButton editpost;
    Button test,test2;
    datamodel obj;
    AlertDialog dialog;
    String check=null;
    String checkopen=null;
    EditText editText;
    String book_link;
    int m=0;
            TextView buttonsbm700,text;
    private static final int RESULT_LOAD_IMAGE =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);
        editpost=(ImageButton) findViewById(R.id.imageButton4);
        test=(Button) findViewById(R.id.button4) ;
        buttonsbm700=(TextView) findViewById(R.id.textView);
        text=(TextView) findViewById(R.id.textView6);
        dialog=new AlertDialog.Builder(this).create();
        editText= new EditText(this);
        dialog.setView(editText);
        dialog.setTitle("Edit URL");
        ////////////////////////////////////////////////////////////////

        SharedPreferences sharedPref = getSharedPreferences("book", Context.MODE_PRIVATE);
        check=sharedPref.getString("book", "");

        SharedPreferences sharedPref2 = getSharedPreferences("reservelink", Context.MODE_PRIVATE);
        checkopen=sharedPref2.getString("reservelink", "");
        if(check.equals(0))
        {
            check=obj.book;

        }

        else if(check.equals(""))
        {
            check=obj.book;

        }
        else
        {
            obj.book=check;
        }
        if(checkopen.equals(0))
        {
            checkopen=obj.reserve;

        }

        else if(checkopen.equals(""))
        {
            checkopen=obj.reserve;

        }
        else
        {
            obj.reserve=checkopen;
        }
        book_link=obj.book;
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"Update",new DialogInterface
                .OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {


                    if(m==1){
                    SharedPreferences sharedPref = getSharedPreferences("book", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPref.edit();
                    editor.putString("book",editText.getText().toString());
                    editor.apply();

                    obj.book=editText.getText().toString();      //editText.getText();
                   book_link=obj.book;  }

                    else if(m==2)
                    {
                        SharedPreferences sharedPref2 = getSharedPreferences("reservelink", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPref2.edit();
                        editor.putString("reservelink",editText.getText().toString());
                        editor.apply();

                        obj.reserve=editText.getText().toString();      //editText.getText();
                          }

            }     });


        buttonsbm700.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {

                editText.setText(books.book);
               m=1;
                dialog.show();

            }
        });
        text.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {

                editText.setText(books.reserve);
                m=2;
                dialog.show();
            }
        });

    }
    public void sendMessage(View view) {
        // Do something in response to button


        editpost.setOnClickListener(

                new View.OnClickListener(){
                    @Override

                    public void onClick(View V)
                    {
                        Intent gallery =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(gallery,RESULT_LOAD_IMAGE);
                     //   Bitmap image=((BitmapDrawable) editpost.getDrawable()).getBitmap();
                    }


                }
        );
    }

   // Bitmap imag=((BitmapDrawable) editpost.getDrawable()).getBitmap();
    @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==RESULT_LOAD_IMAGE && resultCode==RESULT_OK && data !=null)
        {   Uri selectedIamge =data.getData();
            editpost.setImageURI(selectedIamge);

            //SharedPreferences shared = getSharedPreferences("App_settings", MODE_PRIVATE);
            //SharedPreferences.Editor editor = shared.edit();
           // editor.putString("PRODUCT_PHOTO", encodeTobase64(imag));
            //editor.commit();
          //  File file = new File(getRealPathFromURI(selectedIamge));
         /*   if (file.exists()) {

                Drawable d = Drawable.createFromPath(file.getAbsolutePath());
                editpost.setBackgroundDrawable(d);
                    obj.pic=d;
            }

     /*       SharedPreferences sharedPref ;
            sharedPref = getSharedPreferences("post", 0);
            SharedPreferences.Editor editor=sharedPref.edit();
            editor.putString("post",uriStr);
            editor.commit();

            SharedPreferences sharedPref2 ;
            sharedPref2 = getSharedPreferences("post", 0);
            SharedPreferences.Editor editor2=sharedPref.edit();
            editor.putString("post",z);
            editor.commit();

            test2=(Button) findViewById(R.id.button3) ;
            test2.setEnabled(false);
            */
        }
    }
datamodel books=new datamodel();
    public void  getImage()
    {
        // To open up a gallery browser
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),1);
        // To handle when an image is selected from the browser, add the following to your Activity
    }

    private String getRealPathFromURI(Uri contentURI) {
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            return contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(idx);
        }
    }

    private static Button buttonsbm ;
    public void editcontact(View view) {
        // Do something in response to button

        buttonsbm=(Button)findViewById(R.id.button3);
        buttonsbm.setOnClickListener(

                new View.OnClickListener(){
                    @Override

                    public void onClick(View V)
                    {
                        Intent intent = new Intent (MainActivity_admin.this,contact_admin.class);
                        MainActivity_admin.this.startActivity(intent);

                    }


                }
        );
    }
    private static ImageButton buttons22 ;
    public void editreservationlink(View view) {
        // Do something in response to button

        buttons22=(ImageButton)findViewById(R.id.imageButton3);
        buttons22.setOnClickListener(

                new View.OnClickListener(){
                    @Override

                    public void onClick(View V)
                    {
                        Intent intent = new Intent (MainActivity_admin.this,contact_admin.class);
                        MainActivity_admin.this.startActivity(intent);

                    }


                }
        );
    }
    }

