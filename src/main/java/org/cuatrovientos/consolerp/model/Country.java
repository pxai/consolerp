package org.cuatrovientos.consolerp.model;

public class Country {
	private int id;
	private String name;
	private String abbreviation;
	
			
	public Country(){
		
	}
	
	/**
	 * @param id
	 * @param name
	 * @param abbreviation
	 */
	public Country (int id, String name, String abbreviation){
		this.name = name;
		this.abbreviation = abbreviation;
	    this.id=id;
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
	 * @param namw the name to set
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", abbreviation=" + abbreviation + "]";
	}
	

}
