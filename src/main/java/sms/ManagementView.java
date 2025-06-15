package sms;

import javax.swing.*;
import java.awt.*;

public class ManagementView {
    // Declare fields as instance variables so they can be accessed elsewhere if needed
    private JFrame managementFrame;
    private JLabel lblTitle;
    private JButton btnAdd;
    private JButton btnView;
    private JButton btnExit;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ManagementView window = new ManagementView();
                window.managementFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ManagementView() {
        initialize();
        managementFrame.setVisible(true);
    }

    private void initialize() {
        managementFrame = new JFrame();
        managementFrame.setTitle("Student Management System");
        managementFrame.setBounds(100, 100, 450, 300);
        managementFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        managementFrame.getContentPane().setLayout(null);

        lblTitle = new JLabel("Student Management System");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitle.setBounds(90, 10, 300, 30);
        managementFrame.getContentPane().add(lblTitle);

        btnAdd = new JButton("Add Student");
        btnAdd.setBounds(50, 70, 150, 30);
        managementFrame.getContentPane().add(btnAdd);

        btnView = new JButton("View Students");
        btnView.setBounds(220, 70, 150, 30);
        managementFrame.getContentPane().add(btnView);

        btnExit = new JButton("Exit");
        btnExit.setBounds(140, 120, 150, 30);
        btnExit.addActionListener(e -> System.exit(0));
        managementFrame.getContentPane().add(btnExit);
    }

    // Optional: getter methods for buttons if you want to add action listeners outside
    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnView() {
        return btnView;
    }

    public JButton getBtnExit() {
        return btnExit;
    }
}
