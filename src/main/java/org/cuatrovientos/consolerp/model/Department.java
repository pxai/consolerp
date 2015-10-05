package org.cuatrovientos.consolerp.model;
/**
 * 
 * @author OSKAR
 * 
 *
 */
public class Department {
	
	private int clave;
	private String name;
	private String description;
	
	
	public Department(){
		
	}
	/**
	 * @param clave
	 * @param name
	 * @param description
	 */
	public Department(int clave,String name, String description){
		this.clave = clave;
		this.name = name;
		this.description = description;
		
	}
	/**
	 * @return the clave
	 */
	public int getClave() {
		return clave;
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
	 * @return the name
	 */
	public String getDescritpion() {
		return description;
	}
	/**
	 * @param name the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Department [id=" + clave + ", name=" + ", description=" + description + "]";
	}
	
	
	

}
