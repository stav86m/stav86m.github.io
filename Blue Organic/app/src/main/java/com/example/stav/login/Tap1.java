package com.example.stav.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Tap1 extends AppCompatActivity {

    ProgaramVar programvar = new ProgaramVar();
    List<ProgaramVar> newProgram = new ArrayList<ProgaramVar>();

    static int count = 0;
    private Button addnewprogaram;

    private ListView list;
    ArrayAdapter<String> listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap1);
        SetUpUIViews();


        if(count != 0) {
            //Pass object Between Activity
            programvar.programname = getIntent().getExtras().getString("PROGRAMNAME");
            programvar.starthour = getIntent().getExtras().getInt("STARTHOUR");
            programvar.startmin = getIntent().getExtras().getInt("STARTMIN");
            programvar.duration = getIntent().getExtras().getInt("DURATION");
            programvar.selection = (ArrayList<String>) getIntent().getSerializableExtra("SELECTION");

            newProgram.add(new ProgaramVar(programvar.programname,
                    programvar.starthour ,
                    programvar.startmin,
                    programvar.duration,
                    programvar.selection));



            list.setAdapter(new ArrayAdapter<ProgaramVar>(this,
                    android.R.layout.simple_list_item_single_choice,
                    newProgram));

            listAdapter = (ArrayAdapter<String>)list.getAdapter();

            TextView programName1 = (TextView) findViewById(R.id.programName1);
            //programName1.setText(newProgram.toString());
        }
        //to Program
        addnewprogaram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                openActivityProgram();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_back, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.profile_menu_btn:
                startActivity(new Intent(this, HomeActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    private void SetUpUIViews() {
        addnewprogaram = findViewById(R.id.btnAddNewProgram);
        list = (ListView)findViewById(R.id.listProgram);
    }

    //move to program activity
    public void openActivityProgram(){
        Intent intent = new Intent(this, Program.class);
        startActivity(intent);
    }
}
