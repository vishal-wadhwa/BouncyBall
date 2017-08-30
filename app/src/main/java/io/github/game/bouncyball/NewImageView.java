package io.github.game.bouncyball;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Lenovo on 28-Jul-16.
 */
public class NewImageView extends View {
    private Paint paint;
    private float radius;
    private RectF rectF;
    private static final String TAG = "NewImageView";
    private float angle;
    public NewImageView(Context context) {
        super(context);
        init();
    }

    public NewImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array=context.obtainStyledAttributes(attrs,R.styleable.NewImageView);
        this.radius=array.getDimension(R.styleable.NewImageView_radius,100);
        array.recycle();
        init();
    }

    public NewImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint=new Paint();
        paint.setColor(Color.LTGRAY);
        paint.setStrokeWidth(8);
        paint.setStyle(Paint.Style.STROKE);
        rectF=new RectF();
    }

    @Override
    public void setRotation(float rotation) {
        super.setRotation(rotation);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width=getWidth()/2,height=getHeight()/2;
        rectF.set(width-radius,height-radius,width+radius,height+radius);
        canvas.drawArc(rectF,-90,angle,false,paint);
        Log.d(TAG,"onDraw:radius"+radius);
    }

    public void setAngle(float angle) {
        this.angle=angle;
        invalidate();
    }

    public void setRadius(float radius) {
        this.radius = radius;
        invalidate();
    }

    public float getAngle() {
        return angle;
    }

    public float getRadius() {
        return radius;
    }

    public void setColor(int color) {
        paint.setColor(color);
    }

}
