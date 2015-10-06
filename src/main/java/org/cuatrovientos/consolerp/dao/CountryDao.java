package org.cuatrovientos.consolerp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.cuatrovientos.consolerp.datasource.DataSource;
import org.cuatrovientos.consolerp.model.Country;


public class CountryDao {
	
	
	private Connection connection;

	public CountryDao() {
		connection = new DataSource().getConnection();
	}
	
	/**
	 * select all countries
	 * @return
	 */
	public Vector<Country> selectAll(){
		Vector<Country> countries = new Vector<Country>();
		String select = "select * from country";
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(select);

			while (resultSet.next()) {
				Country country = new Country(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("abbreviation"));
				countries.addElement(country);
	}
	} catch (SQLException e) {
		System.err.println("Exception " + e.getMessage());
		e.printStackTrace();
	}
	return countries;

	}
	
	
	/**
	 * select one Country
	 * @param id
	 * @return
	 */
	public Country selectById(int id) {
		Country country = new Country();
		try {
			PreparedStatement preparedStatement =

					connection.prepareStatement("select * from country where id = ? ");
					
			preparedStatement.setInt(1, 2);
			preparedStatement.addBatch();
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
			 country = new Country(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("abbreviation"));
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return country;
	}
	
	
	/**
	 * insert new country
	 * @param country
	 * @return
	 */
	public int insert(Country country) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("insert into country values (?,?,?)");

			preparedStatement.setInt(1, country.getId());
			preparedStatement.setString(2, country.getName());
			preparedStatement.setString(3, country.getAbbreviation());
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
	 * updates a Country
	 * @param country
	 * @return
	 */
	public int update(Country country) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					
					connection.prepareStatement("update country set name=?,abbreviation=? where id=?");

			preparedStatement.setString(1, country.getName());
			preparedStatement.setString(2, country.getAbbreviation());
			preparedStatement.setInt(3, country.getId());
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
	 * delete one country
	 * @return
	 */
	public int delete(int id) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("delete from country where id=?");

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
