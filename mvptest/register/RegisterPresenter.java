package com.example.mvptest.register;

import com.example.mvptest.RegisterActivity;
import com.example.mvptest.data.models.AccountRegisterCrudentials;
import com.example.mvptest.db.DataBaseHelper;

public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterActivity registerView;

    public RegisterPresenter(RegisterActivity registerView){
        this.registerView = registerView;
    }

    @Override
    public void createUserAccount(AccountRegisterCrudentials crudentials) {
        DataBaseHelper db = new DataBaseHelper(registerView); /* pass in the context of the view*/

        /* If there are empty fields */
        if(crudentials.getPassword().isEmpty()||crudentials.getUsername().isEmpty()||crudentials.getName().isEmpty()){
            registerFail("Please fill in all the fields!");
            return;
        }

        /* Password validations */
        if(crudentials.getPassword().length() < 8){
            registerFail("The password must be at least 8 characters!");
            return;
        }

        /* Register for the account by using the DataBaseHelper method */
        if(db.createUserAccount(crudentials)){
            registerSuccess();
            return;
        }else{
            registerFail("Fail to register!");
            return;
        }
    }

    @Override
    public void registerFail(final String message) {
        registerView.registerFail(message); //pass the message to the view method
    }

    @Override
    public void registerSuccess() {
        registerView.registerSuccess();
    }
}
