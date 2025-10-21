import javax.swing.*;
import java.awt.*;

public class FlowLayout extends JFrame {
    JPanel p1;

    public FlowLayout() {
        setSize(300, 200);
        setTitle("FlowLayout");
        p1 = new JPanel();

        p1.setLayout(new java.awt.FlowLayout());
        for (int i = 0; i < 10; i++) {
            p1.add(new JButton("Button" + i));
        }
        add(p1);
        setVisible(true);
    }
}

