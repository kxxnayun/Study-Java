package dao;

import db.DBManager;
import Model.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {

    // 예약 저장
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

    // 영화 예약된 좌석 목록 조회
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

    // 전체 예약 목록 조회
    public List<Reservation> getAllReservations() {
        List<Reservation> list = new ArrayList<>();
        String sql = "SELECT * FROM reservations ORDER BY reserved_at DESC";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Reservation(
                        rs.getInt("id"),
                        rs.getInt("movie_id"),
                        rs.getString("seat"),
                        rs.getTimestamp("reserved_at").toString()
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
