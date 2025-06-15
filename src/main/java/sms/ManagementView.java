package sms;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ManagementView extends JFrame {

    private JTable table;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField ageField;
    private JTextField startedDateField;
    private JComboBox genderSelectionBox;
    private JComboBox courseSelectionBox;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Translator.getMessagesFromXML();
            try {
                ManagementView window = new ManagementView();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ManagementView() {
        setTitle(Translator.getValue("sms"));
        setBounds(100, 100, 860, 540);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        initComponents();
        updateCourses();
        DBHandler.updateStudents();
    }

    private void initComponents() {
        JPanel tablePanel = new JPanel();
        tablePanel.setBorder(new LineBorder(SystemColor.textHighlight, 5));
        tablePanel.setBounds(260, 10, 575, 395);
        tablePanel.setLayout(null);
        getContentPane().add(tablePanel);

        JScrollPane tableScrollPane = new JScrollPane();
        tableScrollPane.setBounds(10, 10, 555, 375);
        tablePanel.add(tableScrollPane);

        table = new JTable();
        table.setColumnSelectionAllowed(true);
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                Translator.getValue("ID"), Translator.getValue("name"), Translator.getValue("surname"),
                Translator.getValue("age"), Translator.getValue("gender"), Translator.getValue("course"),
                Translator.getValue("started"), Translator.getValue("graduation")
            }) {
            boolean[] columnEditables = new boolean[] { false, true, true, true, true, false, false, false };
