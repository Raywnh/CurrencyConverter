import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame {
    MyPanel panel;
    ImageIcon icon;

    MyFrame()   {
        panel = new MyPanel();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,400);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        // Set icon of program
        icon = new ImageIcon(getClass().getClassLoader().getResource(".//res//money.png"));
        this.setIconImage(icon.getImage());

    }

}
