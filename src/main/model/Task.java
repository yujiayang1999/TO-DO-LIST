package model;

import ui.NotcorrectType;
import ui.UncorrectException;

import java.util.HashMap;
import java.util.Objects;

public abstract class Task {
    private String name;
    private Boolean status;
    private int duedate;
    private Boolean isnormal;
    //TODO:HASHMAP
//    private HashMap<String, Task> map;



    public Task(String name, Boolean status, int duedate, Boolean isnormal) {
        this.name = name;
        this.status = status;
        this.duedate = duedate;
        this.isnormal = isnormal;

    }

    //getters

    public String getName() {
        return name;
    }

    public Boolean getStatus() {
        return status;
    }

    public int getDuedate() {
        return duedate;
    }

    public Boolean getIsnormal() {
        return isnormal;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setDuedate(int duedate) {
        this.duedate = duedate;
    }

    public void setIsnormal(Boolean isnormal) {
        this.isnormal = isnormal;
    }


    //MODIFIES: this
    //EFFECTS: set the task into finish status
    public void finish() {
        status = true;
    }


    //MODIFIES:this
    //EFFECTS: change the new due date
    public void change(int a) {
        duedate = a;
    }

    //MODIFIES: this
    //EFFECT:change the type of the task if the boolean is opposite of initial
    //       otherwise throw to UncorrectException

    protected void changetype(Boolean b) throws UncorrectException {
        if (b == this.getIsnormal()) {
            setIsnormal(!b);
        } else {
            throw new UncorrectException();
        }
    }

    //Effect: based on the name of the task to compare weather they are same or not

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Task)) {
            return false;
        }
        Task task = (Task) o;
        return Objects.equals(name, task.name);
    }

    //Effect: get the name hashcode of the object
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

