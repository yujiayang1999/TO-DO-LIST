package gui;


import model.NormalTask;
import ui.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Addnormaltask extends JPanel {
    JLabel label1;
    JLabel label2;
    JLabel label3;

    JTextField text3;
    JTextField text1;
    JTextField text2;
    JButton button1;
    JButton button2;



    public Addnormaltask(JFrame jf, Users admin) {
        setLayout(new GridLayout(0,1));
        setSize(0,0);

        label1 = new JLabel("Task Name");
        Font f = new Font("Courier ITALIC",Font.PLAIN,20);
        label1.setFont(f);
        label1.setForeground(Color.black);
        add(label1);
        text1 = new JTextField(10);
        text1.setFont(f);
        text1.setForeground(Color.black);
        add(text1);

        label2 = new JLabel("Status (true/false)");
        label2.setFont(f);
        label2.setForeground(Color.black);
        add(label2);
        text2 = new JTextField(15);
        text2.setFont(f);
        text2.setForeground(Color.black);
        add(text2);

        label3 = new JLabel("Duedate (mm-dd)");
        label3.setFont(f);
        label3.setForeground(Color.black);
        add(label3);
        text3 = new JTextField(15);
        text3.setFont(f);
        text3.setForeground(Color.black);
        add(text3);



//        label4 = new JLabel("Is it a normal task?");
//        add(label4);
//        text4 = new JTextField(15);
//        add(text4);

        button1 = new JButton("Submit");
        button1.setFont(f);
        add(button1);
        CreatNTask e = new CreatNTask(jf,admin);
        button1.addActionListener(e);

        button2 = new JButton("Back");
        button2.setFont(f);
        add(button2);
        BackEvent back = new BackEvent(jf,admin);
        button2.addActionListener(back);



    }

    public class BackEvent implements ActionListener {
        JFrame jf;
        Users admin;


        public BackEvent(JFrame jf,Users admin) {
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

    public class CreatNTask implements ActionListener {
        Users admin;
        JFrame jf;

        public CreatNTask(JFrame jf,Users admin) {
            this.admin = admin;
            this.jf = jf;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Boolean due = Boolean.parseBoolean(text2.toString());
                String text3string = text3.getText();
                int i = Integer.parseInt(text3string);
                Boolean normal = true;
                NormalTask a = new NormalTask(text1.getText(), due, i, normal);
                admin.addtask(a);
                Taskaddsucessfully successwindow = new Taskaddsucessfully(jf);
                successwindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                successwindow.setSize(500, 500);
                successwindow.setVisible(true);
            } catch (NumberFormatException n) {
                Insuffientmessage insufficient = new Insuffientmessage(jf);
                insufficient.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                insufficient.setSize(500,500);
                insufficient.setVisible(true);
            }

        }

    }
}
