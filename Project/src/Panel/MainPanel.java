package Panel;

import Frame.*;
import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel(MainFrame frame) {
        setLayout(null);
        setBackground(new Color(240, 240, 245));

        JButton goToMovieList = createStyledButton("예매하기", new Color(230, 0, 35));
        goToMovieList.setBounds(100, 220, 300, 80);
        goToMovieList.addActionListener(e -> frame.switchPage("MOVIE_LIST"));
        add(goToMovieList);

        JButton resCon = createStyledButton("예매 내역", new Color(50, 50, 50));
        resCon.setBounds(100, 330, 300, 80);
        resCon.addActionListener(e -> frame.switchPage("RESERVATION_LIST"));
        add(resCon);
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }
}
