package model;

import ui.InlistException;
import ui.Users;

import java.io.IOException;
import java.util.List;

public interface Items {

    String getName();

    List<Task> getTaskList();

    int getAge();

    //MODIFIES:this
    //EFFECTS:if the new task is not in the list then add them to the tasklist and my task
    //        otherwise do nothing
    void addtask(Task t);




}

