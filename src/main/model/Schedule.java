package model;


import java.util.List;

public interface Schedule {

    List<Task> getTaskList();

    //MODIFIES:this
    //EFFECTS:if the new task is not in the list then add them to the tasklist and my task
    //         otherwise do nothing
    void addtask(Task t);


}
