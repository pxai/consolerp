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
import org.cuatrovientos.consolerp.model.Supplier;

/**
 * @author Toni ABC
 *
 */
public class SupplierDAO {

	private Connection connection;

	public SupplierDAO() {
		connection = new DataSource().getConnection();
	}

	/**
	 * select all customers
	 * @return
	 */
	public Vector<Supplier> selectAll() {
		Vector<Supplier> suppliers = new Vector<Supplier>();
		String select = "select * from customer ";
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(select);

			while (resultSet.next()) {
				Supplier supplier = new Supplier(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("phone"));
				suppliers.addElement(supplier);
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return suppliers;
	}

	/**
	 * select one Customer
	 * @param id
	 * @return
	 */
	public Supplier selectById(int id) {
		Supplier supplier = new Supplier();
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("select * from supplier where id = ? ");

			preparedStatement.setInt(1, id);
			preparedStatement.addBatch();
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
			 supplier = new Supplier(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("phone"));
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return supplier;
	}

	/**
	 * insert new customer
	 * @param customer
	 * @return
	 */
	public int insert(Supplier supplier) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("insert into supplier values (?,?,?)");

			preparedStatement.setInt(1, supplier.getId());
			preparedStatement.setString(2, supplier.getName());
			preparedStatement.setString(3, supplier.getPhone());
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
	public int update(Supplier supplier) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("update supplier set name=?, phone=? where id=?");

			preparedStatement.setString(1, supplier.getName());
			preparedStatement.setString(2, supplier.getPhone());
			preparedStatement.setInt(3, supplier.getId());
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
					connection.prepareStatement("delete from supplier where id=?");

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
