package com.zl.dao;

import com.zl.model.Isino;
import com.zl.uitls.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class IsinoDao {


    public static List<Isino> list() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Isino> list = new ArrayList<>();
        try {
            String sql = "select * from isino";
            System.out.println(sql);
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
            	Isino isino = new Isino();
                list.add(isino);
                isino.setId(rs.getInt("id"));
                isino.setName(rs.getString("name"));
                isino.setIdepnam(rs.getString("idepnam"));
                isino.setIsback(rs.getString("status"));
                isino.setMark(rs.getString("mark"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.release(rs, ps, conn);
        }
        return list;
    }



    public static Isino getById(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = String.format("select * from isino where id = %s", id);
            System.out.println(sql);
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
            	Isino isino = new Isino();
            	isino.setId(rs.getInt("id"));
            	isino.setName(rs.getString("name"));
            	isino.setIdepnam(rs.getString("idepnam"));
            	isino.setIsback(rs.getString("isback"));
            	isino.setMark(rs.getString("mark"));
                return isino;
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
            String sql = String.format("delete from isino where id = %s", id);
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.release(ps, conn);
        }
    }

    public static void add(Isino isino) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Object[] param = {
                    "'" + isino.getName() + "'",
                    "'" + isino.getIdepnam() + "'",
                    "'" + isino.getIsback() + "'",
                    "'" + isino.getMark() + "'",
            };
            String sql = String.format("insert into isino(name, idepnam,status, mark) values(%s, %s, %s, %s)", param);
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.release(ps, conn);
        }
    }

    public static void update(Isino isino) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Object[] param = {
                    "'" + isino.getName() + "'",
                    "'" + isino.getIdepnam() + "'",
                    "'" + isino.getIsback() + "'",
                    "'" + isino.getMark() + "'",
                    isino.getId()
            };
            String sql = String.format("update isino set name = %s, idepnam = %s, status = %s, mark = %s  where id = %d", param);
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.release(ps, conn);
        }
    }
}
