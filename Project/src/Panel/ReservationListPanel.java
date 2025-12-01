package Panel;

import Frame.MainFrame;
import javax.swing.*;
import java.awt.*;

public class ReservationListPanel extends JPanel {

    private MainFrame mainFrame;

    public ReservationListPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // 상단 헤더
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(230, 0, 35));
        headerPanel.setPreferredSize(new Dimension(500, 60));

        JLabel headerLabel = new JLabel("예매 내역");
        headerLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);

        add(headerPanel, BorderLayout.NORTH);

        // 중앙 빈 화면
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);

        JPanel emptyPanel = new JPanel();
        emptyPanel.setLayout(new BoxLayout(emptyPanel, BoxLayout.Y_AXIS));
        emptyPanel.setBackground(Color.WHITE);

        JLabel emptyIcon = new JLabel("📋", SwingConstants.CENTER);
        emptyIcon.setFont(new Font("맑은 고딕", Font.PLAIN, 80));
        emptyIcon.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label = new JLabel("예매 내역이 없습니다");
        label.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
        label.setForeground(new Color(150, 150, 150));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        emptyPanel.add(emptyIcon);
        emptyPanel.add(Box.createVerticalStrut(20));
        emptyPanel.add(label);

        centerPanel.add(emptyPanel);
        add(centerPanel, BorderLayout.CENTER);

        // 하단 버튼
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setPreferredSize(new Dimension(500, 80));

        JButton backBtn = new JButton("← 메인으로");
        backBtn.setPreferredSize(new Dimension(150, 50));
        backBtn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        backBtn.setBackground(new Color(100, 100, 100));
        backBtn.setForeground(Color.WHITE);
        backBtn.setFocusPainted(false);
        backBtn.setBorderPainted(false);
        backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backBtn.addActionListener(e -> mainFrame.switchPage("MAIN"));

        bottomPanel.add(backBtn);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}