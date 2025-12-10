package com.zl.uitls;


import java.sql.*;

public class DbUtil {
	  
    private static final String DRIVER_NAME="com.mysql.cj.jdbc.Driver";
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/campus_covid_system?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private static final String JDBC_USERNAME="root";
    private static final String JDBC_PASSWORD="QZZDMS666njy";

    public static Connection getConnection() throws ClassNotFoundException,SQLException
    {
    	Class.forName(DRIVER_NAME);
        return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
    }
    
    
    public static void release(PreparedStatement pstmt,Connection conn)
    {
    	release(null,pstmt,conn);
    }
    
    public static void release(ResultSet rs,PreparedStatement pstmt,Connection conn)
    {
    	try 
    	{
    		if(rs !=null)
    		{
    			rs.close();
    		}
    		if(pstmt !=null)
    		{
    			pstmt.close();
    		}
    		if(conn !=null)
    		{
    			conn.close();
    		}
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
    
}

