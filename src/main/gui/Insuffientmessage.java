package gui;

import javax.swing.*;
import java.awt.*;

public class Insuffientmessage extends JFrame {
    public JLabel label1;
    public ImageIcon image1;
    public JLabel imagelabel1;

    public Insuffientmessage(JFrame jf) {
        setLayout((new GridLayout(0,1)));
        image1 = new ImageIcon("data\\7.jpg");
        imagelabel1 = new JLabel(image1);
        add(imagelabel1);

        label1 = new JLabel("insufficient information to create a task");
        Font f = new Font("Verdana",Font.PLAIN,30);
        label1.setFont(f);
        label1.setForeground(Color.black);
        label1.setBounds(80,20,250,50);
        add(label1);

    }
}
