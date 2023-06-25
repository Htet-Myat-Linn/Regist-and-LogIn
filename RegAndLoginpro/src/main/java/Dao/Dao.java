package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;
import Dto.ReqDto;
import Dto.RespDto;



public class Dao {
	public static Connection con=null;
	static
	{
		con=MyConnection.getConnection();
	}
	
	
	public int insertData(ReqDto dto)
	{
		int Result=0;
		String sql="Insert into user(user_id,user_name,user_password) values (?,?,?)";
		
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,dto.getId());
			ps.setString(2,dto.getUserName());
			ps.setString(3,dto.getPassWord());
			
			Result=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return Result;
	}
	
	public boolean isValidUser(String username, String password) {
		  boolean isValid ;
        try {
          
            String sql = "SELECT * FROM user WHERE user_name = ? AND user_password = ?";
            PreparedStatement statement =  (PreparedStatement) con.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            
            // Execute the query
            ResultSet resultSet = statement.executeQuery();
            
            // Check if a matching user was found
            	isValid = resultSet.next();
            
            // Close the resources
            resultSet.close();
            statement.close();
            
            return isValid;
           
        } 
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
 
    }
	public ArrayList<RespDto> SelectAll()
	{    ArrayList<RespDto> list=new ArrayList<RespDto>();
		
		String sql="Select * from user";
		
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				RespDto re=new RespDto();
				re.setId(rs.getString("user_id"));
				re.setUserName(rs.getString("user_name"));
				re.setPassWord(rs.getString("user_password"));
				
				list.add(re);
				
			}
		} catch (SQLException e) {
			System.out.println("Select All Data Base Error!");
		}
		return list;
	}
	public RespDto SelectOne(ReqDto req)
	{
		RespDto rep=new RespDto();
		String sql="Select * from user where user_id=?";
		
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,req.getId());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				rep.setId(rs.getString("user_id"));
				rep.setUserName(rs.getString("user_name"));
				rep.setPassWord(rs.getString("user_password"));
				
			}
		} catch (SQLException e) {
			System.out.println("Select one Data Base Error!");
		}
		return rep;
	}
	public int DeleteData(ReqDto dto)
	{
		int Result=0;
		String sql="Delete from user where user_id=?";
		
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,dto.getId());
			Result=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Delete Data Base Error!");
		}
		return Result;
	}
	public int UpdateData(ReqDto dto)
	{
		int Result=0;
		String sql="Update user set user_name=?,user_password=? where user_id=?";
		
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,dto.getUserName());
			ps.setString(2, dto.getPassWord());
			ps.setString(3,dto.getId());
			Result=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Update Data Base Error!");
		}
		return Result;
	}
	
}
