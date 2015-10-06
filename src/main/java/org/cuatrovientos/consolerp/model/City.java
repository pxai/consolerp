package org.cuatrovientos.consolerp.model;

public class City {
	private int id;
	private int zipcode;
	private String name;
	
	public City () {
		
	}
	
	/**
	 * @param id
	 * @param name
	 */
	public City(int id, String name, int zipcode) {
		this.id = id;
		this.name = name;
		this.zipcode = zipcode;
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
	 * @return the id
	 */
	public int getZipcode() {
		return zipcode;
	}
	/**
	 * @param id the id to set
	 */
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + "]";
	}

}
