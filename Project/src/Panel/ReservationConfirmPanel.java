package Panel;

import Frame.MainFrame;
import Model.ReservationData;
import javax.swing.*;
import java.awt.*;

public class ReservationConfirmPanel extends JPanel {

    private MainFrame frame;
    private JLabel movieTitleLabel;
    private JLabel peopleLabel;
    private JLabel seatsLabel;

    public ReservationConfirmPanel(MainFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(230, 0, 35));
        headerPanel.setPreferredSize(new Dimension(500, 60));

        JLabel headerLabel = new JLabel("예매 확인");
        headerLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);

        add(headerPanel, BorderLayout.NORTH);

        JPanel centerWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 40));
        centerWrapper.setBackground(Color.WHITE);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 40, 40));
        infoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel checkIcon = new JLabel("✓", SwingConstants.CENTER);
        checkIcon.setFont(new Font("맑은 고딕", Font.BOLD, 80));
        checkIcon.setForeground(new Color(0, 180, 0));
        checkIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(checkIcon);

        infoPanel.add(Box.createVerticalStrut(20));

        JLabel confirmMsg = new JLabel("예매가 완료되었습니다!", SwingConstants.CENTER);
        confirmMsg.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        confirmMsg.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(confirmMsg);

        infoPanel.add(Box.createVerticalStrut(40));

        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
        cardPanel.setBackground(new Color(250, 250, 250));
        cardPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(25, 25, 25, 25)
        ));
        cardPanel.setMaximumSize(new Dimension(400, 260));
        cardPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        movieTitleLabel = createInfoLabel("영화: ", "");
        peopleLabel = createInfoLabel("인원: ", "");
        seatsLabel = createInfoLabel("좌석: ", "");

        cardPanel.add(movieTitleLabel);
        cardPanel.add(Box.createVerticalStrut(15));
        cardPanel.add(peopleLabel);
        cardPanel.add(Box.createVerticalStrut(15));
        cardPanel.add(seatsLabel);

        infoPanel.add(cardPanel);
        centerWrapper.add(infoPanel);

        add(centerWrapper, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 20));
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setPreferredSize(new Dimension(500, 80));

        JButton goToMainBtn = new JButton("메인으로");
        goToMainBtn.setPreferredSize(new Dimension(150, 50));
        goToMainBtn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        goToMainBtn.setBackground(new Color(230, 0, 35));
        goToMainBtn.setForeground(Color.WHITE);
        goToMainBtn.setFocusPainted(false);
        goToMainBtn.setBorderPainted(false);
        goToMainBtn.addActionListener(e -> {
            frame.resetReservation();
            frame.switchPage("MAIN");
        });

        bottomPanel.add(goToMainBtn);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JLabel createInfoLabel(String label, String value) {
        JLabel jLabel = new JLabel(label + value);
        jLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        jLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        return jLabel;
    }

    public void updateReservationInfo() {
        ReservationData data = frame.getReservationData();

        movieTitleLabel.setText("영화: " + (data.getMovieTitle() != null ? data.getMovieTitle() : "미선택"));
        peopleLabel.setText("인원: " + data.getPeopleCount() + "명");

        String seats = String.join(", ", data.getSelectedSeats());
        seatsLabel.setText("좌석: " + (seats.isEmpty() ? "미선택" : seats));
    }
}
