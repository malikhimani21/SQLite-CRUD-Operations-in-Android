package com.example.sqlitecrud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mainAddContact(View view) {
        Intent intent = new Intent(MainActivity.this, NewContactActivity.class);
        startActivity(intent);
    }

    public void mainViewContact(View view) {
        Intent intent = new Intent(MainActivity.this, DataListActivity.class);
        startActivity(intent);
    }

    public void mainSearchContact(View view) {
        Intent intent = new Intent(MainActivity.this, SearchContactActivity.class);
        startActivity(intent);
    }

    public void mainUpdateContact(View view) {
        Intent intent = new Intent(MainActivity.this, UpdateContactActivity.class);
        startActivity(intent);
    }
}
