package com.example.implant;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.Window;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SplashActivity extends AppCompatActivity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);


        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                if (user != null) {
                    startActivity(new Intent(SplashActivity.this, HomepageActivity.class));
                } else {
                    Intent mainIntent = new Intent(SplashActivity.this,MainActivity2.class);
                    SplashActivity.this.startActivity(mainIntent);
                    SplashActivity.this.finish();
                    Toast.makeText(getApplicationContext(), "Please Login/Register", Toast.LENGTH_SHORT).show();
                }

            }
        }, SPLASH_DISPLAY_LENGTH);


    }
    
}