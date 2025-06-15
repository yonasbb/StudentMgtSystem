package sms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class ManagementView {
    static JFrame managementFrame;

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
        managementFrame.setBounds(100, 100, 450, 300);
        managementFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        managementFrame.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Student Management System");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitle.setBounds(90, 10, 300, 30);
        managementFrame.getContentPane().add(lblTitle);

        JButton btnAdd = new JButton("Add Student");
        btnAdd.setBounds(50, 70, 150, 30);
        managementFrame.getContentPane().add(btnAdd);

        JButton btnView = new JButton("View Students");
        btnView.setBounds(220, 70, 150, 30);
        managementFrame.getContentPane().add(btnView);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(140, 120, 150, 30);
        btnExit.addActionListener(e -> System.exit(0));
        managementFrame.getContentPane().add(btnExit);
    }
} 
