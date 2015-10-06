/**
 * 
 */
package org.cuatrovientos.consolerp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import org.cuatrovientos.consolerp.datasource.DataSource;
import org.cuatrovientos.consolerp.model.Customer;
import org.cuatrovientos.consolerp.model.Department;

/**
 * @author OSKAR
 *
 */
public class DepartmentDAO {

	private Connection connection;

	public DepartmentDAO() {
		connection = new DataSource().getConnection();
	}

	/**
	 * select all customers
	 * @return
	 */
	public Vector<Department> selectAll() {
		Vector<Department> departments = new Vector<Department>();
		String select = "select * from customer ";
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(select);

			while (resultSet.next()) {
				Department department = new Department(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("Description"));
				departments.addElement(department);
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return departments;
	}

	/**
	 * select one department 
	 * @param id
	 * @return
	 */
	public Department selectById(int id) {
		Department department = new Department();
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("select * from customer where id = ? ");

			preparedStatement.setInt(1, 2);
			preparedStatement.addBatch();
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
			 department = new Department(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("Description"));
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return department;
	}

	/**
	 * comit sobre comiit, y sobre comit uuno
	 * insert new department
	 * @param department
	 * @return
	 */
	public int insert(Department department) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("insert into customer values (?,?)");

			preparedStatement.setInt(1, department.getId());
			preparedStatement.setString(2, department.getName());
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
	 * updates a department
	 * @param department
	 * @return
	 */
	public int update(Department department) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("update customer set name=? where id=?");

			preparedStatement.setString(1, department.getName());
			preparedStatement.setInt(2, department.getId());
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
					connection.prepareStatement("delete from department where id=?");

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
