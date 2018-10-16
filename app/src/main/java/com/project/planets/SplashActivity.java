
package com.project.planets;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.project.planets.Util.TypeWriter;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1300;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        String text = "<font color=#003056>ASSIGNMENT</font>";

        TypeWriter writer = new TypeWriter(this);
        setContentView(writer);
        writer.setCharacterDelay(30);
        writer.setGravity(Gravity.CENTER);
        writer.setTextSize(22);
        writer.animateText(Html.fromHtml(text));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }


}
