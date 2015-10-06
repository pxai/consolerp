/**
 * 
 */
package org.cuatrovientos.consolerp.model;

/**
 * @author unairf
 *
 */
public class State {
	private int id;
	private String name;
	private String country;
	
	/**
	 * @param args
	 */
	public State(int id, String name, String country) {
		this.id = id;
		this.name = name;
		this.country = country;
	}



	public State() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", country=" + country + "]";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	

}
