package sms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The class that holds the front-end connection part of the application and
 * manages the actions performed out there
 */
public class ConnectionView extends JFrame {

    private JTextField loginField;
    private JPasswordField passwordField;
    private JTextField databaseUrlField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Translator.setLanguage(Language.ENG);
            Translator.getMessagesFromXML();
            try {
                ConnectionView window = new ConnectionView();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public ConnectionView() {
        initialize();
        setVisible(true); // for testing
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        setBounds(100, 100, 640, 480);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(Translator.getValue("sms"));

        JPanel topPanel = new JPanel();
        topPanel.setBackground(SystemColor.textHighlight);
        getContentPane().add(topPanel, BorderLayout.NORTH);

        JLabel connectText = new JLabel(Translator.getValue("connectText"));
        connectText.setForeground(Color.WHITE);
        connectText.setFont(new Font("Tahoma", Font.PLAIN, 25));
        topPanel.add(connectText);

        JPanel bottomPanel = new JPanel();
        getContentPane().add(bottomPanel, BorderLayout.CENTER);
        bottomPanel.setLayout(null);

        JLabel loginText = new JLabel(Translator.getValue("loginText"));
        loginText.setBounds(68, 134, 162, 25);
        loginText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        bottomPanel.add(loginText);

        JLabel passwordText = new JLabel(Translator.getValue("passwordText"));
        passwordText.setBounds(68, 174, 162, 25);
        passwordText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        bottomPanel.add(passwordText);

        loginField = new JTextField();
        loginField.setName("loginField");
        loginField.setBounds(240, 139, 330, 20);
        loginField.setColumns(10);
        bottomPanel.add(loginField);

        passwordField = new JPasswordField();
        passwordField.setName("passwordField");
        passwordField.setBounds(240, 179, 330, 20);
        bottomPanel.add(passwordField);

        databaseUrlField = new JTextField();
        databaseUrlField.setName("databaseUrlField");
        databaseUrlField.setText("jdbc:mysql://localhost:3306/studentsdb");
        databaseUrlField.setColumns(10);
        databaseUrlField.setBounds(240, 96, 330, 20);
        bottomPanel.add(databaseUrlField);

        JLabel databaseUrlText = new JLabel(Translator.getValue("databaseUrlText"));
        databaseUrlText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        databaseUrlText.setBounds(68, 91, 162, 25);
        bottomPanel.add(databaseUrlText);

        JButton changeLanguageButton = new JButton(Translator.getValue("changeLanguage"));
        changeLanguageButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        changeLanguageButton.setBounds(480, 365, 135, 25);
        bottomPanel.add(changeLanguageButton);

        changeLanguageButton.addActionListener(e -> {
            Language selectedLanguage = (Language) JOptionPane.showInputDialog(
                    null,
                    Translator.getValue("sms"),
                    Translator.getValue("selectLanguage"),
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    Language.values(),
                    Language.ENG.toString());

            if (selectedLanguage != null) {
                Translator.setLanguage(selectedLanguage);
                Translator.getMessagesFromXML();
                dispose();
                new ConnectionView();
            }
        });

        JButton connectButton = new JButton(Translator.getValue("connectButton"));
        connectButton.setName("connectButton");
        connectButton.setBounds(221, 290, 190, 42);
        connectButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bottomPanel.add(connectButton);

        connectButton.addActionListener(e -> {
            if (loginField.getText().isEmpty() || databaseUrlField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        Translator.getValue("fillEmptyFields"),
                        Translator.getValue("error"),
                        JOptionPane.ERROR_MESSAGE);
            } else {
                DBHandler.setLogin(loginField.getText());
                DBHandler.setPassword(new String(passwordField.getPassword()));
                DBHandler.setDatabaseUrl(databaseUrlField.getText());

                if (DBHandler.createTables()) {
                    JOptionPane.showMessageDialog(this,
                            Translator.getValue("connectionEstablished"),
                            Translator.getValue("success"),
                            JOptionPane.INFORMATION_MESSAGE);
                    ManagementView.main(null);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this,
                            Translator.getValue("connectionNotEstablished"),
                            Translator.getValue("error"),
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
