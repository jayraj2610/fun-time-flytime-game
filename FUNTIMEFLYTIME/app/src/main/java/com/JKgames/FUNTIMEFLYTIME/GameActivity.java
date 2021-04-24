package com.JKgames.FUNTIMEFLYTIME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.concurrent.Semaphore;

public class GameActivity extends AppCompatActivity {

    private GameView gameView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


       if(GameView.score==5){Toast.makeText(this,"start",Toast.LENGTH_SHORT).show();}

        if (com.JKgames.FUNTIMEFLYTIME.GameView.score == 200) {
            Toast.makeText(this, "LEVEL 1 complete!!", Toast.LENGTH_SHORT).show();
        }
        if (com.JKgames.FUNTIMEFLYTIME.GameView.score == 400) {
            Toast.makeText(this, "LEVEL 2 complete!!", Toast.LENGTH_SHORT).show();
        }

        if (com.JKgames.FUNTIMEFLYTIME.GameView.score == 600) {
            Toast.makeText(this, "LEVEL 3 complete!!", Toast.LENGTH_SHORT).show();
        }

        if (com.JKgames.FUNTIMEFLYTIME.GameView.score == 800) {
            Toast.makeText(this, "LEVEL 4 complete!!", Toast.LENGTH_SHORT).show();
        }

        if (com.JKgames.FUNTIMEFLYTIME.GameView.score == 1000) {
            Toast.makeText(this, "LEVEL 5 complete!!", Toast.LENGTH_SHORT).show();
        }





        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);




        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);

        gameView = new GameView(this, point.x, point.y);

        setContentView(gameView);

    }

    @Override
    protected void onPause() {


        super.onPause();


        PowerManager pm = (PowerManager)
                getSystemService(Context.POWER_SERVICE);
        boolean isScreenOn = false;
        if (pm != null) {
            isScreenOn = pm.isScreenOn();
        }

        if (!isScreenOn) {
            if (mServ != null) {
                mServ.pauseMusic();
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }
        }



        gameView.pause();



    }

    @Override
    protected void onResume() {








        super.onResume();
        gameView.resume();



    }



    private boolean mIsBound = false;
    private MusicService mServ;
    private ServiceConnection Scon =new ServiceConnection(){

        public void onServiceConnected(ComponentName name, IBinder
                binder) {
            mServ = ((MusicService.ServiceBinder)binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            mServ = null;
        }
    };

    void doBindService(){
        bindService(new Intent(this,MusicService.class),
                Scon,Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService()
    {
        if(mIsBound)
        {
            unbindService(Scon);
            mIsBound = false;
        }
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();

        doUnbindService();
        Intent music = new Intent();
        music.setClass(this,MusicService.class);
        stopService(music);

    }






}
