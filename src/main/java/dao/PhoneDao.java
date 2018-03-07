package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Address;
import model.Phone;
import model.Website;

public class PhoneDao {
	public static PhoneDao instance = null;
	public static PhoneDao getInstance() {
		if(instance == null) {
			instance = new PhoneDao();
		}
		return instance;
	}
	public int createPhoneForPerson(int personId, Phone phone) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				
				String sql= "INSERT INTO `phone` (phone,`primary`, username, person_id) VALUES (?, ?, ? ,?)";
				
				statement = connection.prepareStatement(sql);
				statement.setString(1, phone.getPhone());
				statement.setBoolean(2, phone.isPrimary());
				statement.setString(3, phone.getUsername());
				statement.setInt(4, phone.getPerson_id());
				
				result = statement.executeUpdate();
				
				
				statement.close();
				connection.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
public int updatePrimaryPhone(String username, Phone phone) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				
				String sql= "UPDATE phone SET phone = ?  WHERE username = ? AND phone.primary = true";
				statement = connection.prepareStatement(sql);
				statement.setString(1, phone.getPhone());
				statement.setString(2, phone.getUsername());
				
				result = statement.executeUpdate();
				
				statement.close();
				connection.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
