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

/**
 * @author Pello Altadill
 *
 */
public class CustomerDAO {

	private Connection connection;

	public CustomerDAO() {
		connection = new DataSource().getConnection();
	}

	/**
	 * select all customers
	 * @return
	 */
	public Vector<Customer> selectAll() {
		Vector<Customer> customers = new Vector<Customer>();
		String select = "select * from customer ";
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(select);

			while (resultSet.next()) {
				Customer customer = new Customer(resultSet.getInt("id"), resultSet.getString("name"));
				customers.addElement(customer);
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return customers;
	}

	/**
	 * select one Customer
	 * @param id
	 * @return
	 */
	public Customer selectById(int id) {
		Customer customer = new Customer();
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("select * from customer where id = ? ");

			preparedStatement.setInt(1, 2);
			preparedStatement.addBatch();
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
			 customer = new Customer(resultSet.getInt("id"), resultSet.getString("name"));
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return customer;
		
	}

	/**
	 * insert new customer
	 * @param customer
	 * @return
	 */
	public int insert(Customer customer) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("insert into customer values (?,?)");

			preparedStatement.setInt(1, customer.getId());
			preparedStatement.setString(2, customer.getName());
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
	public int update(Customer customer) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("update customer set name=? where id=?");

			preparedStatement.setString(1, customer.getName());
			preparedStatement.setInt(2, customer.getId());
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
					connection.prepareStatement("delete from customer where id=?");

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
