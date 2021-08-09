package com.appdevelopersumankr.welcome_page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Slider extends AppCompatActivity {
    ViewPager viewPager;
    AppCompatButton btnnext;
    int[] layouts;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

        requestWindowFeature ( Window.FEATURE_NO_TITLE);
        this.getWindow ().setFlags ( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );

        setContentView ( R.layout.activity_slider );

        viewPager=findViewById ( R.id.viewpagerid);
        btnnext=findViewById ( R.id.nextbuttonid);

        layouts=new int[]{
          R.layout.slider1,
          R.layout.slider2,
          R.layout.slider3,
          R.layout.slider4,
        };
        adapter=new Adapter ( this,layouts );
        viewPager.setAdapter ( adapter );

        btnnext.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (viewPager.getCurrentItem ()+1<layouts.length){
                    viewPager.setCurrentItem ( viewPager.getCurrentItem ()+1 );
                }else {
                    startActivity ( new Intent (Slider.this,MainActivity.class) );
                }
            }
        } );
          viewPager.addOnPageChangeListener ( onPageChangeListener );
    }
    ViewPager.OnPageChangeListener onPageChangeListener=new ViewPager.OnPageChangeListener () {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position==layouts.length-1){
                btnnext.setText ( "Continue" );
            }else {
                btnnext.setText ( "Next" );
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}