package com.example.dzdezeed.aun_form;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddUpdateUser_Activity extends AppCompatActivity {
    protected Button BOk;
    String person = "You are in my heart forever.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_update_user);
        BOk = (Button) findViewById(R.id.BOk);
        WhenClickBOk();
    }
    private void WhenClickBOk() {
        BOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddUpdateUser_Activity.this,PassDataBetweenStepsActivity.class);
                intent.putExtra("person", person);
                startActivity(intent);
            }
        });
    }
}
