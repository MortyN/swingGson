package com.company.gui;


import com.company.logic.DeserializeNameList;
import com.company.logic.DeserializeObj;
import com.google.gson.Gson;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;


import static com.company.logic.DeserializeObj.getNamelist;
import static com.company.logic.DeserializeObj.setNamelist;

public class fPage extends JFrame {
    private JPanel panel1;
    private JTable table1;
    private JButton button1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton addButton;
    private JLabel Firstname;
    private JLabel Lastname;
    List<DeserializeNameList> nameDez;
    DefaultTableModel model = (DefaultTableModel) table1.getModel();


    public void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setColumnCount(0);
        model.setRowCount(0);

        nameDez = getNamelist("nameObjList.json");
        model.fireTableDataChanged();

        int arrlength = nameDez.toArray().length;

        String[] columnNames = {"FirstName", "LastName"};
        for (String datas : columnNames) {

            model.addColumn(datas);
        }

        for (int i = 0; i < arrlength; i++) {
            Vector<String> row = new Vector<>();
            row.add(nameDez.get(i).getFirstname());
            row.add(nameDez.get(i).getLastname());
            model.addRow(row);
        }

        System.out.println("Refreshed Table");
    }

    public fPage() {

        add(panel1);

        setTitle("Tittelform");
        refreshTable();


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String firstname = textField1.getText();
                String lastname = textField2.getText();
                System.out.printf("firstname: %s Lastname: %s", firstname,lastname);
                nameDez.add(new DeserializeNameList(firstname,lastname));
                try {
                    setNamelist(nameDez);
                    refreshTable();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                refreshTable();
            }
        });


        table1.setVisible(true);


    }


}
