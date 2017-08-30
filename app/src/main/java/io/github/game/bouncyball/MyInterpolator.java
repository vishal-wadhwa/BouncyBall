package io.github.game.bouncyball;

import android.view.animation.AccelerateInterpolator;

/**
 * Created by Lenovo on 13-Aug-16.
 */
public class MyInterpolator extends AccelerateInterpolator {

    public MyInterpolator() {
    }

    public MyInterpolator(float factor) {
        super(factor);
    }

    @Override
    public float getInterpolation(float input) {
        return super.getInterpolation(input);
    }
}
