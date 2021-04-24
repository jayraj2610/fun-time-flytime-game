package com.JKgames.FUNTIMEFLYTIME;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



import com.JKgames.FUNTIMEFLYTIME.GameView;

public class GameView extends SurfaceView implements Runnable {







    private Thread thread;
    private boolean isPlaying, isGameOver = false;
  public static int screenX, screenY, score = 0;
    public static float screenRatioX, screenRatioY;
    private Paint paint;
    private Bird[] birds;
    private SharedPreferences prefs;
    private Random random;
    private SoundPool soundPool;
    private List<Bullet> bullets;
    private int sound;
    private Flight flight;
    private GameActivity activity;
    private Background background1, background2;

    public void Lvl1(View v){




    }




    public GameView(GameActivity activity, int screenX, int screenY) {
        super(activity);

        this.activity = activity;

        prefs = activity.getSharedPreferences("game", Context.MODE_PRIVATE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(audioAttributes)
                    .build();

        } else
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        sound = soundPool.load(activity, R.raw.shoot, 1);

        GameView.screenX = screenX;
        GameView.screenY = screenY;
        screenRatioX = 1920f / screenX;
        screenRatioY = 1080f / screenY;

        background1 = new Background(screenX, screenY, getResources());
        background2 = new Background(screenX, screenY, getResources());

        flight = new Flight(this, screenY, getResources());

        bullets = new ArrayList<>();

        background2.x = screenX;

        paint = new Paint();
        paint.setTextSize(128);
        paint.setColor(Color.WHITE);

        birds = new Bird[4];

        for (int i = 0;i < 4;i++) {

            Bird bird = new Bird(getResources());
            birds[i] = bird;

        }

        random = new Random();

    }

    @Override
    public void run() {

        while (isPlaying) {

            update ();
            draw ();
            sleep ();

        }

    }

    private void update () {


        background1.x -= 10 * screenRatioX;
        background2.x -= 10 * screenRatioX;

        if (background1.x + background1.background.getWidth() < 0) {
            background1.x = screenX;
        }

        if (background2.x + background2.background.getWidth() < 0) {
            background2.x = screenX;
        }

        if (flight.isGoingUp)
            flight.y -= 30 * screenRatioY;
        else
            flight.y += 30 * screenRatioY;

        if (flight.y < 0)
            flight.y = 0;

        if (flight.y >= screenY - flight.height)
            flight.y = screenY - flight.height;

        List<Bullet> trash = new ArrayList<>();

        for (Bullet bullet : bullets) {

            if (bullet.x > screenX)
                trash.add(bullet);

            bullet.x += 50 * screenRatioX;

            for (Bird bird : birds) {

                if (Rect.intersects(bird.getCollisionShape(),
                        bullet.getCollisionShape())) {




                    score++;




               //     com.JKgames.FUNTIMEFLYTIME.Bird.check();



                    if(com.JKgames.FUNTIMEFLYTIME.GameView.score==0) Bird.speed =  12;


                   else if (com.JKgames.FUNTIMEFLYTIME.GameView.score >00 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=50)
                        Bird.speed = (int) (12*screenRatioX);


                  else  if(com.JKgames.FUNTIMEFLYTIME.GameView.score >50 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=100)
                    {  Bird.speed = (int) (14*screenRatioX);}

                    else if(com.JKgames.FUNTIMEFLYTIME.GameView.score >100 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=150) {
                        Bird.speed = (int) (16 * screenRatioX);
                    }
                    else  if(com.JKgames.FUNTIMEFLYTIME.GameView.score >150 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=200)
                    { Bird.speed = (int) (17*screenRatioX);

                    }


                    else if(com.JKgames.FUNTIMEFLYTIME.GameView.score >200 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=250)
                        Bird.speed = (int) (18*screenRatioX);

                    else  if(com.JKgames.FUNTIMEFLYTIME.GameView.score >250 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=300)
                        Bird.speed = (int) (19*screenRatioX);

                    else if (com.JKgames.FUNTIMEFLYTIME.GameView.score >300 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=400)
                      { Bird.speed = (int) (20*screenRatioX);                  }

                    else if (com.JKgames.FUNTIMEFLYTIME.GameView.score >400 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=500)
                        Bird.speed = (int) (21*screenRatioX);

                    else if (com.JKgames.FUNTIMEFLYTIME.GameView.score >500 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=600)
                    {  Bird.speed = (int) (22*screenRatioX);          }

                    else if (com.JKgames.FUNTIMEFLYTIME.GameView.score >600 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=800)
                    { Bird.speed = (int) (23*screenRatioX);             }

                    else if (com.JKgames.FUNTIMEFLYTIME.GameView.score >800 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=1000)
                    {  Bird.speed = (int) (24*screenRatioX);          }

                    else if (com.JKgames.FUNTIMEFLYTIME.GameView.score >1000 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=1200)
                    {  Bird.speed = (int) (25*screenRatioX);               }


                    else Bird.speed = (int) (26*screenRatioX);


//  Tost.makeText(getActivity(),  message ,Tost.LENGTH_LONG).show();



                    bird.x = -500;
                    bullet.x = screenX + 500;
                    bird.wasShot = true;

                }

            }

        }

        for (Bullet bullet : trash)
            bullets.remove(bullet);

        for (Bird bird : birds) {

            bird.x -= Bird.speed;

            if (bird.x + bird.width < 0) {

                if (!bird.wasShot) {
                    isGameOver = true;
                    return;
                }

         //       int bound = (int) (25 * screenRatioX);
        //       bird.speed = (int) (( random.nextInt(bound))*0.085*Bird.speed);

        //      if (bird.speed < 10 * screenRatioX)
         //        bird.speed = (int)  (Bird.speed);

                bird.x = screenX;
                bird.y = random.nextInt(screenY - bird.height);

                bird.wasShot = false;
            }

            if (Rect.intersects(bird.getCollisionShape(), flight.getCollisionShape())) {

                isGameOver = true;
                return;
            }

        }

    }

