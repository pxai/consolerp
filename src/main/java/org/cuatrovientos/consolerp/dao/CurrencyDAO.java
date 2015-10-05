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
import org.cuatrovientos.consolerp.model.Currency;
import org.cuatrovientos.consolerp.model.Customer;

/**
 * @author segoitz-guibert
 *
 */
public class CurrencyDAO {
	
	private Connection connection;
	
	public CurrencyDAO(){
		connection = new DataSource().getConnection();
	}
	/**
	 * select all currencies
	 * @return
	 */
	public Vector<Currency> selectAll() {
		Vector<Currency> currencies = new Vector<Currency>();
		String select = "select * from currency ";
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(select);

			while (resultSet.next()) {
				Currency currency= new Currency(resultSet.getInt("id"), resultSet.getString("name"),resultSet.getString("abbreviation"));
				currencies.addElement(currency);
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return currencies;
	}

	/**
	 * select one Currency
	 * @param id
	 * @return
	 */
	public Currency selectById(int id) {
		Currency currency = new Currency();
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("select * from currency where id = ? ");

			preparedStatement.setInt(1, 2);
			preparedStatement.addBatch();
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
			 currency = new Currency(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("abbreviation"));
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return currency;
	}

	/**
	 * insert new currency
	 * @param currency
	 * @return
	 */
	public int insert(Currency currency) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("insert into currency values (?,?,?)");

			preparedStatement.setInt(1, currency.getId());
			preparedStatement.setString(2, currency.getName());
			preparedStatement.setString(3, currency.getAbbreviation());
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
	 * updates a Currency
	 * @param currency
	 * @return
	 */
	public int update(Currency currency) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("update currency set name=?, abbreviation=? where id=?");

			preparedStatement.setString(1, currency.getName());
			preparedStatement.setInt(3, currency.getId());
			preparedStatement.setString(2, currency.getAbbreviation());
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
	 * delete one currency
	 * @return
	 */
	public int delete(int id) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("delete from currency where id=?");

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
