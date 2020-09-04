package gui;


import ui.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScheduleWindow extends JFrame {
    Users admin;

    public ScheduleWindow(JFrame frame, Users admin) {
        super();
        this.admin = admin;
        setBackground(new Color(192,192,192));
        setVisible(true);
        setSize(1000,1000);
        Menu menu = new Menu(this, admin);
        add(menu);
    }
}