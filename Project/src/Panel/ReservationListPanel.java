package Panel;

import Frame.MainFrame;
import Model.Reservation;
import dao.ReservationDAO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ReservationListPanel extends JPanel {

    private MainFrame mainFrame;
    private JPanel listPanel;
    private ReservationDAO reservationDAO = new ReservationDAO();

    public ReservationListPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(230, 0, 35));
        headerPanel.setPreferredSize(new Dimension(500, 60));

        JLabel headerLabel = new JLabel("예매 내역");
        headerLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setBorder(null);
        scrollPane.setBackground(Color.WHITE);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setPreferredSize(new Dimension(500, 80));

        JButton backBtn = new JButton("메인으로");
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

    public void updateList() {
        listPanel.removeAll();

        List<Reservation> reservations = reservationDAO.getAllReservations();

        if (reservations.isEmpty()) {
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

            listPanel.add(emptyPanel);
        } else {
            for (Reservation r : reservations) {
                JPanel item = new JPanel();
                item.setLayout(new BoxLayout(item, BoxLayout.Y_AXIS));
                item.setBackground(new Color(245, 245, 245));
                item.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
                item.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

                JLabel movieLabel = new JLabel("영화 ID: " + r.getMovieId());
                movieLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));

                JLabel seatLabel = new JLabel("좌석: " + r.getSeat());
                seatLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));

                JLabel timeLabel = new JLabel("예매 시간: " + r.getReservedAt());
                timeLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));

                item.add(movieLabel);
                item.add(Box.createVerticalStrut(5));
                item.add(seatLabel);
                item.add(Box.createVerticalStrut(5));
                item.add(timeLabel);

                listPanel.add(item);
                listPanel.add(Box.createVerticalStrut(10));
            }
        }

        listPanel.revalidate();
        listPanel.repaint();
    }
}
