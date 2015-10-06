package org.cuatrovientos.consolerp;

import java.util.Scanner;
import java.util.Vector;

import org.cuatrovientos.consolerp.dao.CountryDao;
import org.cuatrovientos.consolerp.dao.CustomerDAO;
import org.cuatrovientos.consolerp.model.Country;

public class ManageCountry 

	extends ManageTable {
		
		private CountryDao countryDao;
		private Scanner reader;
		
		
		public ManageCountry(Scanner reader) {
			
			countryDao = new CountryDao();
			this.reader = reader;
		}
		
		@Override
		public void manage() {
			String option;
			String name;
			String abbreviation;
			Country country;
			int id = 0;
			do {
				showMenu("Country");

				option = reader.nextLine();

				switch (option) {
				case "1":
					Vector<Country> result = countryDao.selectAll();
					System.out.println(result.toString());
					break;
				case "2":
					System.out.println("Enter an Id");
					id = Integer.parseInt(reader.nextLine());
					country = countryDao.selectById(id);
					System.out.println(country.toString());
					break;
				case "3":
					System.out.println("Enter an Id");
					id = Integer.parseInt(reader.nextLine());
					System.out.println("Enter a name");
					name = reader.nextLine();
					System.out.println("Enter a abbreviation");
					abbreviation = reader.nextLine();
					country = new Country(id, name, abbreviation);
					countryDao.insert(country);
					break;
				case "4":
					System.out.println("Enter existing Id");
					id = Integer.parseInt(reader.nextLine());
					System.out.println("Enter a name");
					name = reader.nextLine();
					System.out.println("Enter a abbreviation");
					abbreviation = reader.nextLine();
					country = new Country(id, name, abbreviation);
					countryDao.update(country);
					break;
				case "5":
					System.out.println("Enter existing Id");
					id = Integer.parseInt(reader.nextLine());
					countryDao.delete(id);
					break;
				default:
					System.out.println("Ok, see you around");
					break;
				}
			} while (!option.equals("6"));
		}
	
}
