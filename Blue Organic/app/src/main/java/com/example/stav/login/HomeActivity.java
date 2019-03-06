package com.example.stav.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private FirebaseAuth.AuthStateListener mFirebaseAuthListener;

    private Button tap1;

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener((mFirebaseAuthListener));
    }

    @Override
    protected void onPause() {
        super.onPause();
        mFirebaseAuth.addAuthStateListener((mFirebaseAuthListener));
    }

    public void singOut(){
        startActivity(new Intent(this, LoginActivity.class));
        mFirebaseAuth.signOut();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SetUpUIViews();

        tap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityTap1();
            }
        });


// getDate...-->
        Date date = new Date();
        SimpleDateFormat sdf_year  = new SimpleDateFormat("yyyy");
        String string_year = sdf_year.format(date);
        SimpleDateFormat sdf_month  = new SimpleDateFormat("MMM");
        String stringMonth = sdf_month.format(date);
        getMonth(stringMonth);
        getYear(string_year);
// func --- Date

        mFirebaseAuth = FirebaseAuth.getInstance();

        /* ------ not use right ----*/
        mFirebaseAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() == null){
                    startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };

    }

    private void getMonth(String num) {
        TextView textView = (TextView) findViewById(R.id.current_month_view);
        textView.setText(num);
    }

    private void getYear(String num) {
        TextView textView = (TextView) findViewById(R.id.current_year_view);
        textView.setText(num);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_page_manu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.sing_out_menu_btn:
                singOut();
                break;
            case R.id.profile_menu_btn:
                startActivity(new Intent(this, HomeActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void openActivityTap1(){
        Intent intent = new Intent(this, Tap1.class);
        startActivity(intent);
    }

    private void SetUpUIViews() {
        tap1 = findViewById(R.id.btnTap1);
    }

}
