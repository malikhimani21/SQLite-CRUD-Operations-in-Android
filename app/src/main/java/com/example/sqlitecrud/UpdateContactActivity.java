package com.example.sqlitecrud;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateContactActivity extends AppCompatActivity {

    EditText Name_Search, New_Name, New_Mobile, New_Email;
    TextView title_text;
    String SearchName, NewName, NewMobile, NewEmail;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);

        Name_Search = (EditText) findViewById(R.id.name_search_last);
        New_Name = (EditText) findViewById(R.id.new_name);
        New_Mobile = (EditText) findViewById(R.id.new_mobile);
        New_Email = (EditText) findViewById(R.id.new_email);
        updateButton = (Button) findViewById(R.id.update_button_last);
        title_text = (TextView) findViewById(R.id.title_text);
        New_Name.setVisibility(View.GONE);
        New_Mobile.setVisibility(View.GONE);
        New_Email.setVisibility(View.GONE);
        updateButton.setVisibility(View.GONE);
        title_text.setVisibility(View.GONE);

    }

    public void searchContactLast(View view){

        SearchName = Name_Search.getText().toString();
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        Cursor cursor = userDbHelper.getContact(SearchName, sqLiteDatabase);
        if(cursor.moveToFirst()){
            NewMobile = cursor.getString(0);
            NewEmail = cursor.getString(1);
            NewName = SearchName;
            New_Name.setText(NewName);
            New_Mobile.setText(NewMobile);
            New_Email.setText(NewEmail);
            New_Name.setVisibility(View.VISIBLE);
            New_Mobile.setVisibility(View.VISIBLE);
            New_Email.setVisibility(View.VISIBLE);
            updateButton.setVisibility(View.VISIBLE);
            title_text.setVisibility(View.VISIBLE);

        }

    }

    public void updateContactLast(View view){
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getWritableDatabase();
        String name, email, mobile;
        name = New_Name.getText().toString();
        mobile = New_Mobile.getText().toString();
        email = New_Email.getText().toString();
        int count = userDbHelper.updateInformations(SearchName,name,mobile, email, sqLiteDatabase);
        Toast.makeText(getApplicationContext(), count+" contact updated", Toast.LENGTH_SHORT).show();
        finish();
    }
}
