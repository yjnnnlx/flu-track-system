package com.zl.dao;

import com.zl.uitls.DbUtil;
import com.zl.model.Cate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CateDao {

    public static List<Cate> list() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Cate> list = new ArrayList<>();
        try {
            String sql = "select * from cate";
            System.out.println(sql);
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cate cate = new Cate();
                list.add(cate);
                cate.setId(rs.getInt("id"));
                cate.setName(rs.getString("name"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.release(rs, ps, conn);
        }
        return list;
    }



    public static Cate getById(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = String.format("select * from cate where id = %s", id);
            System.out.println(sql);
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Cate cate = new Cate();
                cate.setId(rs.getInt("id"));
                cate.setName(rs.getString("name"));
                return cate;
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
            String sql = String.format("delete from cate where id = %s", id);
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.release(ps, conn);
        }
    }

    public static void add(Cate cate) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Object[] param = {
                    "'" + cate.getName() + "'"
            };
            String sql = String.format("insert into cate(name) values(%s)", param);
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.release(ps, conn);
        }
    }

    public static void update(Cate cate) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Object[] param = {
                    "'" + cate.getName() + "'",
                    cate.getId()
            };
            String sql = String.format("update cate set name = %s where id = %d", param);
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
