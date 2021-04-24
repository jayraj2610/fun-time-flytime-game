package com.JKgames.FUNTIMEFLYTIME;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.CountDownTimer;
import com.JKgames.FUNTIMEFLYTIME.GameView;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import static com.JKgames.FUNTIMEFLYTIME.GameView.screenRatioX;
import static com.JKgames.FUNTIMEFLYTIME.GameView.screenRatioY;





public class Bird {




    public static int  speed = 12;






    public static void check(){




    if(com.JKgames.FUNTIMEFLYTIME.GameView.score==0) speed=  12;
    else

if (com.JKgames.FUNTIMEFLYTIME.GameView.score >00 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=50)
           speed=12;
       else

       if(com.JKgames.FUNTIMEFLYTIME.GameView.score >50 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=100)
           speed=14;
           else
       if(com.JKgames.FUNTIMEFLYTIME.GameView.score >100 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=150)
           speed=16;
       else
       if(com.JKgames.FUNTIMEFLYTIME.GameView.score >150 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=200)
           speed=17;
       else
       if(com.JKgames.FUNTIMEFLYTIME.GameView.score >200 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=250)
           speed=18;
       else
       if(com.JKgames.FUNTIMEFLYTIME.GameView.score >250 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=300)
           speed=19;
       else if (com.JKgames.FUNTIMEFLYTIME.GameView.score >300 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=400)
            speed=20;
       else if (com.JKgames.FUNTIMEFLYTIME.GameView.score >400 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=500)
           speed=21;
       else if (com.JKgames.FUNTIMEFLYTIME.GameView.score >500 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=600)
           speed=22;
       else if (com.JKgames.FUNTIMEFLYTIME.GameView.score >600 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=800)
           speed=23;
       else if (com.JKgames.FUNTIMEFLYTIME.GameView.score >800 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=1000)
           speed=24;
       else if (com.JKgames.FUNTIMEFLYTIME.GameView.score >1000 && com.JKgames.FUNTIMEFLYTIME.GameView.score<=1200)
           speed=25;

else speed=26;

   }


    public boolean wasShot = true;
    int x = 0, y, width, height, birdCounter = 1;
    Bitmap bird1, bird2, bird3, bird4,bird5,bird6,bird7,bird8,bird9,bird10,bird11;

    Bird (Resources res) {




        bird1 = BitmapFactory.decodeResource(res, R.drawable.bird1);
        bird2 = BitmapFactory.decodeResource(res, R.drawable.bird2);
        bird3 = BitmapFactory.decodeResource(res, R.drawable.bird3);
        bird4 = BitmapFactory.decodeResource(res, R.drawable.bird4);
       bird5 = BitmapFactory.decodeResource(res, R.drawable.bird5);
        bird6 = BitmapFactory.decodeResource(res, R.drawable.bird6);
        bird7 = BitmapFactory.decodeResource(res, R.drawable.bird7);
        bird8 = BitmapFactory.decodeResource(res, R.drawable.bird8);
        bird9 = BitmapFactory.decodeResource(res, R.drawable.bird9);
        bird10 = BitmapFactory.decodeResource(res, R.drawable.bird10);
        bird11 = BitmapFactory.decodeResource(res, R.drawable.bird11);



        width = bird1.getWidth();
        height = bird1.getHeight();

        width /= 6;
        height /= 6;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        bird1 = Bitmap.createScaledBitmap(bird1, width, height, false);
        bird2 = Bitmap.createScaledBitmap(bird2, width, height, false);
        bird3 = Bitmap.createScaledBitmap(bird3, width, height, false);
        bird4 = Bitmap.createScaledBitmap(bird4, width, height, false);
        bird5 = Bitmap.createScaledBitmap(bird5, width, height, false);
        bird6 = Bitmap.createScaledBitmap(bird6, width, height, false);
        bird7 = Bitmap.createScaledBitmap(bird7, width, height, false);
        bird8 = Bitmap.createScaledBitmap(bird8, width, height, false);
        bird9 = Bitmap.createScaledBitmap(bird9, width, height, false);
        bird10 = Bitmap.createScaledBitmap(bird10, width, height, false);
        bird11 = Bitmap.createScaledBitmap(bird11, width, height, false);
        y = -height;
    }

    Bitmap getBird () {


        if (birdCounter == 1) {
            birdCounter++;
            return bird1;
        }

        if (birdCounter == 2) {
            birdCounter++;
            return bird2;
        }

        if (birdCounter == 3) {
            birdCounter++;
            return bird3;
        }

       if (birdCounter == 4) {
            birdCounter++;
            return bird4;
        }
       if (birdCounter == 5) {
            birdCounter++;
            return bird5;
        }
        if (birdCounter == 6) {
            birdCounter++;
            return bird6;
        }
        if (birdCounter == 7) {
            birdCounter++;
            return bird7;
        }

        if (birdCounter == 8) {
            birdCounter++;
            return bird8;
        }


        if (birdCounter == 9) {
            birdCounter++;
            return bird9;
        }
        if (birdCounter == 10) {
            birdCounter++;
            return bird10;
        }




        birdCounter = 1;

    return bird11;
    }

    Rect getCollisionShape () {
        return new Rect(x, y, x + width, y + height);
    }

}
