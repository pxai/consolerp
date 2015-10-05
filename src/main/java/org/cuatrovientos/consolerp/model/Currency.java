/**
 * 
 */
package org.cuatrovientos.consolerp.model;

/**
 * @author segoitz-guibert
 *
 */
public class Currency {
	private int id;
	private String name;
	private String abbreviation;
	
	public Currency () {
		
	}
	
	/**
	 * @param id
	 * @param name
	 * @param abbreviation
	 */
	
	public Currency(int id, String name, String abbreviation){
		this.id = id;
		this.name = name;
		this.abbreviation=abbreviation;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}
	/**
	 * @param abbreviation the abbreviation to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	@Override
	public String toString() {
		return "Currency [id=" + id + ", name=" + name + ", abbreviation=" + abbreviation + "]";
	}
}
