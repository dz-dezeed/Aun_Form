package com.example.dzdezeed.aun_form;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    protected Button BSignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BSignin = (Button) findViewById(R.id.BSignin);

        WhenClickBSignin();

    }
    private void WhenClickBSignin() {
        BSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Menu_Activity.class);
                startActivity(intent);
            }
        });
    }
}
