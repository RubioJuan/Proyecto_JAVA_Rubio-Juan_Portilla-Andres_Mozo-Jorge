package Dao;


import connection.MySQLDataSource;
import Model.ActivityPrize;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityPrizeDao {
    private MySQLDataSource dataSource;

    public ActivityPrizeDao() {
        this.dataSource = new MySQLDataSource();
    }

    public List<ActivityPrize> getAllPrizes() {
        List<ActivityPrize> prizes = new ArrayList<>();
        String query = "SELECT * FROM Prizes";
        try (Connection con = dataSource.conectarMySQL();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                ActivityPrize prize = new ActivityPrize(
                        rs.getInt("prize_id"),
                        rs.getString("type"),
                        rs.getString("description"),
                        rs.getDouble("value"),
                        rs.getString("status"),
                        rs.getInt("activity_id"),
                        rs.getInt("participant_id")
                );
                prizes.add(prize);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prizes;
    }

    public void addPrize(ActivityPrize prize) {
        String query = "INSERT INTO Prizes (type, description, value, status, activity_id, participant_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, prize.getType());
            pstmt.setString(2, prize.getDescription());
            pstmt.setDouble(3, prize.getValue());
            pstmt.setString(4, prize.getStatus());
            pstmt.setInt(5, prize.getActivityId());
            pstmt.setInt(6, prize.getParticipantId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
