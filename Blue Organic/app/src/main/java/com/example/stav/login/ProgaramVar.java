package com.example.stav.login;

import java.util.ArrayList;

public class ProgaramVar {

     String programname;
     int starthour;
     int startmin;
     int duration;
     ArrayList<String> selection = new ArrayList<String>();

    @Override
        public String toString() {
            return
                    "Progaram Name :" + programname + "\n" +
                    "Time:" + starthour + ":" + startmin + "   Dutation : " + duration + "\n"
                    + selection;
    }

    public ProgaramVar() {
    }

    public ProgaramVar(String programname, int starthour, int startmin, int duration, ArrayList<String> selection) {
        this.programname = programname;
        this.starthour = starthour;
        this.startmin = startmin;
        this.duration = duration;
        this.selection = selection;
    }
}

