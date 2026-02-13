package ems.ui;

import ems.dao.AttendeeDAO;
import ems.model.Attendee;

import javax.swing.*;
import java.awt.*;

public class AttendeeForm extends JFrame {
    private JTextField nameField, emailField, eventIdField;
    private JButton saveButton;

    public AttendeeForm() {
        setTitle("Add Attendee");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel eventIdLabel = new JLabel("Event ID:");

        nameField = new JTextField();
        emailField = new JTextField();
        eventIdField = new JTextField();
        saveButton = new JButton("Save Attendee");

        add(nameLabel); add(nameField);
        add(emailLabel); add(emailField);
        add(eventIdLabel); add(eventIdField);
        add(new JLabel()); add(saveButton);

        saveButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            int eventId = Integer.parseInt(eventIdField.getText());

            AttendeeDAO dao = new AttendeeDAO();
            dao.addAttendee(new Attendee(name, email, eventId));

            JOptionPane.showMessageDialog(this, "Attendee Saved Successfully!");
            dispose();
        });
    }
}
