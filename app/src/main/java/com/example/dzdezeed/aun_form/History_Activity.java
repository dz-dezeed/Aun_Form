package com.example.dzdezeed.aun_form;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class History_Activity extends AppCompatActivity {
    protected Button BBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        BBack = (Button) findViewById(R.id.BBack);
        WhenClickBBack();
    }
    private void WhenClickBBack() {
        BBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History_Activity.this,Menu_Activity.class);
                startActivity(intent);
            }
        });
    }
}
