package Panel;

import Frame.*;
import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel(MainFrame frame) {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 240, 245));

        // 타이틀 영역
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(240, 240, 245));
        topPanel.setPreferredSize(new Dimension(500, 200));

        JLabel title = new JLabel("CGV");
        title.setFont(new Font("맑은 고딕", Font.BOLD, 60));
        title.setForeground(new Color(230, 0, 35));
        topPanel.add(title);

        add(topPanel, BorderLayout.NORTH);

        // 중앙 버튼 영역
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(new Color(240, 240, 245));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 15, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 예매하기 버튼
        JButton goToMovieList = createStyledButton("예매하기", new Color(230, 0, 35));
        goToMovieList.addActionListener(e -> frame.switchPage("MOVIE_LIST"));
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(goToMovieList, gbc);

        // 예매 내역 확인 버튼
        JButton resCon = createStyledButton("예매 내역", new Color(50, 50, 50));
        resCon.addActionListener(e -> frame.switchPage("RESERVATION_LIST"));
        gbc.gridy = 1;
        centerPanel.add(resCon, gbc);

        add(centerPanel, BorderLayout.CENTER);
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(300, 80));
        button.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return button;
    }
}