/**
 * 
 */
package org.cuatrovientos.consolerp;

import java.util.Scanner;
import java.util.Vector;

import org.cuatrovientos.consolerp.dao.EmployeeDAO;
import org.cuatrovientos.consolerp.model.Employee;

/**
 * @author BegoLo
 *
 */
public class ManageEmployee extends ManageTable{
	private EmployeeDAO employeeDAO;
	private Scanner reader;
	
	/**
	 * constructor
	 * @param reader
	 */
	public ManageEmployee (Scanner reader){
		employeeDAO = new EmployeeDAO();
		this.reader = reader;
	}
	
	@Override
	public void manage(){
		String option = "";
		String name = "";
		String phone = "";
		Employee employee;
		int id = 0;
		
		do{
			showMenu("Employee");
			option = reader.nextLine();
			switch(option){
			case "1":
				Vector<Employee> result = employeeDAO.selectAll();
				System.out.println(result.toString());
				break;
			case "2":
				System.out.println("Enter an Id");
				id = Integer.parseInt(reader.nextLine());
				employee = employeeDAO.selectById(id);
				System.out.println(employee.toString());
				break;
			case "3":
				System.out.println("Enter an Id");
				id = Integer.parseInt(reader.nextLine());
				System.out.println("Enter a name");
				name = reader.nextLine();
				System.out.println("Enter a phone");
				phone = reader.nextLine();
				employee = new Employee(id, name, phone);
				employeeDAO.insert(employee);
				break;
			case "4":
				System.out.println("Enter existing Id");
				id = Integer.parseInt(reader.nextLine());
				System.out.println("Enter a name");
				name = reader.nextLine();
				System.out.println("Enter a phone");
				phone = reader.nextLine();
				employee = new Employee(id, name, phone);
				employeeDAO.update(employee);
				break;
			case "5":
				System.out.println("Enter existing Id");
				id = Integer.parseInt(reader.nextLine());
				employeeDAO.delete(id);
				break;
			case "6":
				System.out.println("Export employees data");
				employeeDAO.exportCVS();
				break;
			case "7":
				System.out.println("Import employees data");
				employeeDAO.importCVS();
				break;
			default:
				System.out.println("Ok, see you around");
				break;
			}
		}while(!option.equals("6"));
	}
	

}
