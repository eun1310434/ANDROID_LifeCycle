/**
 * 02.03.2018
 * eun1310434@naver.com
 * https://blog.naver.com/eun1310434
 * 참고) Do it android programming
 */


package com.eun1310434.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText keyinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        keyinput = (EditText) findViewById(R.id.keyinput);
    }

    public void onButton1Clicked(View v) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        saveState();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        restoreState();
    }

    protected void restoreState() {
        SharedPreferences pref = getSharedPreferences("save", Activity.MODE_PRIVATE);

        if ((pref != null) && (pref.contains("save")) ){
            String name = pref.getString("save", "");
            keyinput.setText(name);
        }
    }

    protected void saveState() {
        SharedPreferences pref = getSharedPreferences("save", Activity.MODE_PRIVATE);

        SharedPreferences.Editor editor = pref.edit();
        editor.putString( "save", "SAVE DATA : "+ keyinput.getText().toString());
        editor.commit();
    }

    protected void clearMyPrefs() {
        SharedPreferences pref = getSharedPreferences("save", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}
