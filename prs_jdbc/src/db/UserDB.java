package db;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.User;

public class UserDB implements DAO<User> {

	
	private Connection getConnection() throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/prs";
		String username = "prs_user";
		String pwd = "sesame";
		Connection conn = DriverManager.getConnection(dbUrl, username, pwd);
		return conn;
	}
	@Override
	public User get(int id) {
		String sql = "SELECT * FROM user" + 
				" where ID = ?";
	try (Connection conn = getConnection();
		 PreparedStatement ps = conn.prepareStatement(sql)) {
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {				
			String userName = rs.getString("UserName");
			String password = rs.getString("Password");
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			String phoneNumber = rs.getString("PhoneNumber");
			String email = rs.getString("Email");
			boolean isReviewer = rs.getBoolean("IsReviewer");
			boolean isAdmin = rs.getBoolean("IsAdmin");
			
			User u = new User(id, userName, password, firstName, lastName, phoneNumber,
					email, isReviewer, isAdmin);
			return u;
		}
		else {
			rs.close();
			return null;
		}
	} 
	catch (SQLException e) {
		System.err.println(e);
		return null;
	}

	}

	@Override
	public List<User> getAll() {
		String sql = "SELECT * FROM User";
		List<User> users = new ArrayList<>();
		try (Connection conn = getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {				
				int id = rs.getInt("ID");
				String userName = rs.getString("UserName");
				String password = rs.getString("Password");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String phoneNumber = rs.getString("PhoneNumber");
				String email = rs.getString("Email");
				boolean isReviewer = rs.getBoolean("IsReviewer");
				boolean isAdmin = rs.getBoolean("IsAdmin");
				
				User u = new User(id, userName, password, firstName, lastName, phoneNumber,
						email, isReviewer, isAdmin);
				users.add(u);
			}
		} 
		catch (SQLException e) {
			System.err.println(e);
			users = null;
		}
		return users;
	}

	@Override
	public boolean add(User t) {
		String sql = "INSERT INTO User (UserName,Password,FirstName,LastName,PhoneNumber,"
				+ "Email,IsReviewer,IsAdmin) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1,t.getUserName());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getFirstName());
			ps.setString(4, t.getLastName());
			ps.setString(5, t.getPhoneNumber());
			ps.setString(6, t.getEmail());
			ps.setBoolean(7, t.isAdmin());
			ps.setBoolean(8, t.isReviewer());
			ps.executeUpdate();
			return true;
		} 
		catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}

	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User t) {
		String sql = "DELETE FROM User "+
					 "where ID = ?";
		 try (Connection conn = getConnection();
				 PreparedStatement ps = conn.prepareStatement(sql)) {
			 ps.setInt(1, t.getId());
			 ps.executeUpdate();
			 return true;
		 } catch (SQLException e) {
			System.err.println(e);
			return false;
		}

	}

}