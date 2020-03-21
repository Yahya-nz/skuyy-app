package com.yahya.skuyy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    Animation addsplash, bottomtotop;
    ImageView applogo;
    TextView apptitle;

    String USERNAME_KEY = "username_key";
    String username_key = "";
    String username_key_new ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getUsernameLocal();

        //load animation
        addsplash = AnimationUtils.loadAnimation(this, R.anim.addsplash);
        bottomtotop = AnimationUtils.loadAnimation(this, R.anim.bottomtotop);

        //load element
        applogo = findViewById(R.id.applogo);
        apptitle = findViewById(R.id.apptitle);

        //run animation
        applogo.startAnimation(addsplash);
        apptitle.startAnimation(bottomtotop);
    }
    public void getUsernameLocal(){
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new = sharedPreferences.getString(username_key, "");
        if (username_key_new.isEmpty()){
            //membuat timer
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //menuju halamaan lain
                    Intent abc = new Intent(SplashScreen.this, Login.class);
                    startActivity(abc);
                    finish();
                }
            }, 4000);
        }
        else {
            //membuat timer
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //menuju halamaan lain
                    Intent abc = new Intent(SplashScreen.this, Beranda.class);
                    startActivity(abc);
                    finish();
                }
            }, 2000);
        }
    }
}
