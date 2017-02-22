package com.example.minkov.viewsdemos.game.objects;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class DrawableShape implements IShape {
    private static int lastId = 0;
    private final int id;
    private int x;
    private int y;
    private int height;
    private int width;
    private boolean isKilled;

    public DrawableShape(int x, int y, int width, int height) {
        this.id = ++lastId;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setIsKilled(boolean isKilled) {
        this.isKilled = isKilled;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DrawableShape)) {
            return false;
        }

        return this.getId() == ((DrawableShape) obj).getId();
    }

    public abstract void draw(Canvas canvas, Paint paint);

}
