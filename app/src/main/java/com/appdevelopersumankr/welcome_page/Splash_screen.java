package com.appdevelopersumankr.welcome_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class Splash_screen extends AppCompatActivity {

    Launcher_Manager launcher_manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        requestWindowFeature ( Window.FEATURE_NO_TITLE);
        this.getWindow ().setFlags ( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView ( R.layout.activity_splash_screen );

        launcher_manager=new Launcher_Manager ( this);



        new Handler ().postDelayed ( new Runnable () {
            @Override
            public void run() {
                if (launcher_manager.isfirsttime ()){
                    launcher_manager.setFirstLaunch ( false );
                    startActivity ( new Intent (Splash_screen.this,Slider.class) );
                    finish ();
                }else {
                    startActivity ( new Intent (Splash_screen.this,MainActivity.class) );
                    finish ();
                }

            }
        },2000 );
    }
}