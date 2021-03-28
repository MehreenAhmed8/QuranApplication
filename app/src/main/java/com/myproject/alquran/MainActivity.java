package com.myproject.alquran;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected Context mContext;
    protected Button button;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mContext = this;
        setContentView(R.layout.activity_main);
        initUiComponents();
        setClickListener();

    }

    private void initUiComponents() {
        button = findViewById(R.id.button);
    }

    private void setClickListener()
    {
        button.setOnClickListener((View.OnClickListener) this);
    }

    public void callIntent(Context c, Class<?> cls)
    {
        Intent intent = new Intent(c, cls);
        startActivity(intent);

    }


    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() == 0) {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }
    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.button:
                callIntent(mContext, LoadQuran.class);
                break;
        }
    }
}