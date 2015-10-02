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
import org.cuatrovientos.consolerp.model.Employee;
import org.cuatrovientos.consolerp.model.Employee;

/**
 * 
 * @author Bego Lopez
 */
public class EmployeeDAO {
	
	private Connection connection;
	
	public EmployeeDAO() {
		connection = new DataSource().getConnection();
	}
	/**
	 * select all employees
	 * @return
	 */
	public Vector<Employee> selectAll (){
		Vector<Employee> employees = new Vector<Employee>();
		
		String sqlSelect = "select * from employee";
		Statement statement;
		
		try{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sqlSelect);
			
			while (resultSet.next()){
				Employee employee = new Employee(resultSet.getInt("id"), resultSet.getString("name"),resultSet.getString("phone"));
				employees.addElement(employee);
			}
		}catch (SQLException e){
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		
		return employees;
	}
	/**
	 * insert new employee
	 * @param employee
	 * @return
	 */
	public int insert(Employee employee) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("insert into employee values (?,?,?)");

			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setString(3, employee.getPhone());
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
	 * updates a employee
	 * @param employee
	 * @return
	 */
	public int update(Employee employee) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("update employee set name=?, set phone=? where id=?");

			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getPhone());
			preparedStatement.setInt(3, employee.getId());
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
	 * delete one employee
	 * @return
	 */
	public int delete(int id) {
		int[] result;
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("delete from employee where id=?");

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
	public Employee selectById(int id) {
		Employee employee = new Employee();
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("select * from employee where id = ? ");

			preparedStatement.setInt(1, 3);
			preparedStatement.addBatch();
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
			 employee = new Employee(resultSet.getInt("id"), resultSet.getString("name"),resultSet.getString("phone"));
			}
		} catch (SQLException e) {
			System.err.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return employee;
	}
}
