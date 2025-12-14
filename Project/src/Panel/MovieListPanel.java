package Panel;

import Frame.MainFrame;

import javax.swing.*;
import java.awt.*;

public class MovieListPanel extends JPanel {

    public MovieListPanel(MainFrame frame) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(230, 0, 35));
        headerPanel.setPreferredSize(new Dimension(500, 60));

        JLabel headerLabel = new JLabel("상영 영화");
        headerLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        JPanel moviesPanel = new JPanel(new GridLayout(3, 2, 15, 15));
        moviesPanel.setBackground(Color.WHITE);
        moviesPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[][] movies = {
                {"주토피아 2", "애니메이션/모험", "전체", "Zootopia.png"},
                {"나우 유 씨미 3", "범죄/미스터리", "12세", "NowYouSeeMe.png"},
                {"위키드: 포 굿", "뮤지컬/판타지", "전체", "Wicked.png"},
                {"코렐라인", "애니메이션/판타지", "12세", "Coraline.png"},
                {"콰이어트 플레이스", "공포/스릴러", "15세", "QuietPlace.png"},
                {"인터스텔라", "SF/드라마", "12세", "Interstellar.png"}
        };

        for (int i = 0; i < movies.length; i++) {
            int movieId = i + 1;
            JPanel movieCard = createMovieCard(movies[i], frame, movieId);
            moviesPanel.add(movieCard);
        }

        add(moviesPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setPreferredSize(new Dimension(500, 70));

        JButton backBtn = new JButton("메인으로");
        backBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        backBtn.setPreferredSize(new Dimension(150, 45));
        backBtn.setBackground(new Color(100, 100, 100));
        backBtn.setForeground(Color.WHITE);
        backBtn.setFocusPainted(false);
        backBtn.setBorderPainted(false);
        backBtn.addActionListener(e -> frame.switchPage("MAIN"));

        bottomPanel.add(backBtn);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JPanel createMovieCard(String[] movieData, MainFrame frame, int movieId) {
        String title = movieData[0];
        String info = movieData[1];
        String rating = movieData[2];
        String posterName = movieData[3];

        JPanel card = new JPanel();
        card.setLayout(new BorderLayout(10, 10));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JLabel posterLabel = new JLabel();
        posterLabel.setPreferredSize(new Dimension(80, 110));

        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/posters/" + posterName));
        Image img = icon.getImage().getScaledInstance(80, 110, Image.SCALE_SMOOTH);
        posterLabel.setIcon(new ImageIcon(img));

        card.add(posterLabel, BorderLayout.WEST);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));

        JLabel infoLabel = new JLabel(info);
        infoLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
        infoLabel.setForeground(new Color(100, 100, 100));

        JLabel ratingLabel = new JLabel("관람등급: " + rating);
        ratingLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
        ratingLabel.setForeground(new Color(230, 0, 35));

        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(titleLabel);
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(infoLabel);
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(ratingLabel);

        card.add(infoPanel, BorderLayout.CENTER);

        card.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.getReservationData().setMovieId(movieId);
                frame.getReservationData().setMovieTitle(title);
                frame.goToSeatSelect(movieId);
            }
        });

        return card;
    }
}
