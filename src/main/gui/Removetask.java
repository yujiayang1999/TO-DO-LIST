package gui;

import model.NormalTask;
import model.Schedule;
import ui.UncorrectException;
import ui.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class Removetask extends JPanel {
    JLabel label1;
    JTextField text1;
    JButton button1;
    JButton button2;

    ScheduleWindow schedulewindow;

    public Removetask(JFrame jf,Users admin) {

        setLayout(new GridLayout(0,1));
        setSize(0,0);

        label1 = new JLabel("the name of delete task");
        Font f = new Font("Courier ITALIC",Font.PLAIN,20);
        label1.setFont(f);
        label1.setForeground(Color.black);
        add(label1);
        text1 = new JTextField(10);
        text1.setFont(f);
        text1.setForeground(Color.black);
        add(text1);

        button1 = new JButton("Submit");
        button1.setFont(f);
        add(button1);

        Deleteevent d = new Deleteevent(jf,admin);
        button1.addActionListener(d);


        button2 = new JButton("Back");
        button2.setFont(f);
        add(button2);
        RBackEvent rback = new RBackEvent(jf,admin);
        button2.addActionListener(rback);


    }

    public class RBackEvent implements ActionListener {
        public Users admin;
        public JFrame jf;

        public RBackEvent(JFrame jf, Users admin) {
            this.admin = admin;
            this.jf = jf;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Menu menu = new Menu(jf,admin);
            jf.setContentPane(menu);
            jf.validate();
        }
    }

    public class Deleteevent implements ActionListener {
        public Users admin;
        public JFrame jf;

        public Deleteevent(JFrame jf,Users admin) {
            this.admin = admin;
            this.jf = jf;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                String taskname = text1.getText();
                admin.removetask(taskname);
                TaskRemoveSuccessfully removewindow = new TaskRemoveSuccessfully(jf);
                removewindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                removewindow.setSize(500,500);
                removewindow.setVisible(true);


            } catch (UncorrectException ex) {

                TaskRemoveUnsuccessfully failremovewindow = new TaskRemoveUnsuccessfully(jf);
                failremovewindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                failremovewindow.setSize(500,500);
                failremovewindow.setVisible(true);
                System.out.println("task remove successfully");
            }


        }

    }
}




