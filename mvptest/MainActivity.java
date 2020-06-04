package com.example.mvptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mvptest.logout.LogoutContract;
import com.example.mvptest.logout.LogoutPresenter;

public class MainActivity extends AppCompatActivity implements LogoutContract.view  {
    Button logoutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LogoutPresenter logoutPresenter = new LogoutPresenter(this); /* init the logout presenter */
        setContentView(R.layout.activity_main);
        logoutBtn = (Button)findViewById(R.id.logoutBtn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutPresenter.logout();
            }
        });
    }

    @Override
    public void logUserOut() {
        startActivity(new Intent(this,LoginActivity.class)); //passing intent to the log in page
    }

    @Override
    public void logoutOnSuccess() {
        logUserOut();
    }

    @Override
    public void logoutOnFailure(String message) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}