package com.example.minkov.viewsdemos.game.objects;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/**
 * Created by minkov on 2/22/17.
 */

public class Bullet extends DrawableShape {
    public Bullet(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawLine(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY(), paint);
    }
}
