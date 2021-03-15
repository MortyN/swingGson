package com.company.gui;


import com.company.logic.DeserializeNameList;
import com.company.logic.DeserializeObj;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;


import static com.company.logic.DeserializeObj.getNamelist;

public class fPage extends JFrame {
    private JPanel panel1;
    private JTable table1;
    private JButton button1;
    private JTextPane textPane1;
    List<DeserializeNameList> nameDez;
    DefaultTableModel model = (DefaultTableModel) table1.getModel();


    public void refreshTable() {
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


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                model.setColumnCount(0);
                model.setRowCount(0);
                refreshTable();
            }
        });


        table1.setVisible(true);


    }


}
