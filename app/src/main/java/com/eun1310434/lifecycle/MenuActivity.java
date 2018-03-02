/**
 * 02.03.2018
 * eun1310434@naver.com
 * https://blog.naver.com/eun1310434
 * 참고) Do it android programming
 */

package com.eun1310434.lifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "onStop ", Toast.LENGTH_SHORT).show();
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
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }
}
