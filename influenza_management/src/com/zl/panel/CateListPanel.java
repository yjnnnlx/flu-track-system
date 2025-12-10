package com.zl.panel;

import com.zl.dao.CateDao;
import com.zl.dao.IsinoDao;
import com.zl.frame.add.CateAddFrame;
import com.zl.frame.add.IsinoAddFrame;
import com.zl.model.Cate;
import com.zl.model.Isino;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;


public class CateListPanel extends JPanel {

    private JTable jTable;

    public CateListPanel() {

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
            new CateAddFrame(null);
        });

        updateBtn.addActionListener(e -> {
            int selectedRow = jTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a row of data");
            }else {
                Object id = jTable.getModel().getValueAt(selectedRow, 0);
                new CateAddFrame(String.valueOf(id));
            }
        });

        deleteBtn.addActionListener(e -> {
            int selectedRow = jTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a row of data");
            }else {
                Object id = jTable.getModel().getValueAt(selectedRow, 0);
                int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?");
                if (i == 0) {
                    CateDao.delete(String.valueOf(id));
                    reload();
                }
            }
        });

    }

    private void reload() {
        String[] columnName = {"category number", "category name"};
        List<Cate> list = CateDao.list();
        Object[][] rowData = new Object[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            rowData[i][0] = list.get(i).getId();
            rowData[i][1] = list.get(i).getName();
        }
        DefaultTableModel model = new DefaultTableModel(rowData, columnName);
        jTable.setModel(model);
    }

}
