package ui;

import model.*;
import model.Date;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Users extends Observable implements Items, Schedule {
    public String name;
    private int age;
    private Boolean male;
    private List<Task> mytask;
    private HashMap<String, Task> tasks;
    private List<Date> dates;


    public Users(String name, int age, Boolean male) {
        this.name = name;
        this.age = age;
        this.male = male;
        mytask = new ArrayList<>();
        tasks = new HashMap<>();
        dates = new ArrayList<>();
    }
    //getters

    public Boolean getMale() {
        return male;
    }


    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

    public List<Task> getMytask() {
        return mytask;
    }

    public List<Date> getDates() {
        return dates;
    }

    public List<Task> getTaskList() {
        return mytask;
    }
    //Modifies: this
    //Effect:sort mytask list by the time of duedate

    public void sort() {
        Collections.sort(mytask, Comparator
                .comparing(Task::getName)
                .thenComparing(Task::getDuedate));

    }




    //MODIFIES:this
    //EFFECTS:if the new task is not in the list then add them to the tasklist and my task
    //        otherwise do nothing


    public void addtask(Task b)  {
        if (!mytask.contains(b)) {
            mytask.add(b);
            tasks.put(b.getName(), b);
            setChanged();
            notifyObservers(b);

        }
    }

    //Modifies: this
    //Effects: if there is a task called a in the list then delete it
    //         otherwise throw to UncorrectException

    public void removetask(String a) throws UncorrectException {
        if (tasks.containsKey(a)) {
            Task task = tasks.get(a);
            tasks.remove(a);
            mytask.remove(task);
        } else {
            throw new UncorrectException();
        }
    }

    //Modifies: null(the information file)
    //Effects: save the user name into a file in /data/information.txt;

    public void save(Users a) throws IOException {

        File userinformation = new File("./data/information.txt");
        userinformation.createNewFile();
        FileWriter writer = new FileWriter("./data/information.txt");
        String saveUser = a.getName();
        writer.write(saveUser);
        writer.flush();
        writer.close();


    }
    //Modifies:null
    //Effect: read the name of the user from the file

    public String read(String filename) throws IOException {
        List<String> alltask;
        alltask = new ArrayList<>();

        Path path = Paths.get("./data/information.txt");
        List<String> str = Files.readAllLines(path);
        return str.get(0);
    }

    //Modifies:this and data
    //Effect: if the dates list doesn't contain the new date then add the date to dates and on that date add the user
    //        otherwise do nothing

    public void adddate(Date a) {
        if (!dates.contains(a)) {
            dates.add(a);
            a.addUser(this);
        }
    }

    //Effect: based on the dates list to determine the two users are equal or not
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Users users = (Users) o;
        return dates.equals(users.dates);
    }

    //Effect :get the dates hashcode of the object
    @Override
    public int hashCode() {
        return Objects.hash(dates);
    }

}

