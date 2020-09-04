package gui;

import ui.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.black;
import static java.awt.Color.white;


public class LoginWindow extends JFrame {
    private JButton button1;
    private JLabel label1;
    private JButton button2;
    private JLabel label2;
    private JTextField text1;
    private JTextField text2;
    private ImageIcon image1;
    private JLabel imagelabel1;
    private ImageIcon image2;
    private JLabel imagelabel2;
    public Users admin;

    public LoginWindow() {
        setLayout(null);
        setSize(0,0);

        this.getContentPane().setBackground(new Color(176,196,222));

        image1 = new ImageIcon("data\\1.jpg");
        imagelabel1 = new JLabel(image1);
        add(imagelabel1);
        imagelabel1.setBounds(0,0,1000,150);

        label1 = new JLabel("Users name");
        Font f = new Font("Courier",Font.PLAIN,30);
        label1.setFont(f);
        label1.setForeground(black);
        label1.setBounds(300,250,400,50);

        add(label1);

        text1 = new JTextField(15);
        text1.setFont(new Font("Courier", Font.BOLD,20));
        text1.setBounds(300,300,400,50);
        add(text1);

        label2 = new JLabel("Password");
        Font h = new Font("Courier ITALIC",Font.PLAIN,30);
        label2.setFont(h);
        label2.setForeground(black);
        label2.setBounds(300,350,400,50);
        add(label2);

        text2 = new JTextField(20);
        text2.setSize(90,30);
        text2.setFont(new Font("Courier", Font.BOLD,20));
        text2.setBounds(300,400,400,50);
        add(text2);


        button1 = new JButton("login");
        button1.setFont(new Font("Courier", Font.BOLD, 20));
  //      button1.setForeground(black);
        button1.setBounds(400,500,100,40);
        add(button1);
  //      button1.setPreferredSize(new Dimension(100,50));
  //      button1.setLocation(300,300);
        button1.setBackground(white);

        Actionevent e = new Actionevent();
        button1.addActionListener(e);

        image2 = new ImageIcon("data\\2.jpg");
        imagelabel2 = new JLabel(image2);
        add(imagelabel2);
        imagelabel2.setBounds(0,750,1000,200);



    }

    public class Actionevent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            admin = new Users(text1.getText(),17,false);
            ScheduleWindow schedule = new ScheduleWindow(LoginWindow.this, admin);
            schedule.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            schedule.setSize(1000,1000);
            schedule.setVisible(true);


        }
    }

    public static void main(String[] args) {
        LoginWindow gui = new LoginWindow();
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gui.setSize(1000,1000);
        gui.setVisible(true);
     //   gui.pack();
        gui.setTitle("Student to do list");
    }
}