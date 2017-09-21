package com.example.minkov.viewsdemos.game.objects;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by minkov on 2/22/17.
 */

public class Enemy extends DrawableShape {
    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawCircle(this.getX(), this.getY(), this.getWidth(), paint);
    }
}
