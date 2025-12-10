package com.zl.frame.add;

import com.zl.dao.IsinoDao;
import com.zl.model.Isino;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class IsinoAddFrame extends JFrame {


    public IsinoAddFrame(String id) {

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

        JLabel j2 = new JLabel("collage");
        j2.setBounds(20, 60, 100, 30);
        add(j2);

        JTextField t2 = new JTextField();
        t2.setBounds(80, 60, 200, 30);
        add(t2);

        JLabel j3 = new JLabel("status");
        j3.setBounds(20, 100, 100, 30);
        add(j3);

        JTextField t3 = new JTextField();
        t3.setBounds(80, 100, 200, 30);
        add(t3);

        JLabel j4 = new JLabel("mark");
        j4.setBounds(20, 140, 100, 30);
        add(j4);

        JTextField t4 = new JTextField();
        t4.setBounds(80, 140, 200, 30);
        add(t4);

        if (id != null) {
            Isino isino = IsinoDao.getById(id);
            if (isino!=null){
                t1.setText(isino.getName());
                t2.setText(isino.getIdepnam());
                t3.setText(isino.getIsback());
                t4.setText(isino.getMark());
            }
        }

        JButton button = new JButton("save");
        button.setBounds(80, 300, 100, 30);
        add(button);
        button.addActionListener(e -> {
            Isino isino = new Isino();
            isino.setName(t1.getText());
            isino.setIdepnam(t2.getText());
            isino.setIsback(t3.getText());
            isino.setMark(t4.getText());

            if (id != null) {
                isino.setId(Integer.valueOf(id));
                IsinoDao.update(isino);
            } else{
                IsinoDao.add(isino);
            }
            setVisible(false);
        });
    }
}
