package com.example.stav.login;

import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Program extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    ArrayList<String> selection = new ArrayList<String>();
    int startHour, startMin, duration;
    private FirebaseAuth mFirebaseAuth;
    EditText ProgramName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);

        Button starttime = findViewById(R.id.btnStartTime);


        starttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v4.app.DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_program, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.back_btn:
                startActivity(new Intent(this, Tap1.class));
                break;
            case R.id.profile_menu_btn:
                startActivity(new Intent(this, HomeActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void Save(View view){
        //ProgramName
        ProgramName = (EditText) findViewById(R.id.etProgramName);
        String programName = ProgramName.getText().toString();

        //duratin time
        EditText etduration = findViewById(R.id.etduration);
        String value= etduration.getText().toString();
        duration = Integer.parseInt(value);

        //Days --- the checkBox use func
        //selectItem(view);

        //Pass object Between Activity
        Intent intent = new Intent(Program.this, Tap1.class);
        intent.putExtra("PROGRAMNAME", programName);
        intent.putExtra("STARTHOUR", startHour);
        intent.putExtra("STARTMIN", startMin);
        intent.putExtra("DURATION", duration);
        intent.putExtra("SELECTION", selection);
        startActivity(intent);
    }

    public void selectItem(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId())
        {
            case R.id.cbMon:
                if(checked){
                    selection.add("Mon");
                }
                else {selection.remove("Mon");}
                break;
            case R.id.cbTue:
                if(checked)
                {
                    selection.add("Tue");
                }
                else {selection.remove("Tue");}
                break;
            case R.id.cbWen:
                if(checked)
                {
                    selection.add("Wen");
                }
                else {selection.remove("Wen");}
                break;
            case R.id.cbThu:
                if(checked)
                {
                    selection.add("Thu");
                }
                else {selection.remove("Thu");}
                break;
            case R.id.cbFri:
                if(checked)
                {
                    selection.add("Fri");
                }
                else {selection.remove("Fri");}
                break;
            case R.id.cbSat:
                if(checked)
                {
                    selection.add("Sat");
                }
                else {selection.remove("Sat");}
                break;
            case R.id.cbSun:
                if(checked)
                {
                    selection.add("Sun");
                }
                else {selection.remove("Sun");}
                break;
        }
    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView tvstarttime = (TextView)findViewById(R.id.tvStartTime);
        tvstarttime.setText("Start Time - " + hourOfDay + ":" + minute);

        this.startHour = hourOfDay;
        this.startMin = minute;
    }
}
