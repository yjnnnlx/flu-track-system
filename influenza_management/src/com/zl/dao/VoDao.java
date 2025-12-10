package com.zl.dao;

import com.zl.model.Vo;
import com.zl.uitls.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoDao {

    public static Vo test1()
    {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        PreparedStatement preparedStatement1=null;
        ResultSet resultSet1=null;
        ResultSet resultSet2=null;
        try {
            connection= DbUtil.getConnection();
            String sql="select count(*)  from pat";
            String sql1="select count(*)  from clop";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement1=connection.prepareStatement(sql1);
           resultSet1= preparedStatement.executeQuery();
           resultSet2=preparedStatement1.executeQuery();
           Vo vo=new Vo();
          while(resultSet1.next())
          {
             vo.setRi(resultSet1.getString("count(*)"));
          }
          while(resultSet2.next()) {
              vo.setYue(resultSet2.getString("count(*)"));
          }
            return vo;


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
