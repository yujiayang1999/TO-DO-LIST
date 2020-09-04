package model;

import ui.Users;

import java.util.Observable;
import java.util.Observer;

public class Moniter implements Observer {
    private String name;

    public Moniter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //Effect: when the user add a task, print the duedate of the task to remind the user

    @Override
    public void update(Observable o, Object arg) {
        Task a = (Task) arg;
        System.out.println("on " + a.getDuedate() + " you have a to-do item");
    }
}
