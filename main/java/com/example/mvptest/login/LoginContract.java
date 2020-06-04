package com.example.mvptest.login;

import com.example.mvptest.data.models.UserCrudentials;

public interface LoginContract {
    interface View{
        void showProgressBar(); //show the progress bar
        void hideProgressBar(); //hide it

        void showRegisterPage();
        void successLogin(); // if login is success (will go to the main activity if triggered)
        void failedLogin(final String message); // if login is failed (will send out a TOAST)
    }
    interface Presenter{
        void verifyLogin(UserCrudentials userCrudentials); //verify the crudentials, will take in params userCrudentials
        void login(); // this method will log the user in
        void goToRegisterPage();

        void successLogin();
        void failedLogin(final String message);
    }

}
