package com.mardyoe.androidkickstartworkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView lblHello;
    EditText txtName;
    Button btnPress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPress = (Button) findViewById(R.id.btnPress);
        txtName = (EditText) findViewById(R.id.txtName);
        lblHello = (TextView) findViewById(R.id.lblHello);

        btnPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hello = "Hello, " + txtName.getText().toString();
                lblHello.setText(hello);
            }
        });
    }
}
