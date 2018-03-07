package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Widget;

public class WidgetDao {
	public static WidgetDao instance = null;
	public static WidgetDao getInstance() {
		if(instance == null) {
			instance = new WidgetDao();
		}
		return instance;
	}
	
	public int createWidgetForPage(int pageId, Widget widget) {

		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				
				String sql= "INSERT INTO widget " + 
						"(`id`," + 
						"`page`," + 
						"`name`," + 
						"`width`," + 
						"`height`," + 
						"`cssClass`," + 
						"`cssStyle`," + 
						"`text`," + 
						"`order`," + 
						"`type`," + 
						"`url`," + 
						"`shareble`," + 
						"`expandable`," + 
						"`src`," + 
						"`size`," + 
						"`html`)" + 
						"VALUES" + 
						"(?," + 
						"?," + 
						"?," + 
						"?," + 
						"?," + 
						"?," + 
						"?," + 
						"?," + 
						"?," + 
						"?," + 
						"?," + 
						"?," + 
						"?," + 
						"?," + 
						"?," + 
						"?);";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, widget.getId());
				statement.setInt(2, pageId);
				statement.setString(3, widget.getName());
				statement.setInt(4, widget.getWidth());
				statement.setInt(5, widget.getHeight());
				statement.setString(6, widget.getCssClass());
				statement.setString(7, widget.getCssStyle());
				statement.setString(8, widget.getText());
				statement.setInt(9, widget.getOrder());
				statement.setString(10, widget.getType());
				statement.setString(11, widget.getUrl());
				statement.setBoolean(12, widget.isShareble());
				statement.setBoolean(13, widget.isExpandable());
				statement.setString(14, widget.getSrc());
				statement.setInt(15, widget.getSize());
				statement.setString(16, widget.getHtml());
//				
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
	
	public List<Widget> findAllWidgets() {
		List<Widget> widgets = new ArrayList<Widget>();
		Connection connection = null;
		Statement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				statement = connection.createStatement();
				String sql= "SELECT * FROM widget";
				results = statement.executeQuery(sql);
				while(results.next()) {
					int id = results.getInt("id");
					String name = results.getString("name");
					int width = results.getInt("width");
					int height = results.getInt("height");
					String cssClass = results.getString("cssClass");
					String cssStyle = results.getString("cssStyle");
					String text = results.getString("text");
					int order = results.getInt("order");
					String type = results.getString("type");
					String url = results.getString("url");
					boolean shareble = results.getBoolean("shareble");
					boolean expandable = results.getBoolean("expandable");
					String src = results.getString("src");
					int size = results.getInt("size");
					String html = results.getString("html");
					int page = results.getInt("page");
					Widget widget = new Widget(id, name, width, height, cssClass, cssStyle, 
											   text, order, type, url, shareble, expandable,
											   src, size, html, page);
					widgets.add(widget);
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
		
		return widgets;
	}
	
	public Widget findWidgetById(int widgetId) {
	
		Widget widget = new Widget();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				String sql= "SELECT * FROM widget WHERE widget.id = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, widgetId);
				results = statement.executeQuery();
				if(results.next()) {
					int id = results.getInt("id");
					String name = results.getString("name");
					int width = results.getInt("width");
					int height = results.getInt("height");
					String cssClass = results.getString("cssClass");
					String cssStyle = results.getString("cssStyle");
					String text = results.getString("text");
					int order = results.getInt("order");
					String type = results.getString("type");
					String url = results.getString("url");
					boolean shareble = results.getBoolean("shareble");
					boolean expandable = results.getBoolean("expandable");
					String src = results.getString("src");
					int size = results.getInt("size");
					String html = results.getString("html");
					int page = results.getInt("page");
					widget = new Widget(id, name, width, height, cssClass, cssStyle, 
										text, order, type, url, shareble, expandable,
										src, size, html, page);
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
		
		return widget;
	}

	public List<Widget> findWidgetsForPage(int pageId) {
		
		List<Widget> widgets = new ArrayList<Widget>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				
				String sql= "SELECT * FROM widget JOIN page ON page.id = widget.page WHERE page.id = ? ";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, pageId);
				results = statement.executeQuery();
				while(results.next()) {
					int id = results.getInt("id");
					String name = results.getString("name");
					int width = results.getInt("width");
					int height = results.getInt("height");
					String cssClass = results.getString("cssClass");
					String cssStyle = results.getString("cssStyle");
					String text = results.getString("text");
					int order = results.getInt("order");
					String type = results.getString("type");
					String url = results.getString("url");
					boolean shareble = results.getBoolean("shareble");
					boolean expandable = results.getBoolean("expandable");
					String src = results.getString("src");
					int size = results.getInt("size");
					String html = results.getString("html");
					int page = results.getInt("page");
					Widget widget = new Widget(id, name, width, height, cssClass, cssStyle, 
											   text, order, type, url, shareble, expandable,
											   src, size, html, page);
					widgets.add(widget);
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
		
		return widgets;
	}
	
	public int updateWidget(int widgetId, Widget widget) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				
				String sql= "UPDATE widget" + 
						" SET" + 
						"`page` =?," + 
						"`name` =?," + 
						"`width` =?," + 
						"`height` =?," + 
						"`cssClass` =?," + 
						"`cssStyle` =?," + 
						"`text` =?," + 
						"`order` =?," + 
						"`type` =?," + 
						"`url` =?," + 
						"`shareble` =?," + 
						"`expandable` =?," + 
						"`src` =?," + 
						"`size` =?," + 
						"`html` =? " + 
						"WHERE widget.id =?";
				
			
				statement = connection.prepareStatement(sql);
				statement.setInt(1, widget.getPageId());
				statement.setString(2, widget.getName());
				statement.setInt(3, widget.getWidth());
				statement.setInt(4, widget.getHeight());
				statement.setString(5, widget.getCssClass());
				statement.setString(6, widget.getCssStyle());
				statement.setString(7, widget.getText());
				statement.setInt(8, widget.getOrder());
				statement.setString(9, widget.getType());
				statement.setString(10, widget.getUrl());
				statement.setBoolean(11, widget.isShareble());
				statement.setBoolean(12, widget.isExpandable());
				statement.setString(13, widget.getSrc());
				statement.setInt(14, widget.getSize());
				statement.setString(15, widget.getHtml());
				statement.setInt(16, widgetId);
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

	public int deleteWidget(int widgetId) {
		
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				String sql= "DELETE FROM widget WHERE widget.id = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, widgetId);
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
