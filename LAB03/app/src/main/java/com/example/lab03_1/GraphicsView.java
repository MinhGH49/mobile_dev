package com.example.lab03_1;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class GraphicsView extends View{

    int x=0;
    int y=0;
    int d=100;
    int r=50;

    Bitmap[] frs = new Bitmap[6];
    int count=0;

    long last_tick = 0;
    long period=300;
    Context ctext;

    MediaPlayer mp;

    public GraphicsView(Context context) {
        super(context);
        ctext = context;
        frs[0] = BitmapFactory.decodeResource(getResources(), R.drawable.cat1);
        frs[1] = BitmapFactory.decodeResource(getResources(), R.drawable.cat2);
        frs[2] = BitmapFactory.decodeResource(getResources(), R.drawable.cat3);
        frs[3] = BitmapFactory.decodeResource(getResources(), R.drawable.cat4);
        frs[4] = BitmapFactory.decodeResource(getResources(), R.drawable.cat5);
        frs[5] = BitmapFactory.decodeResource(getResources(), R.drawable.cat6);
        mp = MediaPlayer.create(ctext, R.raw.sample);
        mp.start();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(x!=0 && y!=0) {
            int right = x+d;
            int bot = y+r;
            Rect r = new Rect(x,y,right,bot);
            Paint p = new Paint();
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.BLUE);
            canvas.drawRect(r, p);
        }

        if (count == 6) count = 0;
        long time = (System.currentTimeMillis() - last_tick);
        if (time >= period) {
            last_tick = System.currentTimeMillis();
            canvas.drawBitmap(frs[count], 40,40, new Paint());
            count++;
            postInvalidate();
        } else {
            canvas.drawBitmap(frs[count], 40,40, new Paint());
            postInvalidate();
        }

        //invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        x = (int) e.getX();
        y = (int) e.getY();
        count++;
        return super.onTouchEvent(e);
    }


}
