package com.mardyoe.lesson3;

import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextName, editTextEmail;
    Button buttonSave, buttonRetrieve, buttonDelete;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = (EditText) findViewById(R.id.editText_email);
        editTextName = (EditText) findViewById(R.id.editText_name);

        buttonSave = (Button) findViewById(R.id.button_save);
        buttonRetrieve = (Button) findViewById(R.id.button_retrieve);
        buttonDelete = (Button) findViewById(R.id.button_delete);

        sp = getSharedPreferences("Save", MODE_PRIVATE);

        buttonSave.setOnClickListener(this);
        buttonRetrieve.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_save:
                SharedPreferences.Editor editor = sp.edit();

                String name = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();

                editor.putString("name", name);
                editor.putString("email", email);

                editor.apply();
                editTextEmail.setText("");
                editTextName.setText("");
                Toast.makeText(this, "Data has been saved", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_retrieve:
                String nameRetrieve = sp.getString("name", "Name is not saved");
                String emailRetieve = sp.getString("email", "Email is notsaved");

                AlertDialog.Builder adb = new AlertDialog.Builder(this);
                adb.setMessage(String.format("Name: %s\nEmail: %s", nameRetrieve, emailRetieve));
                adb.setPositiveButton("OK", null);
                adb.create();

                AlertDialog ad = adb.create();
                ad.show();

                break;
            case R.id.button_delete:

                sp.edit().clear().apply();
                Toast.makeText(this, "Data has been deleted", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
