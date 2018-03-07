package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Address;
import model.Website;

public class AddressDao {
	public static AddressDao instance = null;
	public static AddressDao getInstance() {
		if(instance == null) {
			instance = new AddressDao();
		}
		return instance;
	}
	public int createAddressForPerson(int personId, Address address) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				
				String sql= "INSERT INTO `address` (street1,street2, city, state, zip, `primary`,person_id) VALUES (?, ?, ? ,?, ?, ?,?)";
				
				statement = connection.prepareStatement(sql);
				statement.setString(1, address.getStreet1());
				statement.setString(2, address.getStreet2());
				statement.setString(3, address.getCity());
				statement.setString(4, address.getState());
				statement.setString(5, address.getZip());
				statement.setBoolean(6, address.isPrimary());
      			statement.setInt(7, personId);
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
	
public int deletePrimaryAddress(int personId) {
		
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				String sql= "DELETE FROM address WHERE address.primary = true AND address.person_id = ?";
				
				System.out.println(sql);
				statement = connection.prepareStatement(sql);
				statement.setInt(1, personId);
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
