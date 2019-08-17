package com.example.dell.nonstoptask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.facebook.login.LoginManager;
import com.facebook.share.widget.ShareDialog;

public class HomeScreenActivity extends AppCompatActivity {
    private ShareDialog shareDialog;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        shareDialog = new ShareDialog(this);

        Bundle inBundle = getIntent().getExtras();
        String name = inBundle.get("name").toString();
        TextView nameView = (TextView) findViewById(R.id.nameAndSurname);
        nameView.setText("" + name );

        Button logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                LoginManager.getInstance().logOut();
                Intent login = new Intent(HomeScreenActivity.this, LoginScreenActivity.class);
                startActivity(login);
                finish();
            }
        });
    }
}
