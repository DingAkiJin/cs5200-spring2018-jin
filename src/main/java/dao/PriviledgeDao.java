package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PriviledgeDao {
	public static PriviledgeDao instance = null;
	public static PriviledgeDao getInstance() {
		if(instance == null) {
			instance = new PriviledgeDao();
		}
		return instance;
	}
	
	public int assignWebsitePriviledge(int developerId, int websiteId, int priviledgeId) {

		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
	
				String sql= "INSERT INTO website_priviledge (website, developer, type) VALUES (?, ?, ?)";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, websiteId);
				statement.setInt(2, developerId);
				String type = null;
				switch (priviledgeId) {
				case 1: type = "create";
				case 2: type = "delete";
				case 3: type = "read";
				case 4: type = "update";
				default:
					break;
				}
				statement.setString(3, type);
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
	
	public int assignPagePriviledge(int developerId, int pageId, int priviledgeId) {

		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
	
				String sql= "INSERT INTO page_priviledge (page, developer, type) VALUES (?, ?, ?)";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, pageId);
				statement.setInt(2, developerId);
				String type = null;
				switch (priviledgeId) {
				case 1: type = "create";
				case 2: type = "delete";
				case 3: type = "read";
				case 4: type = "update";
				default:
					break;
				}
				statement.setString(3, type);
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

	public int deleteWebsitePriviledge(int developerId, int websiteId, int priviledgeId) {
		
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				String sql= "DELETE FROM website_priviledge WHERE website = ? AND developer = ? AND type = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, websiteId);
				statement.setInt(2, developerId);
				String type = null;
				switch (priviledgeId) {
				case 1: type = "create";
				case 2: type = "delete";
				case 3: type = "read";
				case 4: type = "update";
				default:
					break;
				}
				statement.setString(3, type);
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
	
	public int deletePageRole(int developerId, int pageId, int priviledgeId) {
		
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				String sql= "DELETE FROM page_priviledge WHERE page = ? AND developer = ? AND type = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, pageId);
				statement.setInt(2, developerId);
				String type = null;
				switch (priviledgeId) {
				case 1: type = "create";
				case 2: type = "delete";
				case 3: type = "read";
				case 4: type = "update";
				default:
					break;
				}
				statement.setString(3, type);
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
