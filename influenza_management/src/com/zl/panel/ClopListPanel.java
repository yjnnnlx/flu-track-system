package com.zl.panel;

import com.zl.dao.PatDao;
import com.zl.dao.ClopDao;
import com.zl.frame.add.PatAddFrame;
import com.zl.frame.add.ClopAddFrame;
import com.zl.model.Pat;
import com.zl.model.Clop;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;


public class ClopListPanel extends JPanel {

    private JTable jTable;

    public ClopListPanel() {

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
            new ClopAddFrame(null);
        });

        updateBtn.addActionListener(e -> {
            int selectedRow = jTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a row of data.");
            }else {
                Object id = jTable.getModel().getValueAt(selectedRow, 0);
                new ClopAddFrame(String.valueOf(id));
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
                    ClopDao.delete(String.valueOf(id));
                    reload();
                }
            }
        });

    }

    private void reload() {
        String[] columnName = {"number", "name","location", "start of isolation", "end of isolation"};
        List<Clop> list = ClopDao.list();
        Object[][] rowData = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            rowData[i][0] = list.get(i).getId();
            rowData[i][1] = list.get(i).getName();
            rowData[i][2] = list.get(i).getConadd();
            rowData[i][3] = list.get(i).getSwdat();
            rowData[i][4] = list.get(i).getEwdat();
        }
        DefaultTableModel model = new DefaultTableModel(rowData, columnName);
        jTable.setModel(model);
    }

}
