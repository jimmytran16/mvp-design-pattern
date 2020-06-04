package com.example.mvptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvptest.data.models.UserCrudentials;
import com.example.mvptest.login.LoginContract;
import com.example.mvptest.login.PresenterLogin;

public class LoginActivity extends AppCompatActivity implements LoginContract.View { //This activity will implement the View interface
    ProgressBar progressBarLogin;
    EditText username,password;
    Button loginBtn,registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        loginBtn = (Button)findViewById(R.id.loginBtn);
        username = (EditText)findViewById(R.id.usernameField);
        password = (EditText)findViewById(R.id.passwordField);
        registerBtn = (Button)findViewById(R.id.goToRegisterBtn);
        final PresenterLogin presenter = new PresenterLogin(this); //call the presenterLogin class and pass in the context
        progressBarLogin = (ProgressBar)findViewById(R.id.progressBarLogin);
        progressBarLogin.setVisibility(View.INVISIBLE);
        /* set a click listener on the login button */
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Call instance of the UserCrudentials model*/
                /* extract from the text fields */
                UserCrudentials userCrudentials = new UserCrudentials();

                /* Get the username and password from the text fields */
                userCrudentials.setUsername(username.getText().toString());
                userCrudentials.setPassword(password.getText().toString());

                /* verify the username and password using the verify() method from the presenter */
                presenter.verifyLogin(userCrudentials);
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToRegisterPage();
            }
        });

    }

    @Override
    public void showProgressBar() { /* Show the progress bar */
        progressBarLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {progressBarLogin.setVisibility(View.INVISIBLE);}

    @Override
    public void showRegisterPage() {
        startActivity(new Intent(this,RegisterActivity.class));
    }

    @Override
    public void successLogin() { /* Set intent to go to the Main Activity */
        startActivity(new Intent(this,MainActivity.class));
    }

    @Override
    public void failedLogin(final String message) { /* Set a toast to prompt user */
        Log.d("view - failedLogin()","inside");
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}