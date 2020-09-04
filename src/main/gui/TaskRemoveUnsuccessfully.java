package gui;

import javax.swing.*;
import java.awt.*;

public class TaskRemoveUnsuccessfully extends JFrame {
    public JLabel label1;
    public ImageIcon image1;
    public JLabel imagelabel1;

    public TaskRemoveUnsuccessfully(JFrame jf) {
        setLayout((new GridLayout(0,1)));
        image1 = new ImageIcon("data\\5.jpg");
        imagelabel1 = new JLabel(image1);
        add(imagelabel1);

        label1 = new JLabel("Fail to remove the task");
        Font f = new Font("Verdana",Font.PLAIN,30);
        label1.setFont(f);
        label1.setForeground(Color.black);
        label1.setBounds(80,20,250,50);
        add(label1);

    }
}
