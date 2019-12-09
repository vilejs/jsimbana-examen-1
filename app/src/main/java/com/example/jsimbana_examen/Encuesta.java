package com.example.jsimbana_examen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Encuesta extends AppCompatActivity {
    private Button mEcuesta;
    private TextView mUserName;
    private EditText mP1;
    private CheckBox chkFutbol, chkBasket, chkBoxeo;
    private RadioButton rdbSi, rdbNo;
    private Context mContext;

    private Intent mIntent;
    private String userName;
    private String nameComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encuesta);
        mIntent = getIntent();
        userName = mIntent.getStringExtra(UserControler.USER_YEY);
        nameComplete = mIntent.getStringExtra(UserControler.NAME_COMPLETE);
        mContext = this;
        mUserName = (TextView) findViewById(R.id.userNameLogin);
        mUserName.setText(getString(R.string.username_title) + userName);

        mEcuesta = (Button) findViewById(R.id.button_Sig);
        //P1
        mP1 = (EditText) findViewById(R.id.p1);
        //P2
        chkFutbol = (CheckBox) findViewById(R.id.chkFutbol);
        chkBasket = (CheckBox) findViewById(R.id.chkBasket);
        chkBoxeo = (CheckBox) findViewById(R.id.chkBoxeo);
        //p3
        rdbSi = (RadioButton) findViewById(R.id.rdbOp1Yes);
        rdbNo = (RadioButton) findViewById(R.id.rdbOp1No);


        mEcuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (awsValidacion.validate())
                {
                    next();
                }
            }
        });

    }
    private void next() {
        Intent intent = new Intent(mContext, Resumen.class);
        intent.putExtra(UserControler.USER_YEY, userName);
        intent.putExtra(UserControler.NAME_COMPLETE ,nameComplete );
        intent.putExtra(UserControler.P1_KEY_TXT ,mP1.getText().toString());
        intent.putExtra(UserControler.P2_KEY_SCC,chkFutbol.isChecked());
        intent.putExtra(UserControler.P2_KEY_BK,chkBasket.isChecked());
        intent.putExtra(UserControler.P2_KEY_WK,chkBoxeo.isChecked());
        intent.putExtra(UserControler.P3_KEY_OPT,rdbSi.isSelected()?true:false);
        startActivity(intent);
        finish();
    }
}
