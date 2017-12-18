package com.example.terry.atm_app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText eduserid;
    private EditText eduserpw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText edUserid = findViewById(R.id.userid);
        SharedPreferences setting =  getSharedPreferences("ATM",MODE_PRIVATE);
        edUserid.setText(setting.getString("PREF_USERID",""));

    }
    public void login(View v){
        eduserid = findViewById(R.id.userid);
        eduserpw = findViewById(R.id.userpw);
        String uid = eduserid.getText().toString();
        String pw = eduserpw.getText().toString();

        if(uid.equals("JIM") && pw.equals("1234")) {//logon successful
            SharedPreferences setting =  getSharedPreferences("ATM",MODE_PRIVATE);
            setting.edit()
                    .putString("PREF_USERID",uid)
                    .commit();

            Toast.makeText(this,"Sucessful!!",Toast.LENGTH_LONG).show();
            getIntent().putExtra("LOGIN_USERID",uid);
            getIntent().putExtra("LOGTH_USERPW",pw);
            setResult(RESULT_OK,getIntent());
            finish();
        }else {
            new AlertDialog.Builder(this)
                    .setTitle("ATM")
                    .setMessage("Login failed")
                    .setPositiveButton("OK",null)
                    .show();
    }
    }
    public  void cancel(View v){
        finish();
    }
}
