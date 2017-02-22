package com.example.minkov.viewsdemos;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minkov.viewsdemos.game.colliders.ICollisionDetector;
import com.example.minkov.viewsdemos.game.colliders.SimpleCollisionDetector;
import com.example.minkov.viewsdemos.game.objects.Bullet;
import com.example.minkov.viewsdemos.game.objects.Enemy;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    private static final float CREATE_ENEMY_CHANCE = 5;

    private EnemiesView enemiesView;
    private SuperheroView superheroView;

    private ICollisionDetector detector;
    private int score;
    private TextView tvScore;

    private TimerTask enemiesTask;
    private Timer enemiesTimer;

    private Timer superheroTimer;
    private TimerTask superheroTask;
    private Timer engineTimer;

    private TimerTask engineTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvScore = (TextView) this.findViewById(R.id.tvScore);

        this.detector = new SimpleCollisionDetector();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ImageView bg = (ImageView) this.findViewById(R.id.imgBg);
        bg.setScaleType(ImageView.ScaleType.FIT_XY);

        this.superheroView = new SuperheroView(this);
        ViewGroup containerSuperhero = ((ViewGroup) this.findViewById(R.id.container_superhero));
        containerSuperhero.addView(this.superheroView);
        containerSuperhero.setOnTouchListener(this);

        this.superheroTimer = new Timer();
        this.superheroTask = new SuperheroTimerTask();
        this.superheroTimer.scheduleAtFixedRate(this.superheroTask, 0, 10);

        this.enemiesView = new EnemiesView(this);
        ViewGroup containerEnemies = ((ViewGroup) this.findViewById(R.id.container_enemies));
        containerEnemies.addView(this.enemiesView);

        this.enemiesTimer = new Timer();
        this.enemiesTask = new EnemiesTimerTask();
        this.enemiesTimer.scheduleAtFixedRate(enemiesTask, 0, 10);

        this.findViewById(R.id.btnFire)
                .setOnClickListener(this);

        this.engineTimer = new Timer();
        this.engineTask = new EngineTimerTask();
        this.engineTimer.scheduleAtFixedRate(this.engineTask, 0, 100);
    }

    private void updateScore(int raise) {
        this.score += raise;
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvScore.setText("Score: " + score);
            }
        });
    }

    private boolean shouldCreateEnemy() {
        int value = (int) (Math.random() * 100);
        return value < CREATE_ENEMY_CHANCE;
    }

    @Override
    public void onClick(View v) {
        superheroView.createBullet();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                superheroView.move(y);
                break;
        }

        return true;
    }

    public class EnemiesTimerTask extends TimerTask {
        @Override
        public void run() {
            enemiesView.clearKilledOrPassedEnemies();
            enemiesView.updatePositions();
            if (shouldCreateEnemy()) {
                enemiesView.createEnemy();
            }

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    enemiesView.invalidate();
                }
            });
        }
    }

    private class SuperheroTimerTask extends TimerTask{
        @Override
        public void run() {
            superheroView.clearDestroyedBullets();
            superheroView.updatePositions();

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    superheroView.invalidate();
                }
            });
        }
    }

    private class EngineTimerTask extends TimerTask {
        @Override
        public void run() {
            int enemiesHit = 0;
            for (Bullet bullet : superheroView.getBullets()) {
                for (Enemy enemy : enemiesView.getEnemies()) {
                    if (detector.areColliding(bullet, enemy)) {
                        enemy.setIsKilled(true);
                        bullet.setIsKilled(true);
                        ++enemiesHit;
                    }
                }
            }
            updateScore(enemiesHit * 5);
        }
    }
}
