package com.mardyoe.lesson4;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class GridViewActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener {

    private GridView gridView;
    private ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gridView = (GridView) findViewById(R.id.gridView);

        list = new ArrayList<>();

        for (int a=0; a<40; a++) {
            list.add(String.format(Locale.getDefault(), "Data %d", a+1));
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
        gridView.setOnItemLongClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu) {
        switch (menu.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(menu);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.gridView:
                String data = list.get(position);
                Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
        switch (parent.getId()) {
            case R.id.gridView:
                AlertDialog.Builder adb = new AlertDialog.Builder(this);
                adb.setItems(R.array.long_click, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                Toast.makeText(GridViewActivity.this, "Open has been clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(GridViewActivity.this, "One data deleted", Toast.LENGTH_SHORT).show();
                                list.remove(position);
                                adapter.notifyDataSetChanged();
                                break;
                        }
                    }
                });

                AlertDialog ad = adb.create();
                ad.show();
        }
        return true;
    }
}
