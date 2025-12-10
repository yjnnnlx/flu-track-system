package com.zl.frame.add;

import com.zl.dao.CateDao;
import com.zl.dao.NatDao;
import com.zl.model.Cate;
import com.zl.model.Nat;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class NatAddFrame extends JFrame {


    public NatAddFrame(String id) {

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

        JLabel j3 = new JLabel("test time");
        j3.setBounds(20, 100, 100, 30);
        add(j3);
        JTextField t3=new JTextField();
        t3.setBounds(80,100,200,30);
        add(t3);



        JLabel j4 = new JLabel("result");
        j4.setBounds(20, 140, 100, 30);
        add(j4);

        JTextField t4 = new JTextField();
        t4.setBounds(80, 140, 200, 30);
        add(t4);




        if (id != null) {
            Nat nat = NatDao.getById(id);
            if (nat!=null){
                t1.setText(nat.getName());
                t2.setText(nat.getNdepnam());
                  t3.setText(nat.getTime());
                t4.setText(nat.getRes());
            }
        }

        JButton button = new JButton("save");
        button.setBounds(80, 300, 100, 30);
        add(button);
        button.addActionListener(e -> {
            Nat nat = new Nat();
            nat.setName(t1.getText());
            nat.setNdepnam(t2.getText());
           nat.setTime(t3.getText());
            nat.setRes(t4.getText());
           // String t3Value = (String) t3.getSelectedItem();
            /*
            if (t3Value!=null){
                String cid= t3Value.split(",")[0];
                nat.setCid(Integer.parseInt(cid));
            }

             */

            if (id != null) {
                nat.setId(Integer.valueOf(id));
                NatDao.update(nat);
            } else{
                NatDao.add(nat);
            }
            setVisible(false);
        });
    }
}
