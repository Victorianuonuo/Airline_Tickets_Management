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
	
	
	public DataBase() { //���췽��������ָ�����ݿ⡣
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
	
	
	public ArrayList<ArrayList<String>> query(String sql ){//ִ�����ݲ�ѯ��SELECT��䣬����sqlָ��һ��SELECT��䣬ִ�гɹ���ʾ������е�����
		
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
	
	public int update(String sql){//ִ�����ݸ��µ�SQL��䣬����INSERT��UPDATE��DELETE���
        //����sqlָ��һ�����ݸ��µ�SQL��䣬ִ�гɹ�������Ӱ������������򷵻�0
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
	protected void finalize() throws Throwable { //�����������ر����ݿ�����
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
	
    public String about()      //������������ݿ��������Ϣ�������ַ���
    {
        String message = "";
        DatabaseMetaData dbmd;
		try {
			dbmd = connection.getMetaData();
			message = "JDBC��������" + dbmd.getDriverName() +" "+ dbmd.getDriverVersion() + "\r\n" +
	                  "JDBC URL��" + dbmd.getURL() + "\r\n" +
	                  "���ݿ⣺" + dbmd.getDatabaseProductName() + "\r\n" +
	                  "���ݿ�汾��" + dbmd.getDatabaseProductVersion() + "\r\n"+
	                  "�û�����" + dbmd.getUserName() + "\r\n";
	        return message;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Something goes wrong";
		}
    }
	
    

}