    private void draw () {

        if (getHolder().getSurface().isValid()) {

            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(background1.background, background1.x, background1.y, paint);
            canvas.drawBitmap(background2.background, background2.x, background2.y, paint);

            for (Bird bird : birds)
                canvas.drawBitmap(bird.getBird(), bird.x, bird.y, paint);

            canvas.drawText(score + "", screenX / 2f, 164, paint);

            if (isGameOver) {
                isPlaying = false;
                canvas.drawBitmap(flight.getDead(), flight.x, flight.y, paint);
                getHolder().unlockCanvasAndPost(canvas);
                saveIfHighScore();
                waitBeforeExiting ();
                return;
            }

            canvas.drawBitmap(flight.getFlight(), flight.x, flight.y, paint);

            for (Bullet bullet : bullets)
                canvas.drawBitmap(bullet.bullet, bullet.x, bullet.y, paint);

            getHolder().unlockCanvasAndPost(canvas);

        }

    }

    private void waitBeforeExiting() {

        try {
            Thread.sleep(3000);
            activity.startActivity(new Intent(activity, MainActivity.class));
            activity.finish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void saveIfHighScore() {

        if (prefs.getInt("highscore", 0) < score)
        {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("highscore", score);
            editor.apply();
        }

    }

    private void sleep () {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume () {

        isPlaying = true;
        thread = new Thread(this);
        thread.start();

    }

    public void pause () {



        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (event.getX() < screenX / 2) {
                    flight.isGoingUp = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                flight.isGoingUp = false;
                if (event.getX() > screenX / 2)
                    flight.toShoot++;
                break;
        }

        return true;
    }

    public void newBullet() {

        if (!prefs.getBoolean("isMute", false))
            soundPool.play(sound, 1, 1, 0, 0, 1);

        Bullet bullet = new Bullet(getResources());
        bullet.x = flight.x + flight.width;
        bullet.y = flight.y + (flight.height / 2);
        bullets.add(bullet);

    }
}
