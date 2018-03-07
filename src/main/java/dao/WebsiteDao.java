package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Website;

public class WebsiteDao {
	public static WebsiteDao instance = null;
	public static WebsiteDao getInstance() {
		if(instance == null) {
			instance = new WebsiteDao();
		}
		return instance;
	}
	
	public int createWebsiteForDeveloper(int developerId, Website website) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				
				//LocalDate date = LocalDate.now();
				String sql= "INSERT INTO website (developer, id, name, description, created, updated, visits) VALUES (?, ?, ?, ?, ?, ?, ?)";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, developerId);
				statement.setInt(2, website.getId());
				statement.setString(3, website.getName());
				statement.setString(4, website.getDescription());
				statement.setString(5, website.getCreated());
				statement.setString(6, website.getUpdated());
				statement.setInt(7, website.getVisits());
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
	
	public List<Website> findAllWebsites() {
		List<Website> websites = new ArrayList<Website>();
		Connection connection = null;
		Statement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				statement = connection.createStatement();
				String sql= "SELECT * FROM website";
				results = statement.executeQuery(sql);
				while(results.next()) {
					int id = results.getInt("id");
					String name = results.getString("name");
					String description = results.getString("description");
					String created = results.getString("created");
					String updated = results.getString("updated");
					int visits = results.getInt("visits");
					int developerId = results.getInt("developer");
					Website website = new Website(id, name, description, created, updated, visits, developerId);
					websites.add(website);
				}
				
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
		
		return websites;
	}
	
	public Website findWebsiteById(int websiteId) {
	
		Website website = new Website();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				String sql= "SELECT * FROM website WHERE website.id = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, websiteId);
				results = statement.executeQuery();
				if(results.next()) {
						int id = results.getInt("id");
						String name = results.getString("name");
						String description = results.getString("description");
						String created = results.getString("created");
						String updated = results.getString("updated");
						int visits = results.getInt("visits");
						int developerId = results.getInt("developer");
						website = new Website(id, name, description, created, updated, visits, developerId);
						
					}
				
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
		
		return website;
	}

	public List<Website> findWebsitesForDeveloper(int developerId) {
		
		List<Website> websites = new ArrayList<Website>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				
				String sql= "SELECT * FROM website JOIN developer ON website.developer = developer.developer_id WHERE developer.developer_id = ? ";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, developerId);
				results = statement.executeQuery();
				while(results.next()) {
					int id = results.getInt("id");
					String name = results.getString("name");
					String description = results.getString("description");
					String created = results.getString("created");
					String updated = results.getString("updated");
					int visits = results.getInt("visits");
					Website website = new Website(id, name, description, created, updated, visits, developerId);
					websites.add(website);
				}
				
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
		
		return websites;
	}
	
	public int updateWebsite(int websiteId, Website website) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				
				String sql= "UPDATE website SET developer = ?, name = ?, description = ?, created = ?, "
						+ "updated = ?, visits = ? WHERE website.id = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, website.getDeveloperId());
				statement.setString(2, website.getName());
				statement.setString(3, website.getDescription());
				statement.setString(4, website.getCreated());
				statement.setString(5, website.getUpdated());
				statement.setInt(6, website.getVisits());
				statement.setInt(7, websiteId);
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

	public int deleteWebsite(int websiteId) {
		
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				String sql= "DELETE FROM website WHERE website.id = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, websiteId);
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
