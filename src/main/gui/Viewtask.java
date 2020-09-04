package gui;

import model.Task;
import ui.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Viewtask extends JPanel {
    JButton back;
    JButton sort;

    public Viewtask(JFrame jf, Users admin) {
        setLayout(null);
        setSize(new Dimension(0,0));
        print(admin,jf);
        setSize(0, 0);
        this.setBackground(new Color(176,196,222));

        sort = new JButton("sort by time");
        sort.setBounds(400,250,200,100);
        sort.setFont(new Font("Courier ITALIC", Font.PLAIN, 20));
        add(sort);
        Sorttask sorted = new Sorttask(jf,admin);
        sort.addActionListener(sorted);

        back = new JButton("Back");
        back.setBounds(400,100,200,100);
        back.setFont(new Font("Courier ITALIC", Font.PLAIN, 20));
        add(back);
        ViewBackEvent backi = new ViewBackEvent(jf,admin);
        back.addActionListener(backi);





    }

    public class Sorttask implements ActionListener {
        JFrame jf;
        Users admin;


        public Sorttask(JFrame jf,Users admin) {
            this.admin = admin;
            this.jf = jf;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            admin.sort();
            print(admin,jf);
        }
    }


    public class ViewBackEvent implements ActionListener {
        JFrame jf;
        Users admin;


        public ViewBackEvent(JFrame jf,Users admin) {
            this.admin = admin;
            this.jf = jf;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

//            ScheduleWindow menuwindow = new ScheduleWindow(scheedulewindow,admin);
//            menuwindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//            menuwindow.setSize(1000,1000);
//            menuwindow.setVisible(true);
            Menu menu = new Menu(jf,admin);
            jf.setContentPane(menu);
            jf.validate();
        }
    }

    public void print(Users admin,JFrame jf) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < admin.getTaskList().size(); i++) {
            text.append("\n" + admin.getTaskList().get(i).getName() + " is dued on "
                    + admin.getTaskList().get(i).getDuedate());
        }
        String str = text.toString();
        str = str + "\n you have " +  admin.getTaskList().size() + " tasks";

        ImageIcon image = new ImageIcon("data\\3");

        JOptionPane.showMessageDialog(null,str,"View all tasks",
                JOptionPane.INFORMATION_MESSAGE,image);

    }
}

