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
import org.cuatrovientos.consolerp.model.Product;

/**
 * @author Aitor Jauregi
 *
 */
public class ProductDAO {
	private Connection connection;

	public ProductDAO() {
		connection = new DataSource().getConnection();
	}

	/**
	 * select all products
	 * @return
	 */
	public Vector<Product> selectAll() {
		Vector<Product> products = new Vector<Product>();
		String select = "select * from product ";
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(select);

			while (resultSet.next()) {
				Product product = new Product(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getFloat("price"));
				products.addElement(product);
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return products;
	}

	/**
	 * select one product
	 * @param id
	 * @return
	 */
	public Product selectById(int id) {
		Product product = new Product();
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("select * from product where id = ? ");

			preparedStatement.setInt(1, 2);
			preparedStatement.addBatch();
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
			 product = new Product(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getFloat("price"));
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return product;
	}

	/**
	 * insert new product
	 * @param product
	 * @return
	 */
	public int insert(Product product) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("insert into product values (?,?,?)");

			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setFloat(3, product.getPrice());
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
	 * updates a Product
	 * @param product
	 * @return
	 */
	public int update(Product product) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("update product set name=?, price=? where id=?");

			preparedStatement.setString(1, product.getName());
			preparedStatement.setFloat(2, product.getPrice());
			preparedStatement.setInt(3, product.getId());
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
	 * delete one product
	 * @return
	 */
	public int delete(int id) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("delete from product where id=?");

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
