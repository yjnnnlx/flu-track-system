package com.zl.dao;

import com.zl.model.Isino;
import com.zl.model.Pat;
import com.zl.uitls.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PatDao {


    public static List<Pat> list() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pat> list = new ArrayList<>();
        try {
            String sql = "select * from pat";
            System.out.println(sql);
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pat pat = new Pat();
                list.add(pat);
                pat.setId(rs.getInt("id"));
                pat.setName(rs.getString("name"));
                pat.setAddress(rs.getString("address"));
                pat.setMakeTime(rs.getString("make_time"));
                pat.setState(rs.getString("state"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.release(rs, ps, conn);
        }
        return list;
    }



    public static Pat getById(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from pat where id = ?";
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();
            if (rs.next()) {
                Pat pat = new Pat();
                pat.setId(rs.getInt("id"));
                pat.setName(rs.getString("name"));
                pat.setAddress(rs.getString("address"));
                pat.setMakeTime(rs.getString("make_time"));
                pat.setState(rs.getString("state"));
                return pat;
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
            String sql = "delete from pat where id = ?";
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

    public static void add(Pat pat) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String sql = "insert into pat(name, address, make_time, state) values(?, ?, ?, ?)";
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, pat.getName());
            ps.setString(2, pat.getAddress());
            ps.setString(3, pat.getMakeTime());
            ps.setString(4, pat.getState());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Fail to add record: " + e.getMessage(), e);
        }finally {
            DbUtil.release(ps, conn);
        }
    }

    public static void update(Pat pat) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String sql = "update pat set name = ?, address = ?, make_time = ?, state = ? where id = ?";
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, pat.getName());
            ps.setString(2, pat.getAddress());
            ps.setString(3, pat.getMakeTime());
            ps.setString(4, pat.getState());
            ps.setInt(5, pat.getId());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.release(ps, conn);
        }
    }
}
