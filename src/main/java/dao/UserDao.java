package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entities.User;

public class UserDao {
	
	private Connection con;

	public UserDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean UserRegister(User u)	{
		boolean f=false;
		
		try {
			String sql="insert into user (name,email,password) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			
			int i=ps.executeUpdate();
			if(i>0) {
				f=true;
				
				System.out.println("Register done");
			}
			else {
				System.out.println("something went wrong");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public User Login(String email, String password){
		User u2=null;
		try {
			String sql="select * from user where email=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet res= ps.executeQuery();
				
			while(res.next()) {
				u2 =new User();
				u2.setId(res.getInt(1));
				u2.setName(res.getString(2));
				u2.setEmail(res.getString(3));
				u2.setPassword(res.getString(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
				
		return u2;
	}
	
	public boolean checkOldPassword(int userid, String oldPassword) {
		boolean f = false;

		try {
			String sql = "select * from user where id=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setString(2, oldPassword);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	
	public boolean changePassword(int userid, String newPassword) {
		boolean f = false;

		try {
			String sql = "update user set password=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, userid);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
}
