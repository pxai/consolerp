package org.cuatrovientos.consolerp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import org.cuatrovientos.consolerp.datasource.DataSource;
import org.cuatrovientos.consolerp.model.Role;



public class RoleDAO {


	private Connection connection;

	public RoleDAO() {
		connection = new DataSource().getConnection();
	}

	/**
	 * select all customers
	 * @return
	 */
	public Vector<Role> selectAll() {
		Vector<Role> roles = new Vector<Role>();
		String select = "select * from role ";
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(select);

			while (resultSet.next()) {
				Role customer = new Role(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description"));
				roles.addElement(customer);
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return roles;
	}

	/**
	 * select one Role
	 * @param id
	 * @return
	 */
	public Role selectById(int id) {
		Role role = new Role();
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("select * from role where id = ? ");

			preparedStatement.setInt(1, 2);
			preparedStatement.addBatch();
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
			 role = new Role(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description"));
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return role;
	}

	/**
	 * insert new customer
	 * @param customer
	 * @return
	 */
	public int insert(Role role) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("insert into role values (?,?,?)");

			preparedStatement.setInt(1, role.getId());
			preparedStatement.setString(2, role.getName());
			preparedStatement.setString(3, role.getDescription());
			preparedStatement.addBatch();
			
			result = preparedStatement.executeBatch();

		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
			return -1;
		} 
		return result[0];
	}

	/**
	 * updates a Customer
	 * @param customer
	 * @return
	 */
	public int update(Role role) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("update role set name=? where id=?");

			preparedStatement.setString(1, role.getName());
			preparedStatement.setInt(2, role.getId());
			preparedStatement.addBatch();
			
			result = preparedStatement.executeBatch();

		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
			return -1;
		} 
		return result[0];
	}

	/**
	 * delete one customer
	 * @return
	 */
	public int delete(int id) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("delete from role where id=?");

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
