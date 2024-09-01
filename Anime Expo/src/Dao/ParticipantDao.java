package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Participant;
import connection.MySQLDataSource;

public class ParticipantDao {
    private MySQLDataSource conexion = new MySQLDataSource();

    public boolean InsertParticipant(Participant participant) {
        String sql = "INSERT INTO Participants(name, activity_id) VALUES(?, ?)";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {

            stms.setString(1, participant.getName());
            stms.setInt(2, participant.getActivity_id());

            int rowsAffected = stms.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Participant ViewParticipantID(int id) {
        String sql = "SELECT * FROM Participants WHERE participant_id = ?";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {

            stms.setInt(1, id);
            ResultSet rs = stms.executeQuery();

            if (rs.next()) {
                return new Participant(rs.getInt("participant_id"), rs.getString("name"), rs.getInt("activity_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Participant> ViewParticipant() {
        List<Participant> participants = new ArrayList<>();
        String sql = "SELECT * FROM Participants"; // Cambiado de "Event" a "Participants"

        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int participant_id = rs.getInt("participant_id");
                String name = rs.getString("name"); // Corregido el nombre del campo
                int activity_id = rs.getInt("activity_id");

                Participant participant = new Participant(participant_id, name, activity_id);
                participants.add(participant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participants;
    }
}
