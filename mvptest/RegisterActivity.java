package com.example.mvptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvptest.data.models.AccountRegisterCrudentials;
import com.example.mvptest.register.RegisterContract;
import com.example.mvptest.register.RegisterPresenter;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {
    private Button registerBtn;
    private EditText FULLNAME, USERNAME, PASSWORD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final RegisterPresenter registerPresenter = new RegisterPresenter(this);
        registerBtn = (Button)findViewById(R.id.registerBtn);
        FULLNAME  = (EditText)findViewById(R.id.reg_fullname);
        USERNAME  = (EditText)findViewById(R.id.reg_username);
        PASSWORD  = (EditText)findViewById(R.id.reg_password);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* we will init a RegisterCrud object to store the inputs */
                /* We will call the createAccount function in the presenter*/
                AccountRegisterCrudentials ac = new AccountRegisterCrudentials(FULLNAME.getText().toString(),
                        USERNAME.getText().toString(),PASSWORD.getText().toString());
                registerPresenter.createUserAccount(ac);
            }
        });



    }

    @Override
    public void registerFail(String message) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerSuccess() {
        startActivity(new Intent(this,LoginActivity.class));
    }
}