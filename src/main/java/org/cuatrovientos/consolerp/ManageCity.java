package org.cuatrovientos.consolerp;

import java.util.Scanner;
import java.util.Vector;

import org.cuatrovientos.consolerp.dao.CityDAO;
import org.cuatrovientos.consolerp.model.City;

public class ManageCity 
	extends ManageTable {
		
		private CityDAO cityDAO;
		private Scanner reader;

		/**
		 * constructor
		 */
		public ManageCity (Scanner reader) {
			cityDAO = new CityDAO();
			this.reader = reader;
		}
		
		@Override
		public void manage() {
			String option;
			String name;
			City city;
			int id = 0;
			int zipcode =0;
			do {
				showMenu("City");

				option = reader.nextLine();

				switch (option) {
				case "1":
					Vector<City> result = cityDAO.selectAll();
					System.out.println(result.toString());
					break;
				case "2":
					System.out.println("Enter an Id");
					id = Integer.parseInt(reader.nextLine());
					city = cityDAO.selectById(id);
					System.out.println(city.toString());
					break;
				case "3":
					System.out.println("Enter an Id");
					id = Integer.parseInt(reader.nextLine());
					System.out.println("Enter a name");
					name = reader.nextLine();
					System.out.println("Enter a zipcode");
					zipcode = Integer.parseInt(reader.nextLine());
					city = new City(id, name, zipcode);
					cityDAO.insert(city);
					break;
				case "4":
					System.out.println("Enter existing Id");
					id = Integer.parseInt(reader.nextLine());
					System.out.println("Enter a name");
					name = reader.nextLine();
					System.out.println("Enter a zipcode");
					zipcode = Integer.parseInt(reader.nextLine());
					city = new City(id, name, zipcode);
					cityDAO.update(city);
					break;
				case "5":
					System.out.println("Enter existing Id");
					id = Integer.parseInt(reader.nextLine());
					cityDAO.delete(id);
					break;
				default:
					System.out.println("Ok, see you around");
					break;
				}
			} while (!option.equals("6"));
		}

}
