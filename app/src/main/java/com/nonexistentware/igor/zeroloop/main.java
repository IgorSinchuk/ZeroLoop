package com.nonexistentware.igor.zeroloop;

        import android.content.Intent;
        import android.graphics.Point;
        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Display;
        import android.view.KeyEvent;
        import android.view.MotionEvent;
        import android.view.View;
        import android.view.WindowManager;
        import android.widget.FrameLayout;
        import android.widget.ImageView;
        import android.widget.TextView;


        import com.immortalplayer.zeroloop.R;

        import java.util.Timer;
        import java.util.TimerTask;

public class main extends AppCompatActivity {

    private TextView scoreLabel;
    private TextView startLabel;


    //stopWatch

    //player
    private ImageView player;


    //background
    private ImageView earth;
    private ImageView planetblue;
    private ImageView planetpurple;
    private ImageView deathstar;
    private ImageView skull;
    private ImageView powerup;



    //size
    private int frameHeight;
    private int rocketSize;
    private int screenWidth;
    private int screenHeight;


    //position

    private int playerY;


    private int earthX;
    private int earthY;
    private int planetblueX;
    private int planetblueY;
    private int planetpurpleX;
    private int planetpurpleY;
    private int deathstarX;
    private int deathstarY;
    private int skullX;
    private int skullY;
    private int powerupX;
    private int powerupY;

    //speed
    /**private int rocketSpeed;
     private int planetSpeed;
     private int planet2Speed;
     private int planet3Speed;
     private int planet5Speed;
     private int meteorSpeed;
     private int spacecoinSpeed;
     private int spacecoinredSpeed;
     private int powerupSpeed;
     */



    //score
    private int score = 0;

    //font


    //initialize class
    private Handler handler = new Handler();
    private Timer timer = new Timer();

    //music (sfx)
    private music sfx;

    //static check
    private boolean actionFlag = false;
    private boolean startFlag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sfx = new music(this);

        scoreLabel = (TextView) findViewById(R.id.scoreLabel);
        startLabel = (TextView) findViewById(R.id.startLabel);


        player = (ImageView) findViewById(R.id.player);


        earth = (ImageView) findViewById(R.id.earth);
        planetblue = (ImageView) findViewById(R.id.planetblue);
        planetpurple = (ImageView) findViewById(R.id.planetpurple);
        deathstar = (ImageView) findViewById(R.id.deathstar);
        skull = (ImageView) findViewById(R.id.skull);
        powerup = (ImageView) findViewById(R.id.powerup);



        //custom font


        //get screen size
        WindowManager wm = getWindowManager();
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        screenWidth = size.x;
        screenHeight = size.y;

        //Nexus 4 width:768 height:1184

        /**rocketSpeed = Math.round(screenHeight/60f);
         planetSpeed= Math.round(screenWidth/60f);
         planet2Speed = Math.round(screenWidth/60f);
         planet3Speed = Math.round(screenWidth/60f);
         planet5Speed = Math.round(screenWidth/60f);
         spacecoinSpeed = Math.round(screenWidth/60f);
         spacecoinredSpeed = Math.round(screenWidth/60f);
         meteorSpeed = Math.round(screenWidth/60f);
         powerupSpeed = Math.round(screenWidth/60f);
         Log.v("SPEED_ROCKET", rocketSpeed+"");
         Log.v("SPEED_PLANET", planetSpeed+"");
         Log.v("SPEED_PLANET2", planet2Speed+"");
         Log.v("SPEED_PLANET3", planet3Speed+"");
         Log.v("SPEED_PLANET5", planet5Speed+"");
         Log.v("SPEED_SPACECOIN", spacecoinSpeed+"");
         Log.v("SPEED_SPACECOINRED", spacecoinredSpeed+"");
         Log.v("SPEED_METEOR", meteorSpeed+"");
         Log.v("SPEED_POWERUP", powerupSpeed+"");
         */



        //move to out of screen
        earth.setX(-80f);
        earth.setY(-80f);
        planetblue.setX(-80f);
        planetblue.setY(-80f);
        planetpurple.setX(-80f);
        planetpurple.setY(-80f);
        deathstar.setX(-80f);
        deathstar.setY(-80f);
        skull.setX(-80f);
        skull.setY(-80f);
        powerup.setX(-80f);
        powerup.setY(-80f);

