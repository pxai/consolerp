package org.cuatrovientos.consolerp.dao;

import java.sql.Connection;
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
}
