package com.zl.dao;

import com.zl.model.Isino;
import com.zl.model.Nat;
import com.zl.uitls.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class NatDao {


    public static List<Nat> list() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Nat> list = new ArrayList<>();
        try {
            String sql = "select * from nat";
            System.out.println(sql);
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Nat nat = new Nat();
                list.add(nat);
                nat.setId(rs.getInt("id"));
                nat.setName(rs.getString("name"));
                nat.setNdepnam(rs.getString("ndepnam"));
                nat.setTime(rs.getString("Time"));
                nat.setRes(rs.getString("res"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.release(rs, ps, conn);
        }
        return list;
    }



    public static Nat getById(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from nat where id = ?";
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();
            if (rs.next()) {
                Nat nat = new Nat();
                nat.setId(rs.getInt("id"));
                nat.setName(rs.getString("name"));
                nat.setNdepnam(rs.getString("ndepnam"));
                nat.setRes(rs.getString("res"));
                nat.setTime(rs.getString("Time"));
                return nat;
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
            String sql = "delete from nat where id = ?";
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

    public static void add(Nat nat) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String sql = "insert into nat(name, ndepnam, res, Time) values(?, ?, ?, ?)";
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nat.getName());
            ps.setString(2, nat.getNdepnam());
            ps.setString(3, nat.getRes());
            ps.setString(4, nat.getTime());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Fail to add record: " + e.getMessage(), e);
        }finally {
            DbUtil.release(ps, conn);
        }
    }

    public static void update(Nat nat) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String sql = "update nat set name = ?, ndepnam = ?, res = ?, Time = ? where id = ?";
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nat.getName());
            ps.setString(2, nat.getNdepnam());
            ps.setString(3, nat.getRes());
            ps.setString(4, nat.getTime());
            ps.setInt(5, nat.getId());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.release(ps, conn);
        }
    }
}
