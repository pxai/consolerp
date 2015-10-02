package org.cuatrovientos.consolerp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import org.cuatrovientos.consolerp.datasource.DataSource;
import org.cuatrovientos.consolerp.model.Customer;
import org.cuatrovientos.consolerp.model.User;

public class UserDAO {
	private Connection connection;
	public UserDAO() {
		connection = new DataSource().getConnection();
	}
	public Vector<User> selectAll() {
		Vector<User> users = new Vector<User>();
		String select = "select * from user ";
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(select);

			while (resultSet.next()) {
				User user = new User(resultSet.getInt("id"), resultSet.getString("login"),resultSet.getString("password"));
				users.addElement(user);
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return users;
	}
	
	public User selectById(int id) {
		User user = new User();
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("select * from user where id = ? ");

			preparedStatement.setInt(1, 2);
			preparedStatement.addBatch();
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
			 user = new User(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("password"));
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return user;
	}
	public int insert(User user) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("insert into customer values (?,?,?)");

			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getLogin());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.addBatch();
			
			result = preparedStatement.executeBatch();

		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
			return -1;
		} 
		return result[0];
	}
	
	public int update(User user) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("update user set login=? set password=? where id=?");

			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setInt(3, user.getId());
			preparedStatement.addBatch();
			
			result = preparedStatement.executeBatch();

		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
			return -1;
		} 
		return result[0];
	}
	
	public int delete(int id) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("delete from user where id=?");

			preparedStatement.setInt(1, id);
			preparedStatement.addBatch();
			
			result = preparedStatement.executeBatch();

		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
			return -1;
		} 
		return result[0];
	}
}
