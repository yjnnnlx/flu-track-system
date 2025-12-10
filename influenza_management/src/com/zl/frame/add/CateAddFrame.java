package com.zl.frame.add;

import com.zl.dao.CateDao;
import com.zl.dao.IsinoDao;
import com.zl.model.Cate;
import com.zl.model.Isino;

import javax.swing.*;
import java.awt.*;


public class CateAddFrame extends JFrame {


    public CateAddFrame(String id) {

        setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setBounds(width / 2 - 250,height / 2 - 250, 500, 500);
        setVisible(true);

        JLabel j1 = new JLabel("category name");
        j1.setBounds(20, 20, 100, 30);
        add(j1);

        JTextField t1 = new JTextField();
        t1.setBounds(80, 20, 200, 30);
        add(t1);


        if (id != null) {
            Cate cate = CateDao.getById(id);
            if (cate!=null){
                t1.setText(cate.getName());
            }
        }

        JButton button = new JButton("save");
        button.setBounds(80, 60, 100, 30);
        add(button);
        button.addActionListener(e -> {
            Cate cate = new Cate();
            cate.setName(t1.getText());

            if (id != null) {
                cate.setId(Integer.valueOf(id));
                CateDao.update(cate);
            } else{
                CateDao.add(cate);
            }
            setVisible(false);
        });
    }
}
