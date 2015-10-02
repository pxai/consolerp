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
import org.cuatrovientos.consolerp.model.Issue;


/**
 * @author Irene
 *
 */
public class IssueDAO {
	
	private Connection connection;

	public IssueDAO(){
		connection = new DataSource().getConnection();
	}
	
	/**
	 * Select all issue
	 * @return
	 */
	public Vector<Issue> selectAll() {
		Vector<Issue> issues = new Vector<Issue>();
		String select = "select * from issue ";
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(select);

			while (resultSet.next()) {
				Issue issue = new Issue(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description"));
				issues.addElement(issue);
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return issues;
	}
	
	/**
	 * select one issue
	 * @param id
	 * @return
	 */
	 public Issue selectById(int id) {
		Issue issue = new Issue();
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("select * from issue where id = ? ");

			preparedStatement.setInt(1, 2);
			preparedStatement.addBatch();
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
			 issue = new Issue(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description"));
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return issue;
	}
	 
	 /**
	  * insert new issue
	  * @param issue
	  * @return
	  */
	 public int insert(Issue issue) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("insert into issue values (?,?)");

			preparedStatement.setInt(1, issue.getId());
			preparedStatement.setString(2, issue.getName());
			preparedStatement.setString(3, issue.getDescription());
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
	  * updates a issue
	  * @param issue
	  * @return
	  */
	 public int update(Issue issue) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("update issue set name=? where id=?");

			preparedStatement.setInt(1, issue.getId());
			preparedStatement.setString(2, issue.getName());
			preparedStatement.setString(3, issue.getDescription());
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
	  * delete a issue
	  * @param id
	  * @return
	  */
	 public int delete(int id) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("delete from issue where id=?");

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
