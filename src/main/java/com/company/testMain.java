package com.company;

import javax.swing.*;

public class testMain {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("JTable Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTable table = createTable();
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }

    public static JTable createTable()
    {
        String[] columnNames = {"First Name", "Last Name"};
        String[][] data = {{"Kathy", "Smith"},{"John", "Doe"}};
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);

        return table;
    }
}
