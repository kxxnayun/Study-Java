package Frame;

import Panel.MainPanel;
import Panel.MovieListPanel;
import Panel.SeatSelectPanel;
import Panel.ReservationConfirmPanel;
import Panel.ReservationListPanel;
import Model.ReservationData;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    private MainPanel mainPanel;
    private MovieListPanel movieListPanel;
    private SeatSelectPanel seatSelectPanel;
    private ReservationConfirmPanel reservationConfirmPanel;
    private ReservationListPanel reservationListPanel;

    private ReservationData reservationData;

    public MainFrame() {

        UIManager.put("Button.background", Color.BLACK);
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.borderPainted", false);
        UIManager.put("Button.opaque", true);
        UIManager.put("Button.focusPainted", false);

        setTitle("CGV 영화 예매");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        reservationData = new ReservationData();

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        mainPanel = new MainPanel(this);
        movieListPanel = new MovieListPanel(this);
        seatSelectPanel = new SeatSelectPanel(this);
        reservationConfirmPanel = new ReservationConfirmPanel(this);
        reservationListPanel = new ReservationListPanel(this);

        cardPanel.add(mainPanel, "MAIN");
        cardPanel.add(movieListPanel, "MOVIE_LIST");
        cardPanel.add(seatSelectPanel, "SEAT");
        cardPanel.add(reservationConfirmPanel, "CONFIRM");
        cardPanel.add(reservationListPanel, "RESERVATION_LIST");

        add(cardPanel);
        setVisible(true);
    }

    public void switchPage(String name) {
        if (name.equals("CONFIRM")) {
            reservationConfirmPanel.updateReservationInfo();
        }
        cardLayout.show(cardPanel, name);
    }

    public ReservationData getReservationData() {
        return reservationData;
    }

    public void resetReservation() {
        reservationData.reset();
    }
}
