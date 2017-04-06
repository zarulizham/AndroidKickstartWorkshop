package com.mardyoe.lesson4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonListView, buttonGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGridView = (Button) findViewById(R.id.button_gridView);
        buttonListView = (Button) findViewById(R.id.button_listView);

        buttonGridView.setOnClickListener(this);
        buttonListView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent;
        switch (v.getId()) {
            case R.id.button_gridView:
                intent = new Intent(this, GridViewActivity.class);
                startActivity(intent);
                break;
            case R.id.button_listView:
                intent = new Intent(this, ListViewActivity.class);
                startActivity(intent);
                break;

        }
    }
}
