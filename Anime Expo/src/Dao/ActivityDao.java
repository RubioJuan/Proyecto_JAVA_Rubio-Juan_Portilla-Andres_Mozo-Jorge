/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author Andres Portilla 
 */

import connection.MySQLDataSource;
import Model.Activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    private final MySQLDataSource dataSource;

    public ActivityDao() {
        this.dataSource = new MySQLDataSource();
    }

    public boolean addActivity(Activity activity) {
        String query = "INSERT INTO Activities (name, type, category, participant_count, event_id, start_time) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, activity.getName());
            ps.setString(2, activity.getType());
            ps.setString(3, activity.getCategory());
            ps.setInt(4, activity.getParticipantCount());
            ps.setInt(5, activity.getEventId());
            ps.setString(6, activity.getStartTime());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al agregar la actividad: " + e.getMessage());
            return false;
        }
    }

    public List<Activity> getAllActivities() {
        List<Activity> activities = new ArrayList<>();
        String query = "SELECT * FROM Activities";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Activity activity = new Activity();
                activity.setActivityId(rs.getInt("activity_id"));
                activity.setName(rs.getString("name"));
                activity.setType(rs.getString("type"));
                activity.setCategory(rs.getString("category"));
                activity.setParticipantCount(rs.getInt("participant_count"));
                activity.setEventId(rs.getInt("event_id"));
                activity.setStartTime(rs.getString("start_time"));
                activities.add(activity);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener las actividades: " + e.getMessage());
        }
        return activities;
    }

}
