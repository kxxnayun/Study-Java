import javax.swing.*;
import java.awt.*;

public class Random extends JFrame {
    JPanel p = new JPanel();
    JLabel[] labels = new JLabel[30];

    public Random() {
        p.setLayout(null);
        p.setBackground(Color.YELLOW);

        for (int i = 0; i < 30; i++) {
            labels[i] = new JLabel( "" + i);
            int x = (int) (500 * Math.random());
            int y = (int) (300 * Math.random());
            labels[i].setForeground(Color.MAGENTA);
            labels[i].setLocation(x, y);
            labels[i].setSize(20, 20);
            p.add(labels[i]);
        }

        setSize(500, 300);
        add(p);
        setVisible(true);
    }
}