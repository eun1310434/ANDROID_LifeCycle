/*=====================================================================
□ Infomation
  ○ Data : 23.03.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference
     - Do it android app Programming
     - Hello JAVA Programming
     - http://itmining.tistory.com/5

□ Function
  ○

□ Study
  ○
=====================================================================*/


package com.eun1310434.lifecycle;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_log = (TextView) findViewById(R.id.tv_log);
        tv_log.setText("onCreate()\n");
        clearMyPrefs();
    }

    @Override
    protected void onStart() {
        super.onStart();
        tv_log.append("onStart()\n");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        tv_log.append("onRestart()\n");
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv_log.append("onResume()\n");
        restoreState();
    }

    @Override
    protected void onPause() {
        super.onPause();
        tv_log.append("onPause()\n");
        saveState();
    }

    @Override
    protected void onStop() {
        super.onStop();
        tv_log.append("onStop()\n");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tv_log.append("onDestroy()\n");
    }


    protected void restoreState() {
        SharedPreferences pref = getSharedPreferences("save", Activity.MODE_PRIVATE);
        if ((pref != null) && (pref.contains("save")) ){
            String save = pref.getString("save", "");
            tv_log.append("     restoreState() : "+save+"\n");
        }
    }

    protected void saveState() {
        SharedPreferences pref = getSharedPreferences("save", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        String save = "ABCD";
        editor.putString( "save", save);
        editor.commit();
        tv_log.append("     saveState() : "+save+"\n");
    }

    protected void clearMyPrefs() {
        SharedPreferences pref = getSharedPreferences("save", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}
