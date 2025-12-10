package com.zl.frame.add;

import com.zl.dao.IsinoDao;
import com.zl.dao.PatDao;
import com.zl.model.Isino;
import com.zl.model.Pat;

import javax.swing.*;
import java.awt.*;


public class PatAddFrame extends JFrame {


    public PatAddFrame(String id) {

        setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setBounds(width / 2 - 250,height / 2 - 250, 500, 500);
        setVisible(true);

        JLabel j1 = new JLabel("confirmed name");
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

        JLabel j3 = new JLabel("quarantine");
        j3.setBounds(20, 100, 100, 30);
        add(j3);

        JTextField t3 = new JTextField();
        t3.setBounds(80, 100, 200, 30);
        add(t3);

        JLabel j4 = new JLabel("disinfect or not");
        j4.setBounds(20, 140, 100, 30);
        add(j4);

        JTextField t4 = new JTextField();
        t4.setBounds(80, 140, 200, 30);
        add(t4);

        if (id != null) {
            Pat pat = PatDao.getById(id);
            if (pat!=null){
                t1.setText(pat.getName());
                t2.setText(pat.getAddress());
                t3.setText(pat.getMakeTime());
                t4.setText(pat.getState());
            }
        }

        JButton button = new JButton("save");
        button.setBounds(80, 300, 100, 30);
        add(button);
        button.addActionListener(e -> {
            Pat pat = new Pat();
            pat.setName(t1.getText());
            pat.setAddress(t2.getText());
            pat.setMakeTime(t3.getText());
            pat.setState(t4.getText());

            if (id != null) {
                pat.setId(Integer.valueOf(id));
                PatDao.update(pat);
            } else{
                PatDao.add(pat);
            }
            setVisible(false);
        });
    }
}
