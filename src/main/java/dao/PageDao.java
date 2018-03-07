package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Page;

public class PageDao {
	public static PageDao instance = null;
	public static PageDao getInstance() {
		if(instance == null) {
			instance = new PageDao();
		}
		return instance;
	}
	
	public int createPageForWebsite(int websiteId, Page page) {

		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
	
				String sql= "INSERT INTO page (id, website, title, description, created, updated, views) VALUES (?, ?, ?, ?, ?, ?, ?)";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, page.getId());
				statement.setInt(2, websiteId);
				statement.setString(3, page.getTitle());
				statement.setString(4, page.getDescription());
				statement.setString(5, page.getCreated());
				statement.setString(6, page.getUpdated());
				statement.setInt(7, page.getViews());
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
	
	public List<Page> findAllPages() {
		List<Page> pages = new ArrayList<Page>();
		Connection connection = null;
		Statement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				statement = connection.createStatement();
				String sql= "SELECT * FROM page";
				results = statement.executeQuery(sql);
				while(results.next()) {
					int id = results.getInt("id");
					String title = results.getString("title");
					String description = results.getString("description");
					String created = results.getString("created");
					String updated = results.getString("updated");
					int views = results.getInt("views");
					int website = results.getInt("website");
					Page page = new Page(id, title, description, created, updated, views, 
							website);
					pages.add(page);
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
		
		return pages;
	}
	
	public Page findPageById(int pageId) {
	
		Page page = new Page();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				String sql= "SELECT * FROM page WHERE page.id = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, pageId);
				results = statement.executeQuery();
				if(results.next()) {
					int id = results.getInt("id");
					String title = results.getString("title");
					String description = results.getString("description");
					String created = results.getString("created");
					String updated = results.getString("updated");
					int views = results.getInt("views");
					int website = results.getInt("website");
					page = new Page(id, title, description, created, updated, views, 
							website);
				}
				
				statement.close();
				connection.close();
				
			}catch (SQLException e) {
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
		
		return page;
	}

	public List<Page> findPagesForWebsite(int websiteId) {
		
		List<Page> pages = new ArrayList<Page>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				
				String sql= "SELECT * FROM page JOIN website ON page.website = website.id WHERE website.id = ? ";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, websiteId);
				results = statement.executeQuery();
				while(results.next()) {
					int id = results.getInt("id");
					String title = results.getString("title");
					String description = results.getString("description");
					String created = results.getString("created");
					String updated = results.getString("updated");
					int views = results.getInt("views");
					int website = results.getInt("website");
					Page page = new Page(id, title, description, created, updated, views, 
							website);
					pages.add(page);
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
		
		return pages;
	}
	
	public int updatePage(int pageId, Page page) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				
				String sql= "UPDATE page SET website = ?, title = ?, description = ?, created = ?, "
						+ "updated = ?, views = ? WHERE page.id = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, page.getWebsiteId());
				statement.setString(2, page.getTitle());
				statement.setString(3, page.getDescription());
				statement.setString(4, page.getCreated());
				statement.setString(5, page.getUpdated());
				statement.setInt(6, page.getViews());
				statement.setInt(7, pageId);
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

	public int deletePage(int pageId) {
		
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				String sql= "DELETE FROM page WHERE page.id = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, pageId);
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
