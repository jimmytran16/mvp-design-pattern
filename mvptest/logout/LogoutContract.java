package com.example.mvptest.logout;

public interface LogoutContract {
    interface view {
        void logUserOut(); /* logs out the user --- intents to the log in page*/

        void logoutOnSuccess();
        void logoutOnFailure(final String message);
    }
    interface Presenter{
        void logout();

        void logoutOnSuccess();
        void logoutOnFailure(final String message);
    }
}
