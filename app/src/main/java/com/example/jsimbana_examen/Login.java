package com.example.jsimbana_examen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private Button mLogin;
    private EditText mUsername;
    private EditText mPassword;
    private Context mContext;
    private UserControler mManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mManager = new UserControler(this);
        mContext = this;
        mLogin = (Button) findViewById(R.id.button_login);
        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (awsValidacion.validate())
                {
                    checkLogin();
                }
            }
        });
    }

    private void checkLogin() {
        String username = mUsername.getText().toString().trim().toLowerCase();
        String password = mPassword.getText().toString().trim();
        boolean isSuccess = mManager.checkLoginValidate(username, password);
        if (isSuccess) {
            Intent intent = new Intent(mContext, Registro.class);
            intent.putExtra(UserControler.USER_YEY, username);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(mContext, R.string.save_message, Toast.LENGTH_SHORT).show();
        }
    }
}