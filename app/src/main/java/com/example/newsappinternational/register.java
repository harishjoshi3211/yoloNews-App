package com.example.newsappinternational;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class register extends AppCompatActivity {

    EditText edname,edpass,edrepass,edemail;
    Button btnregister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edname=findViewById(R.id.edusermail);
        edpass=findViewById(R.id.edpass);
        edrepass=findViewById(R.id.edrepass);
        edemail=findViewById(R.id.edemail);
        btnregister=findViewById(R.id.btnregister);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edname.getText().toString().isEmpty()||edpass.getText().toString().isEmpty()||edrepass.getText().toString().isEmpty()||edemail.getText().toString().isEmpty())
                {
                    Toast.makeText(register.this,"please fill all fields",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String email=edemail.getText().toString();
                    String name=edname.getText().toString();
                    if(edpass.getText().toString().equals(edrepass.getText().toString()))
                    {
                        String password=edpass.getText().toString();
                        BackendlessUser user=new BackendlessUser();
                        user.setEmail(email);
                        user.setPassword(password);
                        user.setProperty("name",name);

                        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
                            @Override
                            public void handleResponse(BackendlessUser response) {
                                Toast.makeText(register.this,"user successfully added!",Toast.LENGTH_LONG).show();
                                register.this.finish();
                            }

                            @Override
                            public void handleFault(BackendlessFault fault) {
                                Toast.makeText(register.this,"Error: "+fault.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                    else
                    {
                        Toast.makeText(register.this,"password did not match",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
