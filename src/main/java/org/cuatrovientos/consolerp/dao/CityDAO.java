package org.cuatrovientos.consolerp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.cuatrovientos.consolerp.datasource.DataSource;
import org.cuatrovientos.consolerp.model.City;


public class CityDAO {
	private Connection connection;

	public CityDAO() {
		connection = new DataSource().getConnection();
	}

	/**
	 * select all customers
	 * @return
	 */
	public Vector<City> selectAll() {
		Vector<City> cities = new Vector<City>();
		String select = "select * from city ";
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(select);

			while (resultSet.next()) {
				City city = new City(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("zipcode"));
				cities.addElement(city);
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return cities;
	}

	/**
	 * select one City
	 * @param id
	 * @return
	 */
	public City selectById(int id) {
		City city = new City();
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("select * from city where id = ? ");

			preparedStatement.setInt(1, id );
			preparedStatement.addBatch();
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.first()) {
			 city = new City(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("zipcode"));
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return city;
	}

	/**
	 * insert new customer
	 * @param customer
	 * @return
	 */
	public int insert(City city) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("insert into city values (?,?,?)");

			preparedStatement.setInt(1, city.getId());
			preparedStatement.setString(2, city.getName());
			preparedStatement.setInt(3, city.getZipcode());
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
	 * updates a City
	 * @param city
	 * @return
	 */
	public int update(City city) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("update city set (name=?, zipcode=?) where id=?");

			preparedStatement.setString(1, city.getName());
			preparedStatement.setInt(3, city.getId());
			preparedStatement.setInt(2, city.getZipcode());
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
					connection.prepareStatement("delete from city where id=?");

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
	public Vector<City> selectByName(String name){
		Vector<City> cities = new Vector<City>();
		String select = "select * from city where name ="+name+"";
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(select);
			while (resultSet.next()) {
				City city = new City(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("zipcode"));
				cities.addElement(city);
			}
	
	} catch (SQLException e) {
		System.err.println("Exception " + e.getMessage());
		e.printStackTrace();
	}
		
	return cities;
}
	public Vector<City> importFromCSV(){
		Vector<City> cities = new Vector<City>();
		String csvFile = "/consolerp/import.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

			        // use comma as separator
				String[] city = line.split(cvsSplitBy);
				City city1 = new City(Integer.parseInt(city[0]), city[1], Integer.parseInt(city[2]));
				cities.add(city1);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return cities;
	}
}
