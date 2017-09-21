package com.example.minkov.viewsdemos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.example.minkov.viewsdemos.game.objects.Enemy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minkov on 2/22/17.
 */

public class EnemiesView extends View {
    private static final int ENEMY_SPEED = -5;
    private static final int ENEMY_RADIUS = 30;
    private List<Enemy> enemies;
    private Paint enemyPaint;
    private int positionX;

    public EnemiesView(Context context) {
        super(context);
        init();
    }

    void init() {
        this.enemies = new ArrayList<>();
        this.enemyPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.enemyPaint.setColor(Color.RED);
        this.enemyPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (Enemy enemy : this.getEnemies()) {
            if (enemy.isKilled()) {
                continue;
            }

            canvas.drawCircle(enemy.getX(), enemy.getY(), ENEMY_RADIUS, this.enemyPaint);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.positionX = w;
    }

    public void createEnemy() {
        int x = this.positionX;
        int y = (int) (Math.random() * this.getHeight());
        Enemy newEnemy = new Enemy(x, y, ENEMY_RADIUS, ENEMY_RADIUS);
        this.enemies.add(newEnemy);
    }

    public void updatePositions() {
        for (Enemy enemy : this.enemies) {
            enemy.setX(enemy.getX() + ENEMY_SPEED);
        }
    }

    public void clearKilledOrPassedEnemies() {
        int index = -1;

        for (int i = 0; i < this.enemies.size(); i++) {
            Enemy enemy = this.enemies.get(i);
            if (enemy.getX() < 0 || enemy.isKilled()) {
                index = i;
            }
            enemy.setX(enemy.getX() + ENEMY_SPEED);
        }


        if (index >= 0) {
            this.enemies.remove(index);
        }
    }

    public List<Enemy> getEnemies() {
        return new ArrayList<>(this.enemies);
    }

    public void removeEnemy(Enemy enemy) {
        this.enemies.remove(enemy);
    }
}
