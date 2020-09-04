package gui;

import ui.Users;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Menu extends JPanel {
    JMenuBar menubar;
    JMenu menu;
    JMenuItem exit;

    JButton button;
    JLabel label;
    JLabel welcome;
    int counter = 0;
    int xxx = 0;
    String string;

    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;

    public Menu(JFrame jf, Users admin) {
        super();
        this.setLayout(null);
        setSize(0, 0);
        this.setBackground(new Color(176,196,222));

        //exit
        menubar = new JMenuBar();
        menubar.setBounds(0,0,70,35);
        add(menubar);
        menu = new JMenu("File");
        menu.setFont(new Font("Courier",Font.PLAIN,15));
        menu.setBounds(0,0,70,35);
        menubar.add(menu);
        exit = new JMenuItem("Exit");
        exit.setBounds(0,35,40,20);
        menu.add(exit);
        Exitevent e = new Exitevent();
        exit.addActionListener(e);

        welcome = new JLabel("welcome:)!");
        Font f = new Font("Courier",Font.ITALIC,50);
        welcome.setFont(f);
        welcome.setForeground(new Color(230,230,250));
        welcome.setBounds(400,0,1000,100);
        add(welcome);
        //Sound
        button = new JButton("Sounds");
        button.setBounds(400,100,200,100);
        button.setFont(new Font("Courier ITALIC", Font.PLAIN, 20));
        add(button);
        label = new JLabel("");
        add(label);
        Soundevent se = new Soundevent();
        button.addActionListener(se);
        //buttons
        button1 = new JButton("Add Normal Task");
        button1.setBounds(400,250,200,100);
        button1.setFont(new Font("Courier ITALIC", Font.PLAIN, 20));
        add(button1);
        Addevent addevent = new Addevent(jf,admin);
        button1.addActionListener(addevent);


        button4 = new JButton("Add Urgent Task");
        button4.setBounds(400,400,200,100);
        button4.setFont(new Font("Courier ITALIC", Font.PLAIN, 20));
        add(button4);
        Adduevent adduevent = new Adduevent(jf,admin);
        button4.addActionListener(adduevent);


        button2 = new JButton("Remove Task");
        button2.setBounds(400,550,200,100);
        button2.setFont(new Font("Courier ITALIC", Font.PLAIN, 20));
        add(button2);
        Removeevent remove = new Removeevent(jf,admin);
        button2.addActionListener(remove);

        button3 = new JButton("View all tasks");
        button3.setBounds(400,700,200,100);
        button3.setFont(new Font("Courier ITALIC", Font.PLAIN, 20));
        add(button3);
        Tasklist tasklist = new Tasklist(jf,admin);
        button3.addActionListener(tasklist);

    }

    public class Tasklist implements ActionListener {
        Users admin;
        JFrame jf;

        public Tasklist(JFrame jf,Users admin) {
            this.admin = admin;
            this.jf = jf;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
//            Viewtask task = new Viewtask(jf, admin);
//            jf.setContentPane(task);
//            jf.validate();
            Viewtask view = new Viewtask(jf,admin);
            jf.setContentPane(view);
            jf.validate();
        }
    }
//            Viewtask view = new Viewtask(ScheduleWindow.this,admin);
//            view.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//            view.setSize(2000,2000);
//            view.setVisible(true);
//        }
//    }

    public class Adduevent implements ActionListener {
        Users admin;
        JFrame jf;

        public Adduevent(JFrame jf, Users admin) {
            this.admin = admin;
            this.jf = jf;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Addurgentevent add = new Addurgentevent(jf, admin);
            jf.setContentPane(add);
            jf.validate();
        }
    }

    public class Removeevent implements ActionListener {
        Users admin;
        JFrame jf;

        public Removeevent(JFrame jf,Users admin) {
            this.admin = admin;
            this.jf = jf;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Removetask add = new Removetask(jf,admin);
            jf.setContentPane(add);
            jf.validate();
        }
    }

    public class Addevent implements ActionListener {
        Users admin;
        JFrame jf;

        public Addevent(JFrame jf,Users admin) {
            this.admin = admin;
            this.jf = jf;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Addnormaltask add = new Addnormaltask(jf,admin);
            jf.setContentPane(add);
            jf.validate();
//            add.setSize(1000,1000);
//            add.setVisible(true);
        }
    }

    public class Exitevent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public class Soundevent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//            Toolkit.getDefaultToolkit().beep();
//            counter++;
//            if (xxx == 0) {
//                string = "time";
//            } else if (xxx == 1) {
//                string = "times";
//            }
//            label.setText("You have clicked  " + counter + " " + string);
//            xxx = 1;
            //TODO: add music;
            playSound("data\\sheep.wav");
        }

        public void playSound(String soundName) {
            try {
                AudioInputStream audioInputStream =
                        AudioSystem.getAudioInputStream(new File(soundName));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                System.out.println("Error with playing sound.");
                ex.printStackTrace();
            }
        }
    }
}


