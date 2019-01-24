package com.example.monkey.bottomnav_withfragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
//import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    //private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.replace(R.id.content, new HomeFragment()).commit();
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    transaction.replace(R.id.content, new InboxFragment()).commit();
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    transaction.replace(R.id.content, new notificationsFragment()).commit();
                    //mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_inbox:
                    transaction.replace(R.id.content, new InboxFragment()).commit();
                    //mTextMessage.setText(R.string.title_inbox);
                    return true;
            }
            return false;
        }
    };
//note that the nav bar can only support up to 5 items
    //https://www.youtube.com/watch?v=afVktMf_LkE for nav bar with fragments tutorial
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
