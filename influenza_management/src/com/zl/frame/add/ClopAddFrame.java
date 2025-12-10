package com.zl.frame.add;

import com.zl.dao.PatDao;
import com.zl.dao.ClopDao;
import com.zl.model.Pat;
import com.zl.model.Clop;

import javax.swing.*;
import java.awt.*;


public class ClopAddFrame extends JFrame {


    public ClopAddFrame(String id) {

        setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setBounds(width / 2 - 250,height / 2 - 250, 500, 500);
        setVisible(true);

        JLabel j1 = new JLabel("name");
        j1.setBounds(20, 20, 100, 30);
        add(j1);

        JTextField t1 = new JTextField();
        t1.setBounds(80, 20, 200, 30);
        add(t1);

        JLabel j2 = new JLabel("location");
        j2.setBounds(20, 60, 100, 30);
        add(j2);

        JTextField t2 = new JTextField();
        t2.setBounds(80, 60, 200, 30);
        add(t2);

        JLabel j3 = new JLabel("start time");
        j3.setBounds(20, 100, 100, 30);
        add(j3);

        JTextField t3 = new JTextField();
        t3.setBounds(80, 100, 200, 30);
        add(t3);

        JLabel j4 = new JLabel("end time");
        j4.setBounds(20, 140, 100, 30);
        add(j4);

        JTextField t4 = new JTextField();
        t4.setBounds(80, 140, 200, 30);
        add(t4);

        if (id != null) {
            Clop clop = ClopDao.getById(id);
            if (clop!=null){
                t1.setText(clop.getName());
                t2.setText(clop.getConadd());
                t3.setText(clop.getSwdat());
                t4.setText(clop.getEwdat());
            }
        }

        JButton button = new JButton("save");
        button.setBounds(80, 300, 100, 30);
        add(button);
        button.addActionListener(e -> {
            Clop clop = new Clop();
            clop.setName(t1.getText());
            clop.setConadd(t2.getText());
            clop.setSwdat(t3.getText());
            clop.setEwdat(t4.getText());

            if (id != null) {
                clop.setId(Integer.valueOf(id));
                ClopDao.update(clop);
            } else{
                ClopDao.add(clop);
            }
            setVisible(false);
        });
    }
}
