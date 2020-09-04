package ui;

import model.*;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

//represent the name and the time of the task
public class Main {

    public static void main(String[] args) throws UncorrectException, InlistException {
        SelectTask aaa = new SelectTask();
        Users a = new Users("jessy",17,false);
        Task bbb = new NormalTask("tom",false,1213,true);

        Observer b = new Moniter("jessy");
        a.addObserver(b);
        a.addtask(bbb);

        NormalTask ccc = new NormalTask("chem",false,1207,true);
        a.addtask(ccc);

        NormalTask ddd = new NormalTask("phys",false,1203,true);
        UrgentTask eee = new UrgentTask("stathw",false,1107,false);





    }


}

