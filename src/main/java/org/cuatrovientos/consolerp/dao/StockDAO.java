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
import org.cuatrovientos.consolerp.model.Stock;


/**
 * @author Julen
 *
 */
public class StockDAO {

	private Connection connection;

	public StockDAO() {
		connection = new DataSource().getConnection();
	}

	/**
	 * select all stocks
	 * @return
	 */
	public Vector<Stock> selectAll() {
		Vector<Stock> stocks = new Vector<Stock>();
		String select = "select * from stock ";
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(select);

			while (resultSet.next()) {
				Stock stock = new Stock(resultSet.getInt("id"), resultSet.getInt("rack"), resultSet.getString("description"));
				stocks.addElement(stock);
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return stocks;
	}

	/**
	 * select one stock
	 * @param id
	 * @return
	 */
	public Stock selectById(int id) {
		Stock stock = new Stock();
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("select * from stock where id = ? ");

			preparedStatement.setInt(1, 2);
			preparedStatement.addBatch();
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
			 stock = new Stock(resultSet.getInt("id"), resultSet.getInt("rack"), resultSet.getString("description"));
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return stock;
	}

	/**
	 * insert new stock
	 * @param stock
	 * @return
	 */
	public int insert(Stock stock) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("insert into stock values (?,?,?)");

			preparedStatement.setInt(1, stock.getId());
			preparedStatement.setInt(2, stock.getRack());
			preparedStatement.setString(3, stock.getDescription());
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
	 * updates a stock
	 * @param stock
	 * @return
	 */
	public int update(Stock stock) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("update stock set rack=?,description=? where id=?");

			preparedStatement.setInt(1, stock.getId());
			preparedStatement.setInt(2, stock.getRack());
			preparedStatement.setString(3, stock.getDescription());
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
	 * delete one stock
	 * @param id
	 * @return
	 */
	public int delete(int id) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("delete from stock where id=?");

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