        scoreLabel.setText("Score : 0");


    }

    public void changePos() {

        hitCheck();

        //background objects
        //earth
        earthX -= 5;
        if (earthX < 0) {
            earthX = screenWidth + 510;
            earthY = (int) Math.floor(Math.random() * (frameHeight - earth.getHeight()));
        }
        earth.setX(earthX);
        earth.setY(earthY);

        //planetblue
        planetblueX -= 3;
        if (planetblueX < 0) {
            planetblueX = screenWidth + 810;
            planetblueY = (int) Math.floor(Math.random() * (frameHeight - planetblue.getHeight()));
        }
        planetblue.setX(planetblueX);
        planetblue.setY(planetblueY);

        //planetpurple
        planetpurpleX -= 2;
        if (planetpurpleX < 0) {
            planetpurpleX = screenWidth + 660;
            planetpurpleY = (int) Math.floor(Math.random() * (frameHeight - planetpurple.getHeight()));
        }
        planetpurple.setX(planetpurpleX);
        planetpurple.setY(planetpurpleY);

        //deathstar
        deathstarX -= 4.5;
        if (deathstarX < 0) {
            deathstarX = screenWidth + 2000;
            deathstarY = (int) Math.floor(Math.random() * (frameHeight - deathstar.getHeight()));
        }
        deathstar.setX(deathstarX);
        deathstar.setY(deathstarY);

        //skull
        skullX -= 10;
        if (skullX < 0) {
            skullX = screenWidth + 510;
            skullY = (int) Math.floor(Math.random() * (frameHeight - skull.getHeight()));
        }
        skull.setX(skullX);
        skull.setY(skullY);

        //powerup
        powerupX -= 10;
        if (powerupX < 0) {
            powerupX = screenWidth + 1010;
            powerupY = (int) Math.floor(Math.random() * (frameHeight - powerup.getHeight()));
        }
        powerup.setX(powerupX);
        powerup.setY(powerupY);

        skullX -= 10;
        if (skullX < 0) {
            skullX = screenWidth + 600;
            skullY = (int) Math.floor(Math.random() * (frameHeight - skull.getHeight()));
        }
        skull.setX(skullX);
        skull.setY(skullY);






        //move rocket
        if (actionFlag == true) {
            //touching
            playerY -= 20;
        } else {
            //releasing
            playerY += 20;
        }

        //check rocket position
        if (playerY < 0) playerY = 0;

        if (playerY > frameHeight - rocketSize) playerY = frameHeight - rocketSize;

        player.setY(playerY);

        scoreLabel.setText("Score : " + score);
    }

    public void hitCheck() {


        //powerup
        int powerupCenterX = powerupX + powerup.getWidth() / 2;
        int powerupCenterY = powerupY + powerup.getHeight() / 2;

        if (0 <= powerupCenterX && powerupCenterX <= rocketSize &&
                playerY <= powerupCenterY && powerupCenterY <= playerY + rocketSize) {

            score += 5;
            powerupX = -10;
            sfx.pickup();

        }
        //skull
        int skullCenterX = skullX + skull.getWidth() / 2;
        int skullCenterY = skullY + skull.getHeight() / 2;

        if (0 <= skullCenterX && skullCenterX <= rocketSize &&
                playerY <= skullCenterY && skullCenterY <= playerY + rocketSize) {

            score -= 10;
            skullX = -10;
            sfx.playdamagesound();
            //end of the game condition
            if (score < 0) {
                //stop timer
                timer.cancel();
                timer = null;
                sfx.endofthegame();

                //show result
                Intent intent = new Intent(getApplicationContext(), result.class);
                intent.putExtra("SCORE", score);
                startActivity(intent);

            }

        }
    }

    public void changeScore() {

    }

    public void nextLevel() {

    }




    //onTouch evnt
    public boolean onTouchEvent(MotionEvent me) {
        if (startFlag == false) {

            startFlag = true;

            final FrameLayout frame = (FrameLayout) findViewById(R.id.frame);

            frameHeight = frame.getHeight();

            playerY = (int)player.getY();

            rocketSize = player.getHeight();

            startLabel.setVisibility(View.GONE);
            sfx.playstartsound();


            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            changePos();

                        }
                    });
                }
            }, 0, 20);


        } else {

            if (me.getAction() == MotionEvent.ACTION_DOWN) {
                actionFlag = true;
            } else if (me.getAction() == MotionEvent.ACTION_UP) {
                actionFlag = false;
            }
        }

        return true;

    }

    //disable return btn
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    return true;

            }
        }

        return super.dispatchKeyEvent(event);
    }
}