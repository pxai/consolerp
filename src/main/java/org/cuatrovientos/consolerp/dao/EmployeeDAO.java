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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.cuatrovientos.consolerp.datasource.DataSource;
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
	public Vector<Employee> selectAll(){
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
	/**
	 * select by id
	 * @param id
	 * @return
	 */
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
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Employee selectByName(String name){
		Employee employee = new Employee();
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("select * from employee where name = '"+name+"'");

			preparedStatement.setString(1,name);
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
	/**
	 * import employees data from cvs
	 */
	public void importCVS (){
		String csvFile = System.getProperty("user.home")+"/employee.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		
		try{
			Vector<Employee> employees = new Vector<Employee>();
			br = new BufferedReader(new FileReader(csvFile));
			
			while((line = br.readLine()) != null){
				String[] employeeData = line.split(cvsSplitBy);
				Employee employee = new Employee(Integer.parseInt(employeeData[0]),employeeData[1],employeeData[2]);
				employees.addElement(employee);
			}
		}catch (FileNotFoundException e) {
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
	}
	/**
	 * Export employees data to cvs
	 */
	public void exportCVS(){
		String comma_delimiter = ",";
		String new_line_separator = "\n";
		String csvFile = System.getProperty("user.home")+"/employee.csv";
		
		FileWriter fileWriter = null;
		try{
			fileWriter = new FileWriter(csvFile);
			Vector<Employee> employeeVector = new Vector<Employee>();
			employeeVector = selectAll();
			for (Employee employee: employeeVector){
				fileWriter.append(String.valueOf(employee.getId()));
				fileWriter.append(comma_delimiter);
				fileWriter.append(employee.getName());
				fileWriter.append(comma_delimiter);
				fileWriter.append(employee.getPhone());
				fileWriter.append(new_line_separator);
			}
			System.out.println("CSV file was created successfully !!!");
		}catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();

		}
		
	}
	
}