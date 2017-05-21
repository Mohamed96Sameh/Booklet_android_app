package com.example.mohamed.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class contact_admin extends AppCompatActivity{//extends Activity implements ListAdapter {
    datamodel mess=null;
    //ListView messlist=null;
    int swcase=0;
    TextView phone1,email,location,open;
    AlertDialog dialog2,dialog4;
String check=null;
    String checkemail=null;
    String checkopen=null;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mess=new datamodel();
        setContentView(R.layout.activity_contact_admin);
        phone1=(TextView) findViewById(R.id.tex44);
        location=(TextView) findViewById(R.id.textView11);
        email=(TextView) findViewById(R.id.textView55);
        open=(TextView) findViewById(R.id.textView99);

        ////////////////////////////////////////////////////////////////

            SharedPreferences sharedPref = getSharedPreferences("phone", Context.MODE_PRIVATE);
            check=sharedPref.getString("phone", "");
        SharedPreferences sharedPref2 = getSharedPreferences("email", Context.MODE_PRIVATE);
        checkemail=sharedPref2.getString("email", "");
        SharedPreferences sharedPref3 = getSharedPreferences("open", Context.MODE_PRIVATE);
        checkopen=sharedPref3.getString("open", "");
        //location.setText(mess.location);
if(check.equals(0))
{
    check=mess.cout;
}

else if(check.equals(""))
{
    check=mess.cout;
}
        if(checkemail.equals(0))
        {
            checkemail=mess.email;
        }

        else if(checkemail.equals(""))
        {
            checkemail=mess.email;
        }
        if(checkopen.equals(0))
        {
            checkopen=mess.opening;
        }

        else if(checkopen.equals(""))
        {
            checkopen=mess.opening;
        }
        email.setText(checkemail);
        dialog2=new AlertDialog.Builder(this).create();
        dialog4=new AlertDialog.Builder(this).create();
        editText= new EditText(this);

        dialog2.setTitle("EDIT TEXT!");
        dialog2.setView(editText);
        phone1.setText(check);
        open.setText(checkopen);
        dialog2.setButton(DialogInterface.BUTTON_POSITIVE,"Update",new DialogInterface
                .OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
              if(swcase==1){
                mess.z=1;
                if(editText.getText().toString().length()==11||editText.getText().toString().length()==11) {
                    SharedPreferences sharedPref = getSharedPreferences("phone", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("phone", editText.getText().toString());
                    editor.apply();
                    mess.cout=editText.getText().toString();      //editText.getText();
                    phone1.setText(mess.cout);
                }
                else {  dialog4.setTitle("Error enter correct number of digits ");

                    dialog4.show();
                    dialog4.setButton(DialogInterface.BUTTON_POSITIVE,"Cancel",new DialogInterface
                            .OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                });
                }}
                else if(swcase==2){
                  //  mess.z=1;
                    SharedPreferences sharedPref = getSharedPreferences("email", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPref.edit();
                    editor.putString("email",editText.getText().toString());
                    editor.apply();

                    mess.email=editText.getText().toString();      //editText.getText();
                    email.setText(mess.email);}
              else if(swcase==3){
                  //  mess.z=1;
                  SharedPreferences sharedPref = getSharedPreferences("open", Context.MODE_PRIVATE);
                  SharedPreferences.Editor editor=sharedPref.edit();
                  editor.putString("open",editText.getText().toString());
                  editor.apply();

                  mess.opening=editText.getText().toString();      //editText.getText();
                  open.setText(mess.opening);}

            }

                });
        phone1.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                swcase=1;
                editText.setText(phone1.getText());
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                dialog2.show();

            }
        });
        email.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                swcase=2;
                editText.setText(email.getText());
                editText.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

                dialog2.show();

            }
        });
        open.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                swcase=3;
                editText.setText(open.getText());
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
                dialog2.show();

            }
        });



    }

}
