package com.mardyoe.lesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnLayoutA, btnLayoutB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLayoutA = (Button) findViewById(R.id.btnLayoutA);
        btnLayoutB = (Button) findViewById(R.id.btnLayoutB);

        btnLayoutA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LayoutA.class);
                startActivity(intent);
            }
        });

        btnLayoutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LayoutB.class);
                startActivity(intent);
            }
        });
    }
}
