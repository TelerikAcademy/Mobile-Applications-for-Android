package com.example.minkov.viewsdemos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.example.minkov.viewsdemos.game.objects.Bullet;
import com.example.minkov.viewsdemos.game.objects.Superhero;

import java.util.ArrayList;
import java.util.List;

public class SuperheroView extends View {
    private static final float SUPERHERO_WIDTH_SCALE_FACTOR = .25f;
    private List<Bullet> bullets;
    private Paint superheroPaint;
    private Paint bulletPaint;
    private static final int BULLET_SPEED = 20;
    private Superhero superhero;

    public SuperheroView(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.bullets = new ArrayList<>();
        this.superhero = new Superhero(0, 0);

        this.bulletPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.bulletPaint.setStrokeWidth(30);
        this.bulletPaint.setColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (Bullet bullet : this.bullets) {
            bullet.draw(canvas, this.bulletPaint);
        }
        this.superhero.draw(canvas, this.superheroPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.superhero.setWidth((int) (SUPERHERO_WIDTH_SCALE_FACTOR * w));
        this.superhero.update(getResources());
    }

    public void move(int y) {
        this.superhero.setY(y);
    }

    public List<Bullet> getBullets() {
        return new ArrayList<>(this.bullets);
    }

    public void createBullet() {
        Bullet bullet = new Bullet(this.superhero.getWidth(), this.superhero.getY(), 60, 15);
        this.bullets.add(bullet);
    }

    public void clearDestroyedBullets() {
        int index = -1;
        for (int i = 0; i < this.bullets.size(); i++) {
            Bullet bullet = this.bullets.get(i);
            if (bullet.isKilled() || bullet.getX() > this.getWidth()) {
                index = i;
                break;
            }
        }
        if (index > 0) {
            this.bullets.remove(index);
        }
    }

    public void updatePositions() {
        for (Bullet bullet : this.getBullets()) {
            bullet.setX(bullet.getX() + BULLET_SPEED);
        }
    }
}
