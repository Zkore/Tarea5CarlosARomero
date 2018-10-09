package com.iteso.pdm18_scrollabletabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityLogin extends AppCompatActivity {

    EditText name, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePreferences();
                Intent intent = new Intent(ActivityLogin.this, ActivityMain.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void savePreferences(){
        User user = new User();
        user.setName(name.getText().toString());
        user.setPassword(password.getText().toString());
        user.setLogged(true);
        SharedPreferences sharedPreferences = getSharedPreferences("com.iteso.USER_PREFERENCES", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("USER",user.getName());
        editor.putString("PASSWORD", user.getPassword());
        editor.putBoolean("LOGIN", user.isLogged());
        editor.apply();
    }

}