package com.zl.frame;

import com.zl.panel.*;

import javax.swing.*;
import java.awt.*;


public class UserlogFrame extends JFrame {
    public UserlogFrame() {
        setLayout(null);

        Font smallFont = new Font("Arial", Font.PLAIN, 11);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenH = screenSize.height;
        int screenW = screenSize.width;
        
        int frameW = screenW * 2 / 3;
        int frameH = screenH * 2 / 3;
        int frameX = (screenW - frameW) / 2;
        int frameY = (screenH - frameH) / 2;
        setBounds(frameX, frameY, frameW, frameH);

        
        int btnX = 10;
        int btnWidth = 140;
        int btnHeight = 28;
        int btnGap = 6;

        JButton but1 = new JButton("Vaccination Status");
        but1.setFont(smallFont);
        but1.setBounds(btnX, 10, btnWidth, btnHeight);
        add(but1);
/*
        JButton but2 = new JButton("类别管理");
        but2.setBounds(0, 30, 100, 30);
        add(but2);

 */

        JButton but3 = new JButton("Influenza Detection");
        but3.setFont(smallFont);
        but3.setBounds(btnX, 10 + (btnHeight + btnGap) * 1, btnWidth, btnHeight);
        add(but3);

        JButton but4 = new JButton("Confirmed Cases");
        but4.setFont(smallFont);
        but4.setBounds(btnX, 10 + (btnHeight + btnGap) * 2, btnWidth, btnHeight);
        add(but4);

        JButton but5 = new JButton("Close contacts");
        but5.setFont(smallFont);
        but5.setBounds(btnX, 10 + (btnHeight + btnGap) * 3, btnWidth, btnHeight);
        add(but5);

        JButton but6 = new JButton(" Statistical total ");
        but6.setFont(smallFont);
        but6.setBounds(btnX, 10 + (btnHeight + btnGap) * 4, btnWidth, btnHeight);
        add(but6);

        //界面
        IsinoListPanel empListPanel = new IsinoListPanel();
        add(empListPanel);

        CateListPanel cateListPanel = new CateListPanel();
        add(cateListPanel);

        NatListPanel houseListPanel = new NatListPanel();
        add(houseListPanel);

        PatListPanel makeListPanel = new PatListPanel();
        add(makeListPanel);

        ClopListPanel rentListPanel = new ClopListPanel();
        add(rentListPanel);

        StatisticsListPanel statisticsListPanel = new StatisticsListPanel();
        add(statisticsListPanel);

        

        applyFontRecursively(empListPanel, smallFont);
        applyFontRecursively(cateListPanel, smallFont);
        applyFontRecursively(houseListPanel, smallFont);
        applyFontRecursively(makeListPanel, smallFont);
        applyFontRecursively(rentListPanel, smallFont);
        applyFontRecursively(statisticsListPanel, smallFont);

        int contentX = btnX + btnWidth + 10;
        int contentWidth = frameW - contentX - 20;
        int contentHeight = frameH - 60;

        empListPanel.setBounds(contentX, 10, contentWidth, contentHeight);
        cateListPanel.setBounds(contentX, 10, contentWidth, contentHeight);
        houseListPanel.setBounds(contentX, 10, contentWidth, contentHeight);
        makeListPanel.setBounds(contentX, 10, contentWidth, contentHeight);
        rentListPanel.setBounds(contentX, 10, contentWidth, contentHeight);
        statisticsListPanel.setBounds(contentX, 10, contentWidth, contentHeight);

      
        empListPanel.setVisible(true);
        cateListPanel.setVisible(false);
        houseListPanel.setVisible(false);
        makeListPanel.setVisible(false);
        rentListPanel.setVisible(false);
        statisticsListPanel.setVisible(false);

        
        setVisible(true);

        but1.addActionListener(e -> {
            empListPanel.setVisible(true);
            cateListPanel.setVisible(false);
            houseListPanel.setVisible(false);
            statisticsListPanel.setVisible(false);
            makeListPanel.setVisible(false);
            rentListPanel.setVisible(false);
        });
/*
        but2.addActionListener(e -> {
            empListPanel.setVisible(false);
            cateListPanel.setVisible(true);
            houseListPanel.setVisible(false);
            makeListPanel.setVisible(false);
            statisticsListPanel.setVisible(false);
            rentListPanel.setVisible(false);
        });

 */

        but3.addActionListener(e -> {
            empListPanel.setVisible(false);
            cateListPanel.setVisible(false);
            houseListPanel.setVisible(true);
            makeListPanel.setVisible(false);
            rentListPanel.setVisible(false);
            statisticsListPanel.setVisible(false);
        });

        but4.addActionListener(e -> {
            empListPanel.setVisible(false);
            cateListPanel.setVisible(false);
            houseListPanel.setVisible(false);
            makeListPanel.setVisible(true);
            statisticsListPanel.setVisible(false);
            rentListPanel.setVisible(false);
        });

        but5.addActionListener(e -> {
            empListPanel.setVisible(false);
            cateListPanel.setVisible(false);
            houseListPanel.setVisible(false);
            makeListPanel.setVisible(false);
            rentListPanel.setVisible(true);
            statisticsListPanel.setVisible(false);
        });

        but6.addActionListener(e -> {
            empListPanel.setVisible(false);
            cateListPanel.setVisible(false);
            houseListPanel.setVisible(false);
            makeListPanel.setVisible(false);
            rentListPanel.setVisible(false);
            statisticsListPanel.setVisible(true);
        });
    }

    private void applyFontRecursively(Component c, Font f) {
        if (c == null || f == null) return;
        try {
            c.setFont(f);
        } catch (Exception ignore) {
        }
        if (c instanceof javax.swing.JTable) {
            javax.swing.JTable table = (javax.swing.JTable) c;
            int rowHeight = Math.max(16, f.getSize() + 6);
            table.setRowHeight(rowHeight);
            javax.swing.table.JTableHeader header = table.getTableHeader();
            if (header != null) header.setFont(f.deriveFont(Font.BOLD));
        }
        if (c instanceof Container) {
            for (Component child : ((Container) c).getComponents()) {
                applyFontRecursively(child, f);
            }
        }
    }
}
