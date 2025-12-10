package com.zl.panel;

import com.zl.dao.ClopDao;
import com.zl.dao.VoDao;
import com.zl.model.Clop;
import com.zl.model.Vo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class StatisticsListPanel extends JPanel {

    private JTable jTable;

    public StatisticsListPanel() {

        JButton addBtn = new JButton("Refresh");
        addBtn.setBounds(0, 0, 100, 30);
        add(addBtn);
        setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setBounds(100, 0, width / 2 - 100, height / 2);

        jTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(jTable);
        scrollPane.setBounds(0, 30, width / 2 - 100, height / 2 - 30);
        add(scrollPane);
        reload();
addBtn.addActionListener(e -> {
    reload();
});
    }

    private void reload() {
        String[] columnName = {"number of confirmed cases", "number of close contacts"};
        ArrayList<Vo> list = new ArrayList<Vo>();
        Vo vo = VoDao.test1();

        list.add(vo);
        Object[][] rowData = new Object[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            rowData[i][0] = list.get(i).getRi();
            rowData[i][1] = list.get(i).getYue();
        }
        DefaultTableModel model = new DefaultTableModel(rowData, columnName);
        jTable.setModel(model);
    }

}
