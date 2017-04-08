package com.example.lesson5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView textViewSubuh, textViewZohor, textViewAsar, textViewMaghrib, textViewIsyak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSubuh = (TextView) findViewById(R.id.textView_subuh);
        textViewZohor = (TextView) findViewById(R.id.textView_zohor);
        textViewAsar = (TextView) findViewById(R.id.textView_asar);
        textViewMaghrib = (TextView) findViewById(R.id.textView_maghrib);
        textViewIsyak = (TextView) findViewById(R.id.textView_isyak);

        getData();
    }

    private void getData() {
        VolleyHelper volleyHelper = new VolleyHelper(this, "http://www.mardyoe.com/waktusolat/api/");

        volleyHelper.get("date.php?zone=sgr01", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("Response", response.toString());

                try {

                    JSONArray array = response.getJSONArray("prayer_times");
                    JSONObject obj = array.getJSONObject(0);

                    String strSubuh = obj.getString("subuh");
                    String strZohor = obj.getString("zohor");
                    String strAsar = obj.getString("asar");
                    String strMaghrib = obj.getString("maghrib");
                    String strIsyak = obj.getString("isyak");

                    textViewSubuh.setText(strSubuh);
                    textViewZohor.setText(strZohor);
                    textViewAsar.setText(strAsar);
                    textViewMaghrib.setText(strMaghrib);
                    textViewIsyak.setText(strIsyak);

                    Toast.makeText(MainActivity.this, "Refreshed", Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    Log.e("parse error", e.toString());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.toString());
            }
        });
    }
}
