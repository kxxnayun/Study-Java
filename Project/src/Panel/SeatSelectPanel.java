package Panel;

import Frame.MainFrame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class SeatSelectPanel extends JPanel {

    private JButton[][] seatButtons = new JButton[6][8];
    private List<String> selectedSeats = new ArrayList<>();
    private int maxSeats = 1;
    private JLabel selectedInfoLabel;
    private MainFrame frame;
    private List<JButton> numberButtons = new ArrayList<>();
    private JButton selectedNumberButton = null;

    public SeatSelectPanel(MainFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(230, 0, 35));
        headerPanel.setPreferredSize(new Dimension(500, 60));

        JLabel headerLabel = new JLabel("좌석 선택");
        headerLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);

        add(headerPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        topPanel.setBackground(Color.WHITE);

        JLabel label1 = new JLabel("인원 선택:");
        label1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        topPanel.add(label1);

        for (int i = 1; i <= 5; i++) {
            JButton memBtn = createNumberButton(String.valueOf(i));
            final int count = i;
            memBtn.addActionListener(e -> {
                maxSeats = count;
                selectedInfoLabel.setText("선택된 좌석: 0/" + maxSeats);

                if (selectedNumberButton != null) {
                    resetButtonColor(selectedNumberButton);
                }
                selectedNumberButton = memBtn;
                setSelectedButtonColor(memBtn);
            });
            numberButtons.add(memBtn);
            topPanel.add(memBtn);
        }

        centerPanel.add(topPanel, BorderLayout.NORTH);

        JPanel seatAreaPanel = new JPanel(new BorderLayout());
        seatAreaPanel.setBackground(Color.WHITE);
        seatAreaPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JPanel screenPanel = new JPanel();
        screenPanel.setBackground(new Color(50, 50, 50));
        screenPanel.setPreferredSize(new Dimension(400, 30));
        JLabel screenLabel = new JLabel("SCREEN", SwingConstants.CENTER);
        screenLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        screenLabel.setForeground(Color.WHITE);
        screenPanel.add(screenLabel);
        seatAreaPanel.add(screenPanel, BorderLayout.NORTH);

        JPanel seatPanel = new JPanel(new GridLayout(6, 8, 8, 8));
        seatPanel.setBackground(Color.WHITE);
        seatPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        char row = 'A';
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                String seatName = row + String.valueOf(j + 1);
                seatButtons[i][j] = createSeatButton(seatName);
                seatPanel.add(seatButtons[i][j]);
            }
            row++;
        }

        seatAreaPanel.add(seatPanel, BorderLayout.CENTER);
        centerPanel.add(seatAreaPanel, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setPreferredSize(new Dimension(500, 100));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        selectedInfoLabel = new JLabel("선택된 좌석: 0/" + maxSeats);
        selectedInfoLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        selectedInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bottomPanel.add(selectedInfoLabel, BorderLayout.NORTH);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnPanel.setBackground(Color.WHITE);

        JButton backBtn = new JButton("이전");
        backBtn.setPreferredSize(new Dimension(120, 45));
        backBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        backBtn.setBackground(new Color(150, 150, 150));
        backBtn.setForeground(Color.WHITE);
        backBtn.setFocusPainted(false);
        backBtn.setBorderPainted(false);
        backBtn.addActionListener(e -> {
            frame.switchPage("MOVIE_LIST");
        });

        JButton goToConfirmBtn = new JButton("다음");
        goToConfirmBtn.setPreferredSize(new Dimension(120, 45));
        goToConfirmBtn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        goToConfirmBtn.setBackground(new Color(230, 0, 35));
        goToConfirmBtn.setForeground(Color.WHITE);
        goToConfirmBtn.setFocusPainted(false);
        goToConfirmBtn.setBorderPainted(false);
        goToConfirmBtn.addActionListener(e -> {
            if (selectedSeats.size() == maxSeats) {
                frame.getReservationData().setPeopleCount(maxSeats);
                frame.getReservationData().setSelectedSeats(new ArrayList<>(selectedSeats));
                frame.switchPage("CONFIRM");
            } else {
                JOptionPane.showMessageDialog(this,
                        "인원 수만큼 좌석을 선택해주세요!",
                        "알림",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        btnPanel.add(backBtn);
        btnPanel.add(goToConfirmBtn);
        bottomPanel.add(btnPanel, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JButton createNumberButton(String text) {
        JButton btn = new JButton(text);
        btn.setPreferredSize(new Dimension(60, 60));
        btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        btn.setBackground(new Color(220, 220, 220));
        btn.setForeground(Color.BLACK);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);

        Color defaultColor = new Color(220, 220, 220);
        Color hoverColor = new Color(200, 200, 200);

        return btn;
    }

    private void setSelectedButtonColor(JButton btn) {
        btn.setBackground(new Color(230, 0, 35));
        btn.setForeground(Color.WHITE);
    }

    private void resetButtonColor(JButton btn) {
        btn.setBackground(new Color(220, 220, 220));
        btn.setForeground(Color.BLACK);
    }

    private JButton createSeatButton(String seatName) {
        JButton seat = new JButton(seatName);
        seat.setPreferredSize(new Dimension(45, 45));
        seat.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
        seat.setBackground(new Color(220, 220, 220));
        seat.setForeground(Color.BLACK);
        seat.setFocusPainted(false);
        seat.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        seat.addActionListener(e -> {
            if (selectedSeats.contains(seatName)) {
                selectedSeats.remove(seatName);
                seat.setBackground(new Color(220, 220, 220));
                seat.setForeground(Color.BLACK);
            } else {
                if (selectedSeats.size() < maxSeats) {
                    selectedSeats.add(seatName);
                    seat.setBackground(new Color(230, 0, 35));
                    seat.setForeground(Color.WHITE);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "최대 " + maxSeats + "석까지 선택 가능합니다!",
                            "알림",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            selectedInfoLabel.setText("선택된 좌석: " + selectedSeats.size() + "/" + maxSeats);
        });

        return seat;
    }

    public void resetAll() {
        maxSeats = 1;
        selectedSeats.clear();
        selectedInfoLabel.setText("선택된 좌석: 0/1");

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                seatButtons[i][j].setBackground(new Color(220, 220, 220));
                seatButtons[i][j].setForeground(Color.BLACK);
            }
        }

        if (selectedNumberButton != null) {
            resetButtonColor(selectedNumberButton);
            selectedNumberButton = null;
        }
    }

}
