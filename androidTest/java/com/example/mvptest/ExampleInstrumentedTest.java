package com.example.mvptest;

import android.content.Context;
import android.content.Intent;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;
/*My imports*/
/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */



@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    /* inject the login activity class into rule */
    final private String USER_NAME_PROMPT = "Enter Username",USER_PASSWORD_PROMPT = "Enter Password",LOGIN_PROMPT ="Logged in!";

    @Rule
    final public ActivityTestRule rule = new ActivityTestRule(LoginActivity.class,true,false);
    final public ActivityTestRule main = new ActivityTestRule(MainActivity.class,true,false);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.mvptest", appContext.getPackageName());
    }

    @Test
    public void testLoginPageActivity(){
        rule.launchActivity(new Intent()); //launch the login activity
        /* check the page content for hints */
        onView(withHint(USER_NAME_PROMPT)).check(matches(isDisplayed()));
        onView(withHint(USER_PASSWORD_PROMPT)).check(matches(isDisplayed()));
    }

    @Test
    public void TestMainActivity(){
        main.launchActivity(new Intent());
        onView(withText(LOGIN_PROMPT)).check(matches(isDisplayed())); /* The onView() function*/
    }
}