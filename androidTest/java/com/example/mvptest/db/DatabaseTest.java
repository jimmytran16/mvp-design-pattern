package com.example.mvptest.db;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.mvptest.MainActivity;
import com.example.mvptest.data.models.UserCrudentials;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {
    final String F_USERNAME = "a";
    final String F_PASSWORD = "a";
    final String T_USERNAME = "jimmy";
    final String T_PASSWORD = "68016801";
    public UserCrudentials uc;

    @Before
    public void execute(){
        uc = new UserCrudentials();
    }

    @Rule
    public ActivityTestRule main = new ActivityTestRule(MainActivity.class,true,false);
    public DataBaseHelper db = new DataBaseHelper(MainActivity.class);

    @Test /* Check the existing user */
    public void DBUsernameAndPassword(){
        uc.setUsername(T_USERNAME);
        uc.setPassword(T_PASSWORD);
        boolean check = db.checkIfUserExists(uc);
        assertTrue(check);
    }

//    @Test /* Check the false user */
//    public void FalseUser(){
//        uc.setUsername(F_USERNAME);
//        uc.setPassword(F_PASSWORD);
//        assertFalse(db.checkIfUserExists(uc));
//    }

}
