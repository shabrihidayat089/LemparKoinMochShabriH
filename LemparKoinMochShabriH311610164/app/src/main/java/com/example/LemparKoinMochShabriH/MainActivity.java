package com.example.LemparKoinMochShabriH;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;
import java.util.RandomAccess;

public class MainActivity extends AppCompatActivity {

    public static  final Random ACAK = new Random();
    private ImageView coin;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coin = (ImageView) findViewById(R.id.coin);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                flipcoin();
            }
        });
    }

    private void flipcoin() {
        Animation fadeout = new AlphaAnimation(1, 0);
        fadeout.setInterpolator(new AccelerateDecelerateInterpolator());
        fadeout.setDuration(1000);
        fadeout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                coin.setImageResource(ACAK.nextFloat() > 0.5f ? R.drawable.tails : R.drawable.heads);

                Animation fadein = new AlphaAnimation(1,0);
                fadein.setInterpolator(new DecelerateInterpolator());
                fadein.setDuration(3000);
                fadein.setFillAfter(true);

                coin.startAnimation(fadein);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        coin.startAnimation(fadeout);
    }
}