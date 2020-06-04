package com.example.mvptest.register;

import com.example.mvptest.data.models.AccountRegisterCrudentials;

public interface RegisterContract {
    interface View{
        void registerFail(final String message);
        void registerSuccess();
    }
    interface Presenter{
        void createUserAccount(AccountRegisterCrudentials c);
        void registerFail(final String message);
        void registerSuccess();
    }
}
