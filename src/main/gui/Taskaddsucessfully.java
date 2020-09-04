package gui;

import javax.swing.*;
import java.awt.*;

public class Taskaddsucessfully extends JFrame {

    JLabel label1;
    ImageIcon image1;
    JLabel imagelabel1;

    public Taskaddsucessfully(JFrame jf) {
        setLayout((new GridLayout(0,1)));

        image1 = new ImageIcon("data\\2.jpg");
        imagelabel1 = new JLabel(image1);
        add(imagelabel1);

        label1 = new JLabel("Task add successfully");
        Font f = new Font("Verdana",Font.PLAIN,30);
        label1.setFont(f);
        label1.setForeground(Color.black);
        add(label1);
    }
}
