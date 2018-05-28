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
  ○ LifeCycle
     - To navigate transitions between stages of the activity lifecycle,
       the Activity class provides a core set of six callbacks
       : onCreate(), onStart(), onResume(), onPause(), onStop(), and onDestroy().
         The system invokes each of these callbacks as an activity enters a new state.
     - Crashing if the user receives a phone call or switches to another app while using your app.
     - Consuming valuable system resources when the user is not actively using it.
     - Losing the user's progress if they leave your app and return to it at a later time.
     - Crashing or losing the user's progress when the screen rotates between
       landscape and portrait orientation.

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
        tv_log.setText("1 - onCreate()\n");
        clearMyPrefs();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        tv_log.append("1.5 - onRestart()\n");
    }

    @Override
    protected void onStart() {
        super.onStart();
        tv_log.append("2 - onStart()\n");
    }


    @Override
    protected void onResume() {
        super.onResume();
        tv_log.append("3 - onResume()\n");
        restoreState();
    }

    @Override
    protected void onPause() {
        super.onPause();
        tv_log.append("4 - onPause()\n");
        saveState();
    }

    @Override
    protected void onStop() {
        super.onStop();
        tv_log.append("5 - onStop()\n");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tv_log.append("6 - onDestroy()\n");
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
