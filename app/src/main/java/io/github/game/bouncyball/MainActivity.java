package io.github.game.bouncyball;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean flip=true;
    private NewImageView loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        loading= (NewImageView) findViewById(R.id.loading);
        PropertyValuesHolder phvAngle= PropertyValuesHolder.ofFloat("angle",360);
        PropertyValuesHolder phvRotate = PropertyValuesHolder.ofFloat("rotation",180);
        final ValueAnimator animator= ObjectAnimator.ofPropertyValuesHolder(loading,phvAngle,phvRotate);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(1000);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(4);
        animator.start();
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(MainActivity.this, "Done Loading.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,BounceTheBall.class));
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                if (flip) loading.setScaleX(-1);
                else loading.setScaleX(1);
                flip=!flip;
            }
        });


    }
}
