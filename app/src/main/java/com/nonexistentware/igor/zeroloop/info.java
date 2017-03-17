package com.nonexistentware.igor.zeroloop;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.immortalplayer.zeroloop.R;

public class info extends AppCompatActivity {

    TextView info, about, back;

    //custom font

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        info = (TextView) findViewById(R.id.about);
        about = (TextView) findViewById(R.id.about);
        back = (TextView) findViewById(R.id.back);

        //custom font
    }

    public void back(View view) {
        startActivity(new Intent(getApplicationContext(), start.class));
    }


    //back button is lock
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