package ui;

import model.NormalTask;
import model.Task;
import model.UrgentTask;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectTask {
    public Scanner input;
    public ArrayList<Task> todo;


    public SelectTask() throws UncorrectException {
        input = new Scanner(System.in);
        todo = new ArrayList<>();
        run();
    }


//        Users u = new Users("aaa", 23, true);
//        NormalTask t = new NormalTask("hw", true, 915,true);
//
//        u.addNormalTask(t);;
//        u.save(u);
//        u.read("./data/information.txt");
//        check(u.getTaskList());


    //Modifies: null
    //Effect: select wheather they want to add normal task or urgent task

    public void run() throws UncorrectException {
        while (true) {
            System.out.println("what kind of task you would like to make?" + "[1]add NormalTask" + "[2]add UrgentTask");
            int choice = input.nextInt();
            if (choice == 1) {
                addNormalTask1();
            } else if (choice == 2) {
                addUrgentTask1();
            }

        }
    }
    //Modifies:this
    //Effect: based on the input construct a new normal task and add them to todo field;

    public void addNormalTask1() {
        Task task1 = new NormalTask("aaa", true, 999, true);
        System.out.println("input task name");
        String str1 = input.next();
        task1.setName(str1);
        System.out.println("input finish or not");
        Boolean b = input.nextBoolean();
        task1.setStatus(b);
        System.out.println("input duedate");
        Integer c = input.nextInt();
        task1.setDuedate(c);

        task1.setIsnormal(true);
        todo.add(task1);
        System.out.println("Task " + task1.getName() + " is added");
    }

    //Modifies:this
    //Effect: based on the input construct a new urgent task and add them to todo field;

    public void addUrgentTask1() {
        Task task2 = new UrgentTask("aaa", true, 999, false);
        System.out.println("input task name");
        String str1 = input.next();
        task2.setName(str1);
        System.out.println("input finish or not");
        Boolean b = input.nextBoolean();
        task2.setStatus(b);
        System.out.println("input duedate");
        Integer c = input.nextInt();
        task2.setDuedate(c);

        task2.setIsnormal(false);
        todo.add(task2);
        System.out.println("Task " + task2.getName() + " is added");

    }
}
