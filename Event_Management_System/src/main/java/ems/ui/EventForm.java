package ems.ui;

import ems.dao.EventDAO;
import ems.model.Event;

import javax.swing.*;
import java.awt.*;

public class EventForm extends JFrame {
    private JTextField nameField, dateField, locationField;
    private JButton saveButton;

    public EventForm() {
        setTitle("Add Event");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel nameLabel = new JLabel("Event Name:");
        JLabel dateLabel = new JLabel("Event Date (YYYY-MM-DD):");
        JLabel locationLabel = new JLabel("Location:");

        nameField = new JTextField();
        dateField = new JTextField();
        locationField = new JTextField();
        saveButton = new JButton("Save Event");

        add(nameLabel); add(nameField);
        add(dateLabel); add(dateField);
        add(locationLabel); add(locationField);
        add(new JLabel()); add(saveButton);

        saveButton.addActionListener(e -> {
            String name = nameField.getText();
            String date = dateField.getText();
            String location = locationField.getText();

            EventDAO dao = new EventDAO();
            dao.addEvent(new Event(name, date, location));

            JOptionPane.showMessageDialog(this, "Event Saved Successfully!");
            dispose();
        });
    }
}
