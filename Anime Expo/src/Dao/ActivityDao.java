/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Andres Portilla 
 */

import model.Activity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import connection.MySQLDataSource;

public class ActivityDao {

    private Connection connection;

    public ActivityDao() {
        MySQLDataSource dataSource = new MySQLDataSource();
        this.connection = dataSource.conectarMySQL();
    }

    public void createActivity(Activity activity) {
        String sql = "INSERT INTO Activities (name, type, category, participant_count, event_id, start_time) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, activity.getName());
            pstmt.setString(2, activity.getType());
            pstmt.setString(3, activity.getCategory());
            pstmt.setInt(4, activity.getParticipantCount());
            pstmt.setInt(5, activity.getEventId());
            pstmt.setString(6, activity.getStartTime());
            pstmt.executeUpdate();
            System.out.println("Actividad creada exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Activity> getAllActivities() {
        List<Activity> activities = new ArrayList<>();
        String sql = "SELECT * FROM Activities";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Activity activity = new Activity(
                        rs.getInt("activity_id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getString("category"),
                        rs.getInt("participant_count"),
                        rs.getInt("event_id"),
                        rs.getString("start_time")
                );
                activities.add(activity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activities;
    }

    public void updateActivity(Activity activity) {
        String sql = "UPDATE Activities SET name = ?, type = ?, category = ?, participant_count = ?, event_id = ?, start_time = ? WHERE activity_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, activity.getName());
            pstmt.setString(2, activity.getType());
            pstmt.setString(3, activity.getCategory());
            pstmt.setInt(4, activity.getParticipantCount());
            pstmt.setInt(5, activity.getEventId());
            pstmt.setString(6, activity.getStartTime());
            pstmt.setInt(7, activity.getActivityId());
            pstmt.executeUpdate();
            System.out.println("Actividad actualizada exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteActivity(int activityId) {
        String sql = "DELETE FROM Activities WHERE activity_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, activityId);
            pstmt.executeUpdate();
            System.out.println("Actividad eliminada exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
