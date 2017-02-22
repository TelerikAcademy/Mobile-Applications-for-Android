package com.example.minkov.viewsdemos.game.objects;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.minkov.viewsdemos.R;

/**
 * Created by minkov on 2/22/17.
 */

public class Superhero extends DrawableShape {
    private static final int RESOURCE_ID = R.drawable.ironman;

    private Bitmap bitmap;


    public Superhero(int x, int y) {
        super(x, y, 0, 0);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawBitmap(this.bitmap, this.getX(), this.getY(), paint);
    }

    public void update(Resources resouces) {
        this.bitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resouces, RESOURCE_ID),
                this.getWidth(),
                this.getWidth(),
                false);
    }
}
