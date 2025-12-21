package dao;

import db.DBManager;
import Model.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {

    public void insertReservation(int movieId, String seat) {
        String sql = "INSERT INTO reservations (movie_id, seat) VALUES (?, ?)";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, movieId);
            ps.setString(2, seat);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getReservedSeats(int movieId) {
        List<String> seats = new ArrayList<>();
        String sql = "SELECT seat FROM reservations WHERE movie_id = ?";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, movieId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                seats.add(rs.getString("seat"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return seats;
    }

    public List<Reservation> getAllReservations() {
        List<Reservation> list = new ArrayList<>();

        String sql =
                "SELECT r.id, m.title, r.seat " +
                        "FROM reservations r " +
                        "JOIN movies m ON r.movie_id = m.id " +
                        "ORDER BY r.id DESC";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Reservation(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("seat")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
