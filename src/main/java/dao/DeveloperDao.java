package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Developer;



public class DeveloperDao {

	public static DeveloperDao instance = null;
	public static DeveloperDao getInstance() {
		if(instance == null) {
			instance = new DeveloperDao();
		}
		return instance;
	}
	
	public int createDeveloper(Developer developer) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				
				String sql= "INSERT INTO person (id, firstName, lastName, username, password, email, dob) VALUES (?, ?, ?, ?, ?, ?, ?)";
				String sql2= "INSERT INTO developer (developer_id, developerKey) VALUES ( (SELECT person.id FROM person WHERE person.username = ?), ?)";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, developer.getId());
				statement.setString(2, developer.getFirstName());
				statement.setString(3, developer.getLastName());
				statement.setString(4, developer.getUsername());
				statement.setString(5, developer.getPassword());
				statement.setString(6, developer.getEmail());
				statement.setString(7, developer.getDob());
				result = statement.executeUpdate();
				
				statement = connection.prepareStatement(sql2);
				statement.setString(1, developer.getUsername());
				statement.setString(2, developer.getDeveloperKey());
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
	
	public List<Developer> findAllDeveloper() {
		List<Developer> developers = new ArrayList<Developer>();
		Connection connection = null;
		Statement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				statement = connection.createStatement();
				String sql= "SELECT * FROM person JOIN developer ON person.id = developer.developer_id";
				results = statement.executeQuery(sql);
				while(results.next()) {
					int id = results.getInt("id");
					String firstName = results.getString("firstName");
					String lastName = results.getString("lastName");
					String username = results.getString("username");
					String password = results.getString("password");
					String email = results.getString("email");
					String dob = results.getString("dob");
					String developerKey = results.getString("developerKey");
					
					Developer developer = new Developer(id, firstName, lastName, username, password, email, dob, developerKey);
					developers.add(developer);
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
		
		return developers;
	}
	
	public Developer findDeveloperById(int developerId) {
	
		Developer developer = new Developer();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018", "DingJin", "123456ASdf");
				String sql= "SELECT * FROM person JOIN developer ON person.id = developer.developer_id WHERE developer.developer_id = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, developerId);
				results = statement.executeQuery();
				if(results.next()) {
					int id = results.getInt("id");
					String firstName = results.getString("firstName");
					String lastName = results.getString("lastName");
					String username = results.getString("username");
					String password = results.getString("password");
					String email = results.getString("email");
					String dob = results.getString("dob");
					String developerKey = results.getString("developerKey");
					developer = new Developer(id, firstName, lastName, username, password, email, dob, developerKey);
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
		
		return developer;
	}

	public Developer findDeveloperByUsername(String username) {
		
		Developer developer = new Developer();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				
				String sql= "SELECT * FROM person JOIN developer ON person.id = developer.developer_id WHERE person.username = ? ";
				statement = connection.prepareStatement(sql);
				statement.setString(1, username);
				results = statement.executeQuery();
				if(results.next()) {
					int id = results.getInt("id");
					String firstName = results.getString("firstName");
					String lastName = results.getString("lastName");
			
					String password = results.getString("password");
					String email = results.getString("email");
					String dob = results.getString("dob");
					String developerKey = results.getString("developerKey");
					developer = new Developer(id, firstName, lastName, username, password, email, dob, developerKey);
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
		
		return developer;
	}
	
	public Developer findDeveloperByCredentials(String username, String password) {
		
		Developer developer = new Developer();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				
				String sql= "SELECT * FROM person JOIN developer ON person.id = developer.developer_id WHERE person.username = ? AND person.password = ?";
				statement = connection.prepareStatement(sql);
				statement.setString(1, username);
				statement.setString(2, password);
				results = statement.executeQuery();
				if(results.next()) {
					int id = results.getInt("id");
					String firstName = results.getString("firstName");
					String lastName = results.getString("lastName");
					String email = results.getString("email");
					String dob = results.getString("dob");
					String developerKey = results.getString("developerKey");
					developer = new Developer(id, firstName, lastName, username, password, email, dob, developerKey);
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
		
		return developer;
	}

	public int updateDeveloper(int developerId, Developer developer) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				
				String sql= "UPDATE person SET firstName = ?, lastName = ?, username = ?, password = ?, email = ?, dob = ? WHERE person.id = ?";
				String sql2= "UPDATE developer SET developerKey = ? WHERE developer.person = ?";
				statement = connection.prepareStatement(sql);
				statement.setString(1, developer.getFirstName());
				statement.setString(2, developer.getLastName());
				statement.setString(3, developer.getUsername());
				statement.setString(4, developer.getPassword());
				statement.setString(5, developer.getEmail());
				statement.setString(6, developer.getDob());
				statement.setInt(7, developerId);
				result = statement.executeUpdate();
				
				statement = connection.prepareStatement(sql2);
				statement.setString(1, developer.getDeveloperKey());
				statement.setInt(2, developerId);
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

	public int deleteDeveloper(int developerId) {
		
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-jin.crfndxk88jhy.us-east-2.rds.amazonaws.com/hw2_Ding_Jin_spring_2018","DingJin","123456ASdf");
				String sql= "DELETE FROM person WHERE person.id = ?";
//				String sql2= "DELETE FROM developer WHERE developer.person = ?";
				
				statement = connection.prepareStatement(sql);
				statement.setInt(1, developerId);
				result = statement.executeUpdate();
				
//				statement = connection.prepareStatement(sql2);
//				statement.setInt(1, developerId);
//				result = statement.executeUpdate();
				
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
