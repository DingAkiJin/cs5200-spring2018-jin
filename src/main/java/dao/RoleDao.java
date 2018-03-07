package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Role;

public class RoleDao {
	public static RoleDao instance = null;
	public static RoleDao getInstance() {
		if(instance == null) {
			instance = new RoleDao();
		}
		return instance;
	}
	
	public int assignWebsiteRole(int developerId, int websiteId, int roleId) {

		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
	
				String sql= "INSERT INTO website_role (website, developer, type) VALUES (?, ?, ?)";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, websiteId);
				statement.setInt(2, developerId);
				String type = null;
				switch (roleId) {
				case 1: type = "admin";
						break;
				case 2: type = "editor";
						break;
				case 3: type = "owner";
						break;
				case 4: type = "reviewer";
						break;
				case 5: type = "writer";
						break;
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
	
	public List<Role> findPageRoleByPageId(int pageId) {

		List<Role> roles = new ArrayList<Role>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
	
				String sql= "SELECT * FROM page_role WHERE page_role.page = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, pageId);
				results = statement.executeQuery();
				while(results.next()) {
					int id = results.getInt("id");
					int developer = results.getInt("developer");
					int page = results.getInt("page");
					String type = results.getString("type");
					int roleId = -1;
					switch (type) {
					case "admin": roleId = 1;
								  break;
					case "editor": roleId = 2;
								  break;
					case "owner": roleId = 3;
					 			  break;
					case "reviewer": roleId = 4;
								  break;
					case "writer": roleId = 5;
								  break;
					default:
						break;
					}
					Role role = new Role(id, developer, page, roleId);
					roles.add(role);
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
		
		return roles;
		
	}
	
	public int updatePageRole(int roleId, Role role) {

		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
	
				String sql= "UPDATE page_role SET page_role.developer = ?, page_role.page = ?, page_role.type = ? WHERE page_role.id = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, role.getDeveloperId());
				statement.setInt(2, role.getWebsiteId());
				String type = null;
				switch (role.getRoleId()) {
				case 1: type = "admin";
								break;
				case 2: type = "editor";
								break;
				case 3: type = "owner";
								break;
				case 4: type = "reviewer";
								break;
				case 5: type = "writer";
								break;
				default:
					break;
				}
				statement.setString(3, type);
				statement.setInt(4, roleId);
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
	
	public int assignPageRole(int developerId, int pageId, int roleId) {

		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
	
				String sql= "INSERT INTO page_role (page, developer, type) VALUES (?, ?, ?)";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, pageId);
				statement.setInt(2, developerId);
				String type = null;
				switch (roleId) {
				case 1: type = "admin";
								break;
				case 2: type = "editor";
								break;
				case 3: type = "owner";
								break;
				case 4: type = "reviewer";
								break;
				case 5: type = "writer";
								break;
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

	public int deleteWebsiteRole(int developerId, int websiteId, int roleId) {
		
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				String sql= "DELETE FROM website_role WHERE website = ? AND developer = ? AND type = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, websiteId);
				statement.setInt(2, developerId);
				String type = null;
				switch (roleId) {
				case 1: type = "admin";
								break;
				case 2: type = "editor";
								break;
				case 3: type = "owner";
								break;
				case 4: type = "reviewer";
								break;
				case 5: type = "writer";
								break;
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
	
	public int deletePageRole(int developerId, int pageId, int roleId) {
		
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				String sql= "DELETE FROM page_role WHERE page = ? AND developer = ? AND type = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, pageId);
				statement.setInt(2, developerId);
				String type = null;
				switch (roleId) {
				case 1: type = "admin";
								break;
				case 2: type = "editor";
								break;
				case 3: type = "owner";
								break;
				case 4: type = "reviewer";
								break;
				case 5: type = "writer";
								break;
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
