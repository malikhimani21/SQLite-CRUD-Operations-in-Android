package com.example.sqlitecrud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewContactActivity extends AppCompatActivity {

    EditText ContactName, ContactMobile, ContactEmail;
    Context context = this;
    SQLiteDatabase sqLiteDatabase;
    UserDbHelper userDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        ContactName = (EditText) findViewById(R.id.et_contact_name);
        ContactMobile = (EditText) findViewById(R.id.et_mobile_number);
        ContactEmail = (EditText) findViewById(R.id.et_email_address);
    }

    public void saveInformationInsertActivity(View view){
        String name = ContactName.getText().toString();
        String mob = ContactMobile.getText().toString();
        String email = ContactEmail.getText().toString();
        userDbHelper = new UserDbHelper(context);
        sqLiteDatabase = userDbHelper.getWritableDatabase();
        userDbHelper.addInformations(name,mob,email,sqLiteDatabase);
        Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_SHORT).show();
        userDbHelper.close();
        finish();


    }
}
