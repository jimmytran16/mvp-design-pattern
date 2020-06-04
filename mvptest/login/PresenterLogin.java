package com.example.mvptest.login;

import android.os.Handler;
import android.util.Log;

import com.example.mvptest.LoginActivity;
import com.example.mvptest.RegisterActivity;
import com.example.mvptest.data.models.UserCrudentials;
import com.example.mvptest.db.DataBaseHelper;
import com.example.mvptest.login.LoginContract;


public class PresenterLogin implements LoginContract.Presenter {
    private LoginActivity loginView;
    final Handler handler = new Handler();

    public PresenterLogin(LoginActivity view) { /* The Presenter constructer will take in the params of the view context */
        this.loginView = view;
    }

    @Override
    public void verifyLogin(UserCrudentials userCrudentials) {
        final UserCrudentials uc = userCrudentials;
        final String WRONG_MSG = "Wrong Crudentials!";
        DataBaseHelper db = new DataBaseHelper(loginView);
        loginView.showProgressBar(); // show the progress bar
        /* Check to see if the fields are empty */
        Log.d("PresenterLogin.java",uc.getUsername() +" "+uc.getPassword() );

        if (uc.getUsername().isEmpty() || uc.getPassword().isEmpty()){failedLogin("Please don't leave an empty field!");return;}

        if(db.checkIfUserExists(uc)){ /*Check to see if the user crudentials match with the database*/
            successLogin();
            return;
        }
        else{
            failedLogin(WRONG_MSG);
            return;
        }
    }

    @Override
    public void login() {
        loginView.successLogin();
    }

    @Override
    public void goToRegisterPage() {
        loginView.showRegisterPage();
    }

    @Override
    public void successLogin() { /* this function will notify the view that is it a success login  */
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                login(); //function to log the user in
            }
        },2000);
    }

    @Override /* this function will notify the view that is it a failed login */
    public void failedLogin(final String message) {
        /* This will delay the post for 3 seconds */
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loginView.hideProgressBar();
                loginView.failedLogin(message);
            }
        }, 2000);
    }
}
