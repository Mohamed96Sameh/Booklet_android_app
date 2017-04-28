package com.example.mohamed.myapplication;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class login extends AppCompatActivity {
CallbackManager callbackManager;
    LoginButton login_button;
    TextView log;
    Button cont;
    Boolean state=false;
    int x=0;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);
        intializeControls();


         loginWithFB();


         PackageInfo info;

         try {
             info = getPackageManager().getPackageInfo("com.you.name", PackageManager.GET_SIGNATURES);
             for (Signature signature : info.signatures) {
                 MessageDigest md;
                 md = MessageDigest.getInstance("SHA");
                 md.update(signature.toByteArray());
                 String something = new String(Base64.encode(md.digest(), 0));
                 //String something = new String(Base64.encodeBytes(md.digest()));
                 Log.e("hash key", something);
             }
         } catch (PackageManager.NameNotFoundException e1) {
             Log.e("name not found", e1.toString());
         } catch (NoSuchAlgorithmException e) {
             Log.e("no such an algorithm", e.toString());
         } catch (Exception e) {
             Log.e("exception", e.toString());
         }

     }
    private void   intializeControls(){
        callbackManager= CallbackManager.Factory.create();
        login_button=(LoginButton) findViewById(R.id.login_button);
        log=(TextView) findViewById(R.id.textView8);
        cont=(Button)findViewById(R.id.button2);
        cont.setEnabled(false);

    }

    private void loginWithFB(){

        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                        state=true;
                cont.setEnabled(true);
                log.setText("Login success\n"+loginResult.getAccessToken());
                Intent intent = new Intent (login.this,MainActivity.class);
                login.this.startActivity(intent);

            }

            @Override
            public void onCancel() {
                log.setText("Login .");

            }

            @Override
            public void onError(FacebookException error) {
                log.setText("Login error:"+error.getMessage());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);


    }
    public void sendMessage4(View view) {
        // Do something in response to button


        cont.setOnClickListener(

                new View.OnClickListener(){
                    @Override

                    public void onClick(View V)
                    {
                        Intent intent = new Intent (login.this,MainActivity.class);
                        login.this.startActivity(intent);

                    }


                }
        );
    }
    private static LoginButton but ;
    public void sendMessag(View view) {
        // Do something in response to button

        but=(LoginButton)findViewById(R.id.login_button);
        but.setOnClickListener(

                new View.OnClickListener(){
                    @Override

                    public void onClick(View V)
                    {

                        if (state) {
        state = false;
        cont.setEnabled(false);
        log.setText("done .");
    }
                    }


                }
        );
    }
}
