package org.cuatrovientos.consolerp;

import java.util.Scanner;
import java.util.Vector;

import org.cuatrovientos.consolerp.dao.PayrollDAO;
import org.cuatrovientos.consolerp.model.Payroll;

public class ManagePayroll 
	extends ManageTable {
	
	private PayrollDAO payrollDAO;
	private Scanner reader;

	/**
	 * constructor
	 */
	public ManagePayroll (Scanner reader) {
		payrollDAO = new PayrollDAO();
		this.reader = reader;
	}
	
	@Override
	public void manage() {
		String option;
		
		Payroll payroll;
		int id = 0;
		do {
			showMenu("Payroll");

			option = reader.nextLine();

			switch (option) {
			case "1":
				Vector<Payroll> result = payrollDAO.selectAll();
				System.out.println(result.toString());
				break;
			case "2":
				System.out.println("Enter an Id");
				id = Integer.parseInt(reader.nextLine());
				payroll = payrollDAO.selectById(id);
				System.out.println(payroll.toString());
				break;
			case "3":
				System.out.println("Enter an Id");
				id = Integer.parseInt(reader.nextLine());
				payroll = new Payroll(id);
				payrollDAO.insert(payroll);
				break;
			case "4":
				System.out.println("Enter existing Id");
				id = Integer.parseInt(reader.nextLine());
				payroll = new Payroll(id);
				payrollDAO.update(payroll);
				break;
			case "5":
				System.out.println("Enter existing Id");
				id = Integer.parseInt(reader.nextLine());
				payrollDAO.delete(id);
				break;
			default:
				System.out.println("Ok, see you around");
				break;
			}
		} while (!option.equals("6"));
	}

}
