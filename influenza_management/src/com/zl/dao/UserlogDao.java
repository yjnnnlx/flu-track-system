package com.zl.dao;

import com.zl.model.Userlog;
import com.zl.uitls.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserlogDao {

    public static Userlog login(String acc, String pwd) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = String.format("select * from users where acc = '%s' and pwd = '%s'", acc, pwd);
            System.out.println(sql);
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Userlog userlog = new Userlog();
                userlog.setId(rs.getInt("id"));
                userlog.setPwd(rs.getString("pwd"));
                userlog.setAcc(rs.getString("acc"));
                return userlog;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.release(rs, ps, conn);
        }
        return null;
    }
}
