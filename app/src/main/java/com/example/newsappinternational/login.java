package com.example.newsappinternational;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class login extends AppCompatActivity {

    TextView edusermail,edpass;
    TextView tvforgot;
    Button btnlogin,btnsignup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edusermail=findViewById(R.id.edusermail);
        edpass=findViewById(R.id.edpass);
        tvforgot=findViewById(R.id.tvforgot);
        btnlogin=findViewById(R.id.btnlogin);
        btnsignup=findViewById(R.id.btnsignup);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edusermail.getText().toString().isEmpty()||edpass.getText().toString().isEmpty())
                {
                    Toast.makeText(login.this,"enter email & password carefully",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String email=edusermail.getText().toString();
                    String password=edpass.getText().toString();

                    Backendless.UserService.login(email, password, new AsyncCallback<BackendlessUser>() {
                        @Override
                        public void handleResponse(BackendlessUser response) {

                            Toast.makeText(login.this,"Login successfull!",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(login.this,MainActivity.class));
                            login.this.finish();

                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {

                            Toast.makeText(login.this,"error: "+fault.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }, true);
                }

            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(login.this,register.class));
            }
        });
    }
}
