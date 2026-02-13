package ems.ui;

import ems.dao.EventDAO;
import ems.model.Event;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainDashboard extends JFrame {
    private JButton addEventBtn, addAttendeeBtn, viewEventsBtn;

    public MainDashboard() {
        setTitle("Event Management System");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        addEventBtn = new JButton("Add Event");
        addAttendeeBtn = new JButton("Add Attendee");
        viewEventsBtn = new JButton("View Events");

        add(addEventBtn);
        add(addAttendeeBtn);
        add(viewEventsBtn);

        addEventBtn.addActionListener(e -> new EventForm().setVisible(true));
        addAttendeeBtn.addActionListener(e -> new AttendeeForm().setVisible(true));

        viewEventsBtn.addActionListener(e -> {
            EventDAO dao = new EventDAO();
            List<Event> events = dao.getAllEvents();

            StringBuilder sb = new StringBuilder("Events:\n");
            for (Event event : events) {
                sb.append(event.getId())
                        .append(" - ")
                        .append(event.getName())
                        .append(" on ")
                        .append(event.getDate())
                        .append(" at ")
                        .append(event.getLocation())
                        .append("\n");
            }

            JOptionPane.showMessageDialog(this, sb.toString());
        });
    }
}
