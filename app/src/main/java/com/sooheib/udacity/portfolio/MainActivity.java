package com.sooheib.udacity.portfolio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toast mAppToast;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LinearLayout buttonContainer = (LinearLayout) findViewById(R.id.button_container);
        for (int i = 0; i < buttonContainer.getChildCount(); i++) {
            final Button button = (Button) buttonContainer.getChildAt(i);

            button.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    String description = button.getContentDescription().toString();
                    showAppToast(getString(R.string.btn_click_toast, description));
                }
            });
        }
    }

    private void showAppToast(String msg) {
        if (mAppToast != null) {
            mAppToast.cancel();
        }

        mAppToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        mAppToast.show();
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
