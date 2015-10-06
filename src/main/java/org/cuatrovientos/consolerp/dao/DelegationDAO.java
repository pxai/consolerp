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
import org.cuatrovientos.consolerp.model.Delegation;

/**
 * @author Dani
 *
 */
public class DelegationDAO {

	private Connection connection;

	public DelegationDAO() {
		connection = new DataSource().getConnection();
	}

	/**
	 * select all delegations
	 * @return
	 */
	public Vector<Delegation> selectAll() {
		Vector<Delegation> delegations = new Vector<Delegation>();
		String select = "select * from customer ";
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(select);

			while (resultSet.next()) {
				Delegation customer = new Delegation(resultSet.getInt("clave"), resultSet.getString("name"), resultSet.getString("description"));
				delegations.addElement(customer);
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return delegations;
	}

	/**
	 * select one Delegation
	 * @param id
	 * @return
	 */
	public Delegation selectById(int id) {
		Delegation delegation = new Delegation();
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("select * from customer where id = ? ");

			preparedStatement.setInt(1, 2);
			preparedStatement.addBatch();
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
			 delegation = new Delegation(resultSet.getInt("clave"), resultSet.getString("name"), resultSet.getString("description"));

			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return delegation;
	}

	/**
	 * insert new delegation
	 * @param delegation
	 * @return
	 */
	public int insert(Delegation delegation) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("insert into customer values (?,?)");

			preparedStatement.setInt(1, delegation.getClave());
			preparedStatement.setString(2, delegation.getName());
			preparedStatement.setString(3, delegation.getDescription());
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
	 * updates a Delegation
	 * @param delegation
	 * @return
	 */
	public int update(Delegation delegation) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("update customer set name=? where id=?");

			preparedStatement.setInt(1, delegation.getClave());
			preparedStatement.setString(2, delegation.getName());
			preparedStatement.setString(3, delegation.getDescription());
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
	 * delete one delegation
	 * @return
	 */
	public int delete(int id) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("delete from delegation where id=?");

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
