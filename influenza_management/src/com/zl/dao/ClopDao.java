package com.zl.dao;

import com.zl.model.Pat;
import com.zl.model.Clop;
import com.zl.uitls.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ClopDao {


    public static List<Clop> list() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Clop> list = new ArrayList<>();
        try {
            String sql = "select * from clop";
            System.out.println(sql);
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Clop clop = new Clop();
                clop.setId(rs.getInt("id"));
                clop.setName(rs.getString("name"));
                clop.setConadd(rs.getString("conadd"));
                clop.setSwdat(rs.getString("swdat"));
                clop.setEwdat(rs.getString("ewdat"));
                list.add(clop);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.release(rs, ps, conn);
        }
        return list;
    }



    public static Clop getById(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from clop where id = ?";
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();
            if (rs.next()) {
                Clop clop = new Clop();
                clop.setId(rs.getInt("id"));
                clop.setName(rs.getString("name"));
                clop.setConadd(rs.getString("conadd"));
                clop.setSwdat(rs.getString("swdat"));
                clop.setEwdat(rs.getString("ewdat"));
                return clop;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.release(rs, ps, conn);
        }
        return null;
    }


    public static void delete(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String sql = "delete from clop where id = ?";
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.release(ps, conn);
        }
    }

    public static void add(Clop clop) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String sql = "insert into clop(name, conadd, swdat, ewdat) values(?, ?, ?, ?)";
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, clop.getName());
            ps.setString(2, clop.getConadd());
            ps.setString(3, clop.getSwdat());
            ps.setString(4, clop.getEwdat());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.release(ps, conn);
        }
    }

    public static void update(Clop clop) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String sql = "update clop set name = ?, conadd = ?, swdat = ?, ewdat = ? where id = ?";
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, clop.getName());
            ps.setString(2, clop.getConadd());
            ps.setString(3, clop.getSwdat());
            ps.setString(4, clop.getEwdat());
            ps.setInt(5, clop.getId());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.release(ps, conn);
        }
    }
}
