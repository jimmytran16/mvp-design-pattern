package com.example.mvptest.logout;

import android.widget.Toast;

import com.example.mvptest.MainActivity;

public class LogoutPresenter implements LogoutContract.Presenter {
    MainActivity logoutView;
    public LogoutPresenter(MainActivity logoutView){ /* Gets the logout view context*/
        this.logoutView = logoutView;
    }
    @Override
    public void logout() {
        logoutOnSuccess();
    }

    @Override
    public void logoutOnSuccess() {
        logoutView.logUserOut(); /* call the logUserOut() function to  */
    }

    @Override
    public void logoutOnFailure(String message) {
        logoutView.logoutOnFailure(message);
    }
}
