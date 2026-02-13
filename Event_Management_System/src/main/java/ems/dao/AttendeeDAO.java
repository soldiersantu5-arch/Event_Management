package ems.dao;

import ems.db.DBConnection;
import ems.model.Attendee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AttendeeDAO {

    public void addAttendee(Attendee attendee) {
        String sql = "INSERT INTO attendees (name, email, event_id) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, attendee.getName());
            stmt.setString(2, attendee.getEmail());
            stmt.setInt(3, attendee.getEventId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Attendee> getAttendeesByEvent(int eventId) {
        List<Attendee> attendees = new ArrayList<>();
        String sql = "SELECT * FROM attendees WHERE event_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, eventId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    attendees.add(new Attendee(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getInt("event_id")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return attendees;
    }
}
