package com.zl.panel;

import com.zl.dao.IsinoDao;
import com.zl.dao.PatDao;
import com.zl.frame.add.IsinoAddFrame;
import com.zl.frame.add.PatAddFrame;
import com.zl.model.Isino;
import com.zl.model.Pat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;


public class PatListPanel extends JPanel {

    private JTable jTable;

    public PatListPanel() {

        setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setBounds(100, 0, width / 2 - 100, height / 2);

        JButton addBtn = new JButton("Add");
        addBtn.setBounds(0, 0, 100, 30);
        add(addBtn);
        JButton updateBtn = new JButton("Modify");
        updateBtn.setBounds(100, 0, 100, 30);
        add(updateBtn);
        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(200, 0, 100, 30);
        add(deleteBtn);
        JButton reloadBtn = new JButton("Refresh");
        reloadBtn.setBounds(300, 0, 100, 30);
        add(reloadBtn);


        jTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(jTable);
        scrollPane.setBounds(0, 30, width / 2 - 100, height / 2 - 30);
        add(scrollPane);
        reload();

        reloadBtn.addActionListener(e -> {
            reload();
        });

        addBtn.addActionListener(e -> {
            new PatAddFrame(null);
        });

        updateBtn.addActionListener(e -> {
            int selectedRow = jTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a row of data.");
            }else {
                Object id = jTable.getModel().getValueAt(selectedRow, 0);
                new PatAddFrame(String.valueOf(id));
            }
        });

        deleteBtn.addActionListener(e -> {
            int selectedRow = jTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a row of data.");
            }else {
                Object id = jTable.getModel().getValueAt(selectedRow, 0);
                int i = JOptionPane.showConfirmDialog(null, "Whether to delete or not?");
                if (i == 0) {
                    PatDao.delete(String.valueOf(id));
                    reload();
                }
            }
        });

    }

    private void reload() {
        String[] columnName = {"case number", "confirmed name","activity location", "quarantine", "disinfect or not"};
        List<Pat> list = PatDao.list();
        Object[][] rowData = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            rowData[i][0] = list.get(i).getId();
            rowData[i][1] = list.get(i).getName();
            rowData[i][2] = list.get(i).getAddress();
            rowData[i][3] = list.get(i).getMakeTime();
            rowData[i][4] = list.get(i).getState();
        }
        DefaultTableModel model = new DefaultTableModel(rowData, columnName);
        jTable.setModel(model);
    }

}
