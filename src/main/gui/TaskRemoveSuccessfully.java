package gui;

import javax.swing.*;
import java.awt.*;

public class TaskRemoveSuccessfully extends JFrame {
    JLabel label1;
    ImageIcon image1;
    JLabel imagelabel1;

    public TaskRemoveSuccessfully(JFrame jf) {
        setLayout((new GridLayout(0,1)));

        image1 = new ImageIcon("data\\4.jpg");
        imagelabel1 = new JLabel(image1);
        add(imagelabel1);

        label1 = new JLabel("Task remove successfully");
        Font f = new Font("Verdana",Font.PLAIN,30);
        label1.setFont(f);
        label1.setForeground(Color.black);
        label1.setBounds(80,20,250,50);
        add(label1);
    }

}

