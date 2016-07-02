package com.victoria.mysql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DataBase {
	
	static private Connection connection;
	
	private static final String driver="com.mysql.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/foo";
    
    private static final String username="root";
	private static final String pwd="victoria";
	
	
	public DataBase() { //构造方法，连接指定数据库。
		// TODO Auto-generated constructor stub
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(url,username,pwd);
			System.err.println("build the connection successfully......");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<ArrayList<String>> query(String sql ){//执行数据查询的SELECT语句，参数sql指定一条SELECT语句，执行成功显示结果集中的数据
		
		PreparedStatement preparedStatement;
		
		 try {
    		 preparedStatement=(PreparedStatement)connection.prepareStatement(sql);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 int col = rs.getMetaData().getColumnCount();
    		 ArrayList<ArrayList<String>> re=new ArrayList<>();
    		 while(rs.next()){
    			 ArrayList<String> tmp=new ArrayList<>();
 				for (int i = 1; i <= col; i++) {
 	                tmp.add(rs.getString(i));
 	             }
 				re.add(tmp);
 			}
			 rs.close();
		     preparedStatement.close();	
		     return re;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	 
	}
	
	public int update(String sql){//执行数据更新的SQL语句，包括INSERT、UPDATE、DELETE语句
        //参数sql指定一条数据更新的SQL语句，执行成功返回所影响的行数，否则返回0
		 PreparedStatement preparedStatement;
		 try {
   		 preparedStatement=(PreparedStatement)connection.prepareStatement(sql);
   		 int flag= preparedStatement.executeUpdate();
		 preparedStatement.close();	
		 return flag;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}	 
	}
	
	@Override
	protected void finalize() throws Throwable { //析构方法，关闭数据库连接
		// TODO Auto-generated method stub
		try {
			if(connection!=null)
			connection.close();
			System.out.println("Close the connection successfully......");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public String about()      //获得所连接数据库的属性信息，返回字符串
    {
        String message = "";
        DatabaseMetaData dbmd;
		try {
			dbmd = connection.getMetaData();
			message = "JDBC驱动程序：" + dbmd.getDriverName() +" "+ dbmd.getDriverVersion() + "\r\n" +
	                  "JDBC URL：" + dbmd.getURL() + "\r\n" +
	                  "数据库：" + dbmd.getDatabaseProductName() + "\r\n" +
	                  "数据库版本：" + dbmd.getDatabaseProductVersion() + "\r\n"+
	                  "用户名：" + dbmd.getUserName() + "\r\n";
	        return message;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Something goes wrong";
		}
    }
	
    

}
